package bl.financebl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.CostVO;
import vo.DepositVO;
import vo.PayVO;
import vo.ProfitVO;
import blservice.financeblservice.BankAccountService;
import blservice.financeblservice.CostService;
import blservice.financeblservice.DepositService;
import blservice.financeblservice.PayService;
import blservice.financeblservice.ProfitService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:17:23 
 */
public class FinanceController implements BankAccountService, CostService, PayService , ProfitService,DepositService{

	public ProfitVO getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage create(PayVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage add(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CostVO> showCosts() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayVO> showPays() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage create(DepositVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DepositVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
