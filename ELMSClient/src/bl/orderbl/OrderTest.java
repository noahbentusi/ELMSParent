package bl.orderbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import net.RMIManage;

import org.junit.Before;
import org.junit.Test;

import util.DataServiceType;
import vo.order.OrderSimpleInfoVO;
import ds.orderdataservice.OrderDataService;
import bl.BusinessLogicDataFactory;
 /** 
 * 
 * @author czq 
 * @version 2015年12月17日 下午8:42:08 
 */
public class OrderTest {
	Order order;
	@Before
	public void setUp() throws Exception {
		order = new Order((OrderDataService) RMIManage.getDataService(DataServiceType.OrderDataService));
	}

	@Test
	public void testGetSimpleInfo() {
		ArrayList<OrderSimpleInfoVO> vos = order.getSimpleInfo("123456");
		System.out.println(vos.size());
		
		
		fail("Not yet implemented");
	}

}
