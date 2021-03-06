package approval;

import java.util.ArrayList;

import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import bl.DataTool;
import blservice.DocApprovalService;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午10:15:25
 */
public class MockDocs implements DocApprovalService {

	@Override
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		switch (type) {
		case arriveYYDoc:
			return DataTool.getDocList(DocType.arriveYYDoc);
		case arriveZZDoc:

			return DataTool.getDocList(DocType.arriveYYDoc);
		case inStoreDoc:

			return DataTool.getDocList(DocType.arriveYYDoc);
		case loadDoc:

			return DataTool.getDocList(DocType.arriveYYDoc);
		case order:

			return DataTool.getDocList(DocType.order);
		case outStoreDoc:

			return DataTool.getDocList(DocType.outStoreDoc);
		case sendGoodDoc:

			return DataTool.getDocList(DocType.sendGoodDoc);
		case transferDoc:

			return DataTool.getDocList(DocType.transferDoc);

		default:
			break;
		}
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID) {
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeOneDocState(String docID) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocVO getByID(String ID, DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDayDocCount(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
