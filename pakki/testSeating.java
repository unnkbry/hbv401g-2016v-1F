package pakki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pakki.Seating;
import pakki.DataBaseConnection;

public class testSeating {
	Seating s;
	DataBaseConnection db=new DataBaseConnection();

	@Before
	public void setUp() throws Exception {
			//db.updateDB("delete from seating " );
			//db.updateDB("insert into seating values('"+1+"','"+0+"','"+5+"','"+true+"')");
			s=new Seating(6,6,1);
		}

	@After
	public void tearDown() throws Exception {
		s=null;
	}

	@Test
	public void testSeatsStatus() {
				assertTrue(s.getSeatStatus("01A"));
				assertTrue(s.getSeatStatus("01B"));
				assertTrue(s.getSeatStatus("04A"));
				assertFalse(s.getSeatStatus("01C"));
				assertTrue(s.getSeatStatus("01D"));
				assertTrue(s.getSeatStatus("05D"));
				//assertFalse(s.getSeatStatus("05W"));
				s.makeUnavailable("01A");
				assertFalse(s.getSeatStatus("01A"));
	}
	
	@Test
	public void testGetEmpty() {
		String [][] e=s.getEmpty();
		for(int n=0;n<5;n++){
			for(int m=0;m<5;m++){
				if(s.getSeatStatus(s.turnToString(n, m)))
					assertEquals(s.turnToString(n,m), e[n][m]);
				else
					assertEquals("   ", e[n][m]);
			}
		}
	}
}
