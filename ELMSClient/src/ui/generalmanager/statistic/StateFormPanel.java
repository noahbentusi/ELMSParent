package ui.generalmanager.statistic;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.statisticblservice.Statisticblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.statistic.StateFormVO;
 /** 
 * 经营状况表,显示开始日期和结束日期以及序号
 * @author czq 
 * @version 2015年12月6日 上午11:33:45 
 */
@SuppressWarnings("serial")
public class StateFormPanel extends MyTablePanel{
	
	private Statisticblservice bl;
	
	private ArrayList<StateFormVO> vos;
	
	private final static int COLUMN_NUM = 5;
	
	public StateFormPanel(Element config , Statisticblservice bl) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
	}

	@Override
	public void updateTableMes() {
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = config.attributeValue("column").split(" ");
		
		vos = bl.getStateForm();
		
		StateFormVO vo;
		
		if(vos!= null){
			data = new Object[vos.size()][COLUMN_NUM];
			for (int i = 0; i < vos.size(); i++) {
				vo = vos.get(i);
				data[i][0] = String.valueOf(i);
				data[i][1] = MyDate.getPartDay(vo.startDate);
				data[i][2] = MyDate.getPartDay(vo.endDate);
				data[i][3] = vo.deposits==null?"0":String.valueOf(vo.deposits.size());
				data[i][4] = vo.pays==null?"0":String.valueOf(vo.pays.size());
				
			}
			
			
		}
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
	}

	public StateFormVO getAForm() {
		if(getSelectedRow() == -1){
			new TipsDialog("您未选择任何一行");
			return null;
		}else{
			return vos.get(getSelectedRow());
		}
	}

}
