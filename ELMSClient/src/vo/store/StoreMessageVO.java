package vo.store;

import java.util.ArrayList;

import util.City;

/**
 * 库存信息VO
 * @author ymc
 *
 */
public class StoreMessageVO {
	/**
	 * 所在城市
	 */
	public City location;
	/**
	 * 区位置
	 */
	public String storeLoc;

	/**
	 * 库存数量
	 */
	public int number;
	/**
	 * 入库单集合
	 */
	public ArrayList<InStoreDocVO> inStoreDocs;
	/**
	 * 出库单集合
	 */
	public ArrayList<OutStoreDocVO> OutStoreDocs;
	public StoreMessageVO() {
		// TODO Auto-generated constructor stub
	}
	public StoreMessageVO(City location, String storeLoc, int number, ArrayList<InStoreDocVO> inStoreDocs,
			ArrayList<OutStoreDocVO> outStoreDocs) {
		super();
		this.location = location;
		this.storeLoc = storeLoc;
		this.number = number;
		this.inStoreDocs = inStoreDocs;
		OutStoreDocs = outStoreDocs;
	}


	
	
}
