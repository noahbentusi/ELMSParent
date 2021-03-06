package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.MyDate;
import util.City;
import util.DocState;
import util.DocType;

/**
 * 装车单PO
 * 
 * @author JerryZhang
 *
 */
public class LoadDocPO extends DocPO implements Serializable {
	

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 本营业厅编号
	 */
	private String YYID;
	/**
	 * 汽运编号
	 */
	private String loadDocID;
	/**
	 * 到达地
	 */
	private City arriveCity;
	/**
	 * 车辆代号
	 */
	private String carID;
	/**
	 * 监运员姓名
	 */
	private String supervisor;
	/**
	 * 押送员代号
	 */
	private String escort;
	/**
	 * 订单号集合
	 */
	private ArrayList<String> orderBarCodes;
	
	public LoadDocPO() {}

	public LoadDocPO(String iD, MyDate date, String yYID, String loadDocID, City arriveCity, String carID,
			String supervisor, String escort, ArrayList<String> orderBarCodes) {
		super(iD, DocType.loadDoc, date, DocState.wait);
		this.YYID = yYID;
		this.loadDocID = loadDocID;
		this.arriveCity = arriveCity;
		this.carID = carID;
		this.supervisor = supervisor;
		this.escort = escort;
		this.orderBarCodes = orderBarCodes;
	}

	public LoadDocPO(String iD, DocType type, MyDate date, DocState state, String yYID, String loadDocID,
			City arriveCity, String carID, String supervisor, String escort,ArrayList<String> orderBarCodes) {

		super(iD, type, date, state);
		this.YYID = yYID;
		this.loadDocID = loadDocID;
		this.arriveCity = arriveCity;
		this.carID = carID;
		this.supervisor = supervisor;
		this.escort = escort;
		this.orderBarCodes = orderBarCodes;
	}

	public String getYYID() {
		return YYID;
	}

	public void setYYID(String yYID) {
		this.YYID = yYID;
	}

	public String getLoadDocID() {
		return loadDocID;
	}

	public void setLoadDocID(String loadDocID) {
		this.loadDocID = loadDocID;
	}

	public City getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(City arriveCity) {
		this.arriveCity = arriveCity;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getEscort() {
		return escort;
	}

	public void setEscort(String escort) {
		this.escort = escort;
	}

	public ArrayList<String> getOrderBarCodes() {
		return orderBarCodes;
	}

	public void setOrderBarCodes(ArrayList<String> orderBarCodes) {
		this.orderBarCodes = orderBarCodes;
	}

}
