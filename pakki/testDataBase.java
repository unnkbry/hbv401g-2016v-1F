package pakki;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pakki.DataBaseConnection;
import java.sql.ResultSet;

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
	public void testSearchNotNull() {
		assertNotNull(db.getFromDB("SELECT * FROM flights"));
	}
	
	@Test
	public void testConditionedSearchNotNull(){
		assertNotNull(db.getFromDB("SELECT * FROM flights WHERE arrivalairport='RVK'"));
	}
	
	@Test
	public void testConditionedSearch(){
		ResultSet rs=db.getFromDB("select * from flights where departureairport='AK'");
		try{
			while(rs.next()){
					assertEquals("AK", rs.getString("departureairport"));
				}
			}
		catch(Exception e){
			e.printStackTrace();
	    	System.err.println(e.getClass().getName()+": "+e.getMessage());
	    	System.exit(0);
	    	}
		}
	}

