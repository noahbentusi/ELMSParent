package ui.generalmanager.people;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTablePanel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月5日 上午9:24:16 
 */
@SuppressWarnings("serial")
public class PeopleMesPanel extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	private ArrayList<E>
	
	
	public PeopleMesPanel(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = new String[COLUMN_NUMS];
		columnNames[0] = "机构ID";
		columnNames[1] = "人员ID";
		columnNames[2] = "姓名";
		columnNames[3] = "职位";
		columnNames[4] = "手机号码";
		
		
		
	}

	@Override
	protected void initTable() {
		
		
	}

}
