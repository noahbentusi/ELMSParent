package util;
/** 
 * @author ymc 
 * @version 创建时间：2015年12月9日 下午8:42:20 
 *
 */
public enum TransferWay  {
	plane("飞机"), train("火车"),car("汽车");
	
	private final String name;
	private TransferWay(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static TransferWay getTransferWay(String name) {
		switch (name) {
		case "飞机":
			
			return plane;
		case "火车":
			
			return train;
		case "汽车":
			
			return car;
		default:
			return null;
		}
	}
}