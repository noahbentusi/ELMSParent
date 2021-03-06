package bl.approvalbl;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import bl.BusinessLogicDataFactory;
import blservice.approvalblservice.Approvalblservice;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.transportblservice.Transportblservice;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午9:16:14
 */
public class ApprovalController implements Approvalblservice {

	Transportblservice transportbl;
	Orderblservice orderbl;
	InStoreDocService inStoreDocService;
	OutStoreDocService outStoreDocService;
	Approval approval;

	public ApprovalController() {
		transportbl = BusinessLogicDataFactory.getFactory().getTransportblservice();
		inStoreDocService = BusinessLogicDataFactory.getFactory().getInstoreService();
		outStoreDocService = BusinessLogicDataFactory.getFactory().getOutStoreService();
		orderbl = BusinessLogicDataFactory.getFactory().getOrderBussinessLogic();
		approval = new Approval(transportbl, orderbl, inStoreDocService, outStoreDocService);

		
	}
	
	
	@Override
	public ArrayList<? extends DocVO> getBills(DocType type) {
		return approval.getBills(type);
	}

	@Override
	public ResultMessage approveOne(DocVO vo) {
		return approval.approveOne(vo);
	}

	@Override
	public ResultMessage approveMany(ArrayList<? extends DocVO> docsVO) {
		
		return approval.approveMany(docsVO);
	}

}
