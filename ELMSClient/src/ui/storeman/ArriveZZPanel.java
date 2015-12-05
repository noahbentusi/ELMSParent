package ui.storeman;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Element;
import org.junit.experimental.theories.Theories;

import blservice.transportblservice.Transportblservice;
import config.StaticMessage;
import ui.inital.mainFrame;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
import util.MyDate;

/**
 * @author ymc
 * @version 创建时间：2015年12月3日 上午10:21:14
 *
 */
public class ArriveZZPanel extends MyPanel {
	Transportblservice bl;

	private MyPictureButton addButton;
	private MyPictureButton returnButton;
	private MyLabel nowDoc;

	private ArriveZZTablePanel arriveZZTablePanel;

	private PanelController controller;

	public ArriveZZPanel(Element config, Transportblservice bl, PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();

	}

	@Override
	protected void initButtons(Element e) {
		addButton = new MyPictureButton(e.element("add"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {
		nowDoc = new MyLabel(e.element("nowDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		MyDate date = getNowTime();
		arriveZZTablePanel = new ArriveZZTablePanel(e.element("table"), bl, date);

	}

	private MyDate getNowTime() {
		MyDate date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String[] d = df.format(new Date()).split("-");// new Date()为获取当前系统时间
		try {
			date = new MyDate(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("得到当前时间出错");
		}
		return date;
	}

	@Override
	protected void addCompoment() {
		this.add(addButton);
		this.add(returnButton);
		this.add(nowDoc);
		this.add(arriveZZTablePanel);
	}

	@Override
	protected void addListener() {
		addButton.addMouseListener(new MyJumpListener(addButton, "AddArriveZZPanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller));
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

}
