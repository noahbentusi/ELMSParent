package test.store;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import bl.storebl.StoreController;
import blservice.storeblservice.StoreblService;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:39:34 
 */
public class StoreControllerTest {
	
	StoreblService bl ;
	ResultMessage result;
	
	
	@Before
	public void setUp() throws Exception {
		bl = new StoreController();
	}

	@Test
	public void testShow() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testExportExcel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAlarmValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDocLists() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeDocsState() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeOneDocState() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateOutStoreDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateInStoreDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowOutStoreDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowInstoreDocs() {
		fail("Not yet implemented");
	}

}