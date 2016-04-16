package pakki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testSeats {
	private Seats s;

	@Before
	public void setUp() throws Exception {
		s=new Seats(1);
	}

	@After
	public void tearDown() throws Exception {
		s=null;
	}

	@Test
	public void testGetEmpty() {
		String [][] e=s.getEmpty();
		for(int n=0;n<e.length;n++){
			for(int m=0;m<e[0].length;m++){
				if(s.getSeatStatus(s.turnToString(n, m)))
					assertEquals(s.turnToString(n,m), e[n][m]);
				else
					assertEquals("   ", e[n][m]);
			}
		}
	}
	
	@Test
	public void testMakeUnavailable(){
		s.makeUnavailable("01A");
		assertFalse(s.getSeatStatus("01A"));
	}
}
	
	
	


