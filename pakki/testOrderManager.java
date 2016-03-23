package pakki;

import static org.junit.Assert.*;
import pakki.OrderManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testOrderManager {
	private OrderManager om;

	@Before
	public void setUp() throws Exception {
		om=new OrderManager();
	}

	@After
	public void tearDown() throws Exception {
		om=null;
	}

	@Test
	public void testmakePersons() {
		assertNotNull(om.makePersons("name", "id", false, true, "A1"));
	}

}
