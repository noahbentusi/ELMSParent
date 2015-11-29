package ui.generalmanager;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;

/**
 * 总经理界面跳转控制器
 * 
 * @author czq
 * @version 2015年11月26日 下午3:41:24
 */
public class GeneralManagerController extends PanelController {

	private GeneralManagerMain GMmainpanel;
	private ConstSetPanel constSetPanel;
	private ApprovalDocsPanel approvalPanel;
	private InstManagePanel instManagePanel;
	private PeopleManagePanel peopleManagePanel;
	private StatisticPanel statisticPanel;

	private MySideBarButton constsetButton;
	private MySideBarButton approvalButton;
	private MySideBarButton instManageButton;
	private MySideBarButton peopleManageButton;
	private MySideBarButton statisticButton;
	private MySideBarButton salaryStrategySetButton;


	private final String GMmainpanelStr = StaticMessage.MAIN_WINDOW;
	private final String constSetPanelStr = "ConstSetPanel";
	private final String approvalPanelStr = "ApprovalPanel";
	private final String instManagePanelStr = "InstManagePanel";
	private final String peopleManagePanelStr = "PeopleManagePanel";
	private final String statisticPanelStr = "StatisticPanel";
	private final String salaryStrategySetnStr = "SalaryStrategySetPanel";

	public GeneralManagerController(MyPanel initialPanel, Element e) {
		super(initialPanel, e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
		// panelManager.show(changePanel, "GMmainpanel");
		changePanel.setVisible(true);
	}

	@Override
	protected void initButtons(Element e) {
		constsetButton = new MySideBarButton(e.element("ConstSet"));
		instManageButton = new MySideBarButton(e.element("InstManage"));
		approvalButton = new MySideBarButton(e.element("GMApproval"));
		statisticButton = new MySideBarButton(e.element("Statistic"));
		salaryStrategySetButton = new MySideBarButton(
				e.element("SalaryStrategySet"));
		peopleManageButton = new MySideBarButton(e.element("PeopleManage"));

	}

	@Override
	protected void addButtons() {

		mainPanel.add(constsetButton);
		mainPanel.add(instManageButton);
		mainPanel.add(approvalButton);
		mainPanel.add(statisticButton);
		mainPanel.add(salaryStrategySetButton);
		mainPanel.add(peopleManageButton);

	}

	@Override
	protected void initPanel(Element e) {
		GMmainpanel = new GeneralManagerMain(e.element(GMmainpanelStr));
		approvalPanel = new ApprovalDocsPanel(e.element(approvalPanelStr));
		constSetPanel = new ConstSetPanel(e.element(constSetPanelStr));
		statisticPanel = new StatisticPanel(e.element(statisticPanelStr));
		instManagePanel = new InstManagePanel(e.element(instManagePanelStr));
		peopleManagePanel = new PeopleManagePanel(
				e.element(peopleManagePanelStr));
	}

	@Override
	protected void addPanels() {
		changePanel.add(GMmainpanel, GMmainpanelStr);
		changePanel.add(approvalPanel, approvalPanelStr);
		changePanel.add(constSetPanel, constSetPanelStr);
		changePanel.add(statisticPanel, statisticPanelStr);
		changePanel.add(instManagePanel, instManagePanelStr);
		changePanel.add(peopleManagePanel, peopleManagePanelStr);

	}

	@Override
	protected void addListeners() {
		constsetButton.addMouseListener(new MySideBarListener(constsetButton, this, constSetPanelStr));
		instManageButton.addMouseListener(new MySideBarListener(instManageButton, this , instManagePanelStr));
		approvalButton.addMouseListener(new MySideBarListener(approvalButton, this , approvalPanelStr));
		statisticButton.addMouseListener(new MySideBarListener(statisticButton, this , statisticPanelStr));
		salaryStrategySetButton.addMouseListener(new MySideBarListener(salaryStrategySetButton, this , salaryStrategySetnStr));
		peopleManageButton.addMouseListener(new MySideBarListener(peopleManageButton, this , peopleManagePanelStr));

	}


	@Override
	public void setAllButtonUnClicked() {
		constsetButton.setMyIcon(ButtonState.NORMAL);
		instManageButton.setMyIcon(ButtonState.NORMAL);
		approvalButton.setMyIcon(ButtonState.NORMAL);
		statisticButton.setMyIcon(ButtonState.NORMAL);
		salaryStrategySetButton.setMyIcon(ButtonState.NORMAL);
		peopleManageButton.setMyIcon(ButtonState.NORMAL);		
	}

}
