package ui.saleman.SendGoodDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.tools.CheckDocPanel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:33:08 
 */
@SuppressWarnings("serial")
public class SendGoodDocCheckPanel extends CheckDocPanel {

	public SendGoodDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new SendGoodMesTable(e.element(tableStr));
		addDocPanel = new SendGoodDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable);
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		// TODO Auto-generated method stub

	}



	@Override
	protected void addListener() {
		super.addListener();
	}

	@Override
	protected void addDifferComp() {
		// TODO Auto-generated method stub
		
	}

}
