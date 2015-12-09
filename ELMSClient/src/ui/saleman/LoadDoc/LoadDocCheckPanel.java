package ui.saleman.LoadDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:27:08 
 */
@SuppressWarnings("serial")
public class LoadDocCheckPanel extends CheckDocPanel{

	public LoadDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName) {
		super(config, changePanel , checkDocName , addDocName);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		addDocPanel = new LoadDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr);
		messageTable = new LoadDocMesTable(e.element(tableStr));
		
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