package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.finance.PayPO;
import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import po.transport.PayDocPO;
import util.MyDate;
import util.ResultMessage;
import data.financedata.FinanceDataImpl;
import data.transportdata.TransportDataImpl;
import dataSuper.DataSuperClass;
import ds.statisticdataservice.StatisticDataService;

/**
 * 
 * @author czq
 * @version 2015年11月5日 下午8:46:54
 */
public class StatisticDataImpl extends DataSuperClass implements
		StatisticDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String billTable = "bill";

	private static final String stateFormTable = "StateForm";

	private static final String costIncomeForm = "CostIncomeForm";

	public StatisticDataImpl() throws RemoteException {
	}

	public void initial() throws RemoteException {
		// initialFromSQL(billTable);
		// initialFromSQL(stateFormTable);
		initialFromSQL(costIncomeForm);

	}

	public ArrayList<StateFormPO> getStateForm() throws RemoteException {
		ArrayList<Object> temp = helper.readManyFromSerFile(stateFormTable);

		if (temp == null) {
			return null;
		}
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>(temp.size());
		for (int i = 0; i < temp.size(); i++) {
			pos.add((StateFormPO) temp.get(i));
		}

		return (pos == null) ? null : pos;
	}

	public ArrayList<CostIncomePO> getCostIncomeForm() throws RemoteException {
		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();
		try {
			sql = "SELECT * FROM " + costIncomeForm;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new CostIncomePO(Integer.parseInt(result.getString(1)),
						Integer.parseInt(result.getString(2)), MyDate
								.getDate(result.getString(3)), MyDate
								.getDate(result.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (pos == null) ? null : pos;
	}

	public ResultMessage bulidStateForm(StateFormPO po) throws RemoteException {
		if (helper.writeToSerFile(po, stateFormTable, true)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}

	}

	public ResultMessage CostIncomeForm(CostIncomePO po) throws RemoteException {

		return addToSQL(costIncomeForm, String.valueOf(po.getIncome()),
				String.valueOf(po.getExpense()),
				MyDate.toString(po.getStartDate()),
				MyDate.toString(po.getEndDate()));
	}

	public ResultMessage bulidBill(BillPO po) throws RemoteException {
		if (helper.writeToSerFile(po, billTable, true)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<BillPO> getBills() throws RemoteException {
		ArrayList<Object> temp = helper.readManyFromSerFile(billTable);
		
		if(temp == null){
			return null;
		}
		
		ArrayList<BillPO> pos = new ArrayList<BillPO>(temp.size());
		if (temp != null) {
			for (int i = 0; i < temp.size(); i++) {
				pos.add((BillPO) temp.get(i));
			}

		}

		return pos.isEmpty() ? null : pos;

	}

	@Override
	public ArrayList<PayPO> getDatePays(MyDate start, MyDate end) throws RemoteException {
		FinanceDataImpl impl = new FinanceDataImpl();
		
		ArrayList<PayPO> pos = impl.getPayPO();
		
		if(pos==null || pos.isEmpty()){
			return null;
		}
		ArrayList<PayPO> newPos = new ArrayList<>(pos.size());
		
		for (PayPO payPO : pos) {
			if(MyDate.isBetween(start, end, payPO.getTime())){
				newPos.add(payPO);
			}
		}
		
		
		return newPos.isEmpty()?null:newPos;
	}

	@Override
	public ArrayList<PayDocPO> getDatePayDocs(MyDate start, MyDate end)throws RemoteException {
		TransportDataImpl impl = new TransportDataImpl();
		ArrayList<PayDocPO> pos = impl.getPays();
		
		if(pos==null || pos.isEmpty()){
			return null;
		}
		ArrayList<PayDocPO> newPos = new ArrayList<>(pos.size());
		
		for (PayDocPO payPO : pos) {
			if(MyDate.isBetween(start, end, payPO.getDate())){
				newPos.add(payPO);
			}
		}
		
		
		return newPos.isEmpty()?null:newPos;
	}

}
