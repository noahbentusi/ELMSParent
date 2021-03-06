package ui.saleman.SendGoodDoc;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.transport.SendGoodDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 派送单信息表
 * @author czq 
 * @version 2015年12月8日 下午8:34:24 
 */
@SuppressWarnings("serial")
public class SendGoodMesTable extends MyTablePanel {
	Transportblservice bl;
	
	ArrayList<SendGoodDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 4;
	
	public SendGoodMesTable(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}
	
	
	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getDaySendDocs(MyDate.getNowTime());
		
		if(vos == null || vos.isEmpty()){
			vos = new ArrayList<>();
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		SendGoodDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
			data[i][0] = vo.ID;
			data[i][1] = MyDate.getPartDay(vo.date);
			data[i][2] = vo.sendMan;
			data[i][3] = String.valueOf(vo.orderBarCode.size());
			
		}

	}
	
	@Override
	public void searchID(String id) {
		super.searchID(id);
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 0);
				new TipsDialog("成功找到一条信息", Color.GREEN);
				break;
			}
		}
		new TipsDialog("未找到任何一条信息");
	}
	
	@Override
	public void addOneData(Object o , int type) {
		SendGoodDocVO vo = (SendGoodDocVO) o;
		String[] temp = new String[COLUMN_NUM];
		temp[0] = vo.ID;
		temp[1] = MyDate.getPartDay(vo.date);
		temp[2] = vo.sendMan;
		temp[3] = String.valueOf(vo.orderBarCode.size());
		addOneRow(temp);;
	}
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
	}
	@Override
	public void showAllMessages() {
		removeAllRows();
//		System.out.println(vos.size());
		for (int i = 0; i < vos.size(); i++) {
//			System.out.println(i);
			addOneData(vos.get(i), 0);
		}
	}
}
