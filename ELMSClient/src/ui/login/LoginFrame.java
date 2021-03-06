package ui.login;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import net.RMIManage;

import org.dom4j.Element;

import ui.common.CommonFrame;
import ui.config.UserfulMethod;
import ui.initial.mainFrame;
import ui.tools.MyFrame;
import ui.tools.MyOptionPane;
import ui.tools.MyPasswordField;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import util.FormatMes;
import vo.account.AccountVO;
import bl.BusinessLogicDataFactory;
import blservice.usermesblservice.UserMesblservice;

/**
 * 
 * @author czq
 * @version 2015年11月22日 下午11:50:27
 */
@SuppressWarnings("serial")
public class LoginFrame extends MyFrame {

	
	private LoginPanel mainpanel;

	private MyPictureButton closeButton;

	private MyPictureButton login;
	
	private MyPictureButton set;
	// 查询订单
	private MyPictureButton checkOrder;

	// private MyCheckBox rememberMe;

	private MyTextField userName;

	private MyPasswordField password;

	private UserMesblservice bl;

	private LoginFrame frame;

	private Element config;
	

	

	public LoginFrame(Element config) {
		super(config);
		
		
		
		
		this.config = config;

		if (RMIManage.netInit()) {
			bl = BusinessLogicDataFactory.getFactory().getUserMesBusinessLogic();
		}

		mainpanel = new LoginPanel();

		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextField(config.element(CompomentType.TEXTFIELDS.name()));
		initLabel(config.element(CompomentType.LABELS.name()));

		initOtherCom(config);
		config.attributeValue("width");
		this.frame = this;
		
		addCom();
		addListener();
		this.setContentPane(mainpanel);
//		this.validate();
//		this.repaint();
//		this.mainpanel.repaint();
		this.setVisible(true);
	}

	private void initLabel(Element config) {

	}

	private void initButtons(Element config) {
		login = new MyPictureButton(config.element("login"));
		checkOrder = new MyPictureButton(config.element("checkOrder"));
		closeButton = new MyPictureButton(config.element("close"));
		set = new MyPictureButton(config.element("set"));
	}

	private void initTextField(Element config) {
		userName = new MyTextField(config.element("userName"));

	}

	private void initOtherCom(Element config) {

		// rememberMe = new MyCheckBox(config.element("rememberMe"));
		password = new MyPasswordField(config.element("password"));
	
	}

	private void addCom() {

		mainpanel.setLayout(null);
		mainpanel.add(userName);
		mainpanel.add(password);
		mainpanel.add(checkOrder);
		mainpanel.add(login);
		mainpanel.add(closeButton);
		mainpanel.add(set);
		// mainpanel.add(rememberMe);
		

	}

	private void addListener() {
		login.addMouseListener(new MyLoginListener(login));
		closeButton.addMouseListener(new MyCloseListener(closeButton));
		checkOrder.addMouseListener(new MyCheckOrderListener(checkOrder));
		set.addMouseListener(new MyIPListener(set));
		password.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 dealWithChoose();
				 }
				 
				 
			 }
		});
	}
	
	private void dealWithChoose(){

		String id = userName.getText();
		String passwords = new String(password.getPassword());
		FormatMes format;
		format = UserfulMethod.checkID(id);
		if (format == FormatMes.ILEGAL_CHAR) {
			new MyOptionPane(frame, "用户名有非法字符，请您重新输入~", JOptionPane.INFORMATION_MESSAGE);
			userName.setText("");
			return;
		} else if (format == FormatMes.WRONG_LENGTH) {
			new MyOptionPane(frame, "用户名长度不足，请您重新输入~", JOptionPane.INFORMATION_MESSAGE);
			return;

		}

		if (RMIManage.netInit()) {
			bl = BusinessLogicDataFactory.getFactory().getUserMesBusinessLogic();
		} else {
			return;
		}

		AccountVO vo;
		vo = bl.login(new AccountVO(id, passwords, null));

		if (vo == null) {
			new MyOptionPane(frame, "用户名或密码错误，请您重新输入");
		} else {
			System.out.println("登录成功，用户类型为 " + vo.type.name());
			new mainFrame(config.getParent(), vo);
			frame.dispose();
		}
	}
	
	
	class MyIPListener extends MyPictureButtonListener{

		public MyIPListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			new SetIPPane(null);
		}
		
	}
	
	
	class MyLoginListener extends MyPictureButtonListener {
		
		public MyLoginListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			dealWithChoose();
		
		}

	}

	class MyCloseListener extends MyPictureButtonListener {
		public MyCloseListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			frame.dispose();
			System.exit(0);
		}

		
	}

	class MyCheckOrderListener extends MyPictureButtonListener {
		public MyCheckOrderListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			// 服务器未开启提示
			if (RMIManage.netInit()) {
				bl = BusinessLogicDataFactory.getFactory().getUserMesBusinessLogic();
			} else {
				return;
			}
			// 单独开启 普通查询人员的 frame
			CommonFrame commonFrame = new CommonFrame(config.element("commonFrame"));
			frame.dispose();
		}

		
	}

}
