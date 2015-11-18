package po;

import java.io.Serializable;

import util.MyDate;
import util.DocState;
import util.DocType;

/**
 * 派送单PO
 * 
 * @author JerryZhang
 *
 */
public class SendGoodDocPO extends DocPO implements Serializable{
	
	public SendGoodDocPO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 快递员
	 */
	private String SendMan;
	/**
	 * 订单条形码号
	 */
	private String orderBarCode;

	public SendGoodDocPO(String iD, MyDate date, String sendMan,
			String orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		SendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	

	public String getSendMan() {
		return SendMan;
	}

	public void setSendMan(String sendMan) {
		SendMan = sendMan;
	}

	public String getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(String orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

}
