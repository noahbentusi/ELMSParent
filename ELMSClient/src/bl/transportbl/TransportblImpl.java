package bl.transportbl;

import java.util.ArrayList;
import java.util.Date;

import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import ds.transportdataservice.Transportdataservice;
import util.DocType;
import util.ResultMessage;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.DocVO;
import vo.LoadDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:52:01 
 *
 */
public class TransportblImpl implements Transportblservice {
	Transportdataservice tansportData;
	Orderblservice orderbl;
	StrategyblService strategybl;
	public ResultMessage add(LoadDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveYYDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(TransferDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getExpense(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
