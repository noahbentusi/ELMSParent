package po.transport;

import java.util.ArrayList;

import po.DocPO;
import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;

/**
 * 中转单PO
 * 
 * @author JerryZhang
 *
 */
public class TransferDocPO extends DocPO {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	/**
//	 * 中转单ID
//	 */
//	private  int TransferDocID;
	/**
	 * 航班号/车次/车牌号
	 */
	private  String transferWayID;
	/**
	 * 出发地
	 */
	private  City sendCity;
	/**
	 * 货柜号
	 */
	private  int containerNum;
	/**
	 * 监装员
	 */
	private  String loadManName;
	/**
	 * 所有托运单号
	 */
	private  ArrayList<String> orderBarCode;

	public TransferDocPO() {}

	public TransferDocPO(String iD, util.MyDate date,
			 String transferWayID,
			City sendCity, int containerNum, String loadManName,
			ArrayList<String> orderBarCode) {
		super(iD,DocType.transferDoc, date, DocState.wait);
		this.transferWayID = transferWayID;
		this.sendCity = sendCity;
		this.containerNum = containerNum;
		this.loadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}

	public TransferDocPO(String iD, DocType type, MyDate date, DocState state,
			String transferWayID, City sendCity, int containerNum,
			String loadManName, ArrayList<String> orderBarCode) {
		super(iD, type, date, state);
		this.transferWayID = transferWayID;
		this.sendCity = sendCity;
		this.containerNum = containerNum;
		this.loadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}


//	public int getTransferDocID() {
//		return TransferDocID;
//	}
//
//	public void setTransferDocID(int transferDocID) {
//		TransferDocID = transferDocID;
//	}

	


	public String getTransferWayID() {
		return transferWayID;
	}

	public void setTransferWayID(String transferWayID) {
		this.transferWayID = transferWayID;
	}

	public City getSendCity() {
		return sendCity;
	}

	public void setSendCity(City sendCity) {
		this.sendCity = sendCity;
	}

	public int getContainerNum() {
		return containerNum;
	}

	public void setContainerNum(int containerNum) {
		this.containerNum = containerNum;
	}

	public String getLoadManName() {
		return loadManName;
	}

	public void setLoadManName(String loadManName) {
		this.loadManName = loadManName;
	}

	public ArrayList<String> getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(ArrayList<String> orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

}
