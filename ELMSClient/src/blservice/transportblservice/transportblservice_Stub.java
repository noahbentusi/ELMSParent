package blservice.transportblservice;

import java.util.ArrayList;
import java.util.Date;

import util.DocType;
import util.ResultMessage;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.DocVO;
import vo.LoadDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;

public class transportblservice_Stub implements Transportblservice{

	public ResultMessage add(LoadDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(util.Date date) {
		ArrayList<LoadDocVO> temp=new ArrayList<LoadDocVO>();
		return temp;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(util.Date date) {
		ArrayList<SendGoodDocVO> temp=new ArrayList<SendGoodDocVO>();
		util.Date arriveDate = null;
		return temp;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveYYDocs(Date date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(Date date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage add(TransferDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(Date date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		// TODO 自动生成的方法存根
		return null;
	}

	public double getExpense(DocType type) {
		// TODO 自动生成的方法存根
		return 1000;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(Date date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(Date date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DocVO> getDocLists() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
