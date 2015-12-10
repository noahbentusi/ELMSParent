package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.OutStoreDocService;
import ds.storedataservice.StoreDataService;
import po.store.InStoreDocPO;
import po.store.OutStoreDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.store.OutStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:58 
 *
 */
public class OutStoreDocImpl implements OutStoreDocService {
	
	StoreDataService storeData;
	Orderblservice orderbl;
	
	public OutStoreDocImpl(StoreDataService storeDataService) {
		
		storeData = storeDataService;
	}
	
	public ArrayList<OutStoreDocVO> show() {
	ArrayList<OutStoreDocPO> pos = new ArrayList<OutStoreDocPO>();
		
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(0));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(1));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(2));
		try {
			pos = storeData.getOut();
			pos.size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.err.println("pos is null");
			return null;
		}
		ArrayList<OutStoreDocVO> vos = new ArrayList<OutStoreDocVO>(pos.size());
		
		for(OutStoreDocPO po : pos ){
			vos .add((OutStoreDocVO)VOPOchange.POtoVO(po));
		} 
		return vos;
	}

	public ResultMessage generate(OutStoreDocVO vo) {
		OutStoreDocPO po = (OutStoreDocPO) VOPOchange.VOtoPO(vo);
		try {
			return storeData.addOut(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}



	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
