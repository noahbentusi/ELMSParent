package ui.storemanager.outstore;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.storemanager.StoreManagerController;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyBackListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import util.TransferWay;
import vo.store.OutStoreDocVO;
import bl.storebl.StoreController;

/**
 * @author ymc
 * @version 创建时间：2015年12月9日 下午8:00:05
 *
 */
@SuppressWarnings("serial")
public class AddOutStorePanel extends MyPanel implements DocPanelForApproval{

	MyPictureButton confirmButton;
	MyPictureButton returnButton;

	MyLabel title;
	MyLabel IDL;
	MyLabel dateL;
	MyLabel sendCityL;
	MyLabel orderL;
	MyLabel shipWayL;
	MyLabel transferDocL;

	MyTextField IDT;
	MyDatePicker picker;
	MyComboBox sendCityC;
	MyComboBox shipWayC;

	MyTextField transferDocT;
	MyTextField orderT;

	StoreController bl;
	PanelController controller;

	public AddOutStorePanel(Element config, StoreController bl, StoreManagerController controller) {

		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		//为了单据审批
		if(controller == null){
			return;
		}
		
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		IDT = new MyTextField(e.element("ID"));
		IDT.setText("CKD"+MyDate.getDatePart(MyDate.getNowTime())+UserfulMethod.toSeven(bl.getDayDocCount(DocType.outStoreDoc)));
		IDT.setEditable(false);

		orderT = new MyTextField(e.element("order"));
		transferDocT = new MyTextField(e.element("transferDoc"));
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		sendCityL = new MyLabel(e.element("sendCity"));
		orderL = new MyLabel(e.element("order"));
		shipWayL = new MyLabel(e.element("shipWay"));

		transferDocL = new MyLabel(e.element("transferDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
		sendCityC = new MyComboBox(e.element("sendCityC"));
		shipWayC = new MyComboBox(e.element("shipWayC"));

	}

	@Override
	protected void addCompoment() {
		add(IDL);
		add(IDT);
		add(confirmButton);
		add(dateL);
		add(orderL);
		add(orderT);
		add(picker);
		add(returnButton);
		add(sendCityC);
		add(sendCityL);
		add(title);
		add(shipWayC);
		add(transferDocT);
		add(shipWayL);
		add(transferDocL);

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new AddOutStoreListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "OutStorePanel", controller,true));

	}

	class AddOutStoreListener extends ConfirmListener {
		OutStoreDocVO out;
		public AddOutStoreListener(MyPictureButton button) {
			super(button);
		}

		@Override
		protected void reInitial() {
			orderT.setText("");
			IDT.setText("CKD"+MyDate.getDatePart(MyDate.getNowTime())+UserfulMethod.toSeven(bl.getDayDocCount(DocType.outStoreDoc)));

			transferDocT.setText("");

		}

		@Override
		protected void updateMes() {
			OutStorePanel outPanel = (OutStorePanel) controller.getPanelMap().get("OutStorePanel");
			outPanel.table.updateTableMes();

		}

		@Override
		protected boolean checkDataValid() {
			
			
			ArrayList<String> orders = UserfulMethod.stringToArray(orderT.getText());
//			System.out.println((String) sendCityC.getSelectedItem());
			City loc = City.toCity((String) sendCityC.getSelectedItem());
//			System.out.println((String) shipWayC.getSelectedItem());
			TransferWay shipWay = TransferWay.getTransferWay((String) shipWayC.getSelectedItem());
			String transferDoc = transferDocT.getText();
			String ID = IDT.getText();
			MyDate date = picker.getMyDate();
			SimpleDataFormat[] datas = new SimpleDataFormat[orders.size()+1];
			datas[0] = new SimpleDataFormat(transferDoc, DataType.ID, "中转单");
			for (int i = 1; i < orders.size()+1; i++) {
				datas[i] = new SimpleDataFormat(orders.get(i-1), DataType.BarCode, "订单号");
			}
			out = new OutStoreDocVO(ID, date, orders, loc, transferDoc, shipWay);
			return UserfulMethod.dealWithData(datas);

		}

		@Override
		protected boolean saveToSQL() {
			if(bl.generate(out)==ResultMessage.SUCCESS){
				
//				reInitial();
				
				new TipsDialog("生成成功");
				bl.updateStore(out.loc, out.shipWay,out.ID,out.type);
			}
			return true;

		}

	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		orderT.setEditable(false);
		transferDocT.setEditable(false);
		IDT.setEditable(false);
		sendCityC.setEnabled(false);
		shipWayC.setEnabled(false);
		
		confirmButton.setVisible(false);
		returnButton.setVisible(false);
	
	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
		MyPictureButton back = new MyPictureButton();
		add(back);
		back.addMouseListener(new MyBackListener(back, changePanel, backStr));
		
	}

	@Override
	public void setMessage(Object o) {
		if(o == null){
			return;
		}
		OutStoreDocVO vo = (OutStoreDocVO) o;
		IDT.setText(vo.ID);
		orderT.setText(UserfulMethod.orderArrayToString(vo.orders));
		transferDocT.setText(vo.transferDoc);
		picker.setTime(vo.date);
		sendCityC.setSelectedItem(vo.loc.getName());
		shipWayC.setSelectedItem(vo.shipWay.getStoreLocation());
	}
}
