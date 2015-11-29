package ui.util;

import java.awt.CardLayout;

import javax.swing.JPanel;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyPanel;
 /** 
 * 界面跳转控制器父类
 * @author czq 
 * @version 2015年11月26日 下午3:08:33 
 */
public abstract class PanelController {
	/**
	 * 全局panel
	 */
	protected MyPanel mainPanel;
//	/**vr43
//	 * 左边条
//	 */
//	protected MyPanel leftBar;
	/**
	 * 中间将要更改的panel
	 */
	protected JPanel changePanel;
	/**
	 * 布局管理器
	 */
	protected CardLayout panelManager;
	
	public PanelController(MyPanel initialPanel , Element root) {
		super();
		this.mainPanel = initialPanel;
		initial(root);
		
		
	}
	
	/**
	 * 初始化panel
	 */
	protected abstract void initPanel(Element e);
	/**
	 * 初始化按钮
	 */
	protected abstract void initButtons(Element e) ;
	/**
	 * 向panel上左侧栏的Buttons
	 */
	protected abstract void addButtons();
	/**
	 * 增加panel
	 */
	protected abstract void addPanels();
	/**
	 * 增加监听，将按钮与panel联系起来
	 */
	protected abstract void addListeners();
	
	public abstract void  setAllButtonUnClicked();
	
	public abstract void setAllButtonVisable(boolean state);
	
	
	/**
	 * 跳回主界面
	 */
	public  void  jumpBackToMainWindow() {
		panelManager.show(changePanel, StaticMessage.MAIN_WINDOW);
		setAllButtonVisable(false);
	}
	
	
	/**
	 * 父类自初始化
	 * @param e
	 */
	private void initial(Element e){
		panelManager = new CardLayout();
		this.changePanel = new JPanel(panelManager);
		if(e==null){
			System.err.println("-----------配置文件出错");
		}
		changePanel.setVisible(false);
		changePanel.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				Integer.parseInt(e.attributeValue("width")),
				Integer.parseInt(e.attributeValue("height")));
		this.mainPanel.add(changePanel);
	}
	
	public CardLayout getPanelManager() {
		return panelManager;
	}
}
