package data.strategydata;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import po.strategy.ConstPO;
import po.strategy.EstiDatePO;
/** 
 * 
 * @author czq 
 * @version 2015年12月4日 上午9:01:25 
 */
public class StrategyDataImplTest {
	
	StrategyDataImpl testframeforczq;
	int a[] = {1,2,3};
	ConstPO po = new ConstPO(200, 100, 300, 100, 300, 200, 2000, 500, 300, 1, 10, 2, a);
	@Before
	public void setUp() throws Exception {
		testframeforczq = new StrategyDataImpl();
		
	}

	@Test
	public void testGetConst() throws RemoteException {
		testframeforczq.setEstiDatePO(new EstiDatePO(2, 2.5, 4.5, 1, 2, 2, 0.5));
	}

	@Test
	public void testSetConst() throws RemoteException {
		testframeforczq.setConst(po);
	}

}
