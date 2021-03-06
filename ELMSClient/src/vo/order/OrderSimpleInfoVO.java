package vo.order;

import util.DocType;

/**
 * 订单VO类
 * 
 * @author xc
 * @date 2015/11/15
 */
public class OrderSimpleInfoVO {
	/**
	 * 得到简易物流信息的条形码
	 */
	public String orderBarCode;
	/**
	 * 得到简易信息的地点
	 */
	public String place;
	
	/**
	 * 得到简易信息的单据属性
	 */
	public DocType type;
	
	/**
	 * 得到简易信息的时间
	 */
	public String time;
	
	public OrderSimpleInfoVO() {
	}
	public OrderSimpleInfoVO(String orderBarCode,String place,String time,DocType type){
		this.orderBarCode=orderBarCode;
		this.place=place;
		this.time=time;
		this.type=type;
	}
}
