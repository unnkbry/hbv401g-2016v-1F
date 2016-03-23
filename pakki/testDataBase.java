package pakki;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pakki.DataBaseConnection;

public class testDataBase {
	private DataBaseConnection db;
	@Before
	public void setUp() throws Exception {
		db =new DataBaseConnection();
	}
	
	
	@After
	public void tearDown() throws Exception {
		db=null;
	}
	
	@Test
	public void testSearch() {
		assertNotNull(db.getFromDB("select * from flights"));
	}
	
	@Test
	public void testConditionedSearch(){
		assertNotNull(db.getFromDB("select * from flights where arrivalairport='RVK'"));
	}

}
