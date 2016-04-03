package pakki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pakki.Seating;

public class testSeating {
	Seating s;

	@Before
	public void setUp() throws Exception {
			s=new SeatingMock(20, 6, 1);
			}

	@After
	public void tearDown() throws Exception {
		s=null;
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
	
	@Test (expected = IllegalArgumentException.class)
	public void test2Long() {
	    s.turnFromString("Hellú");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test2Short() {
	    s.turnFromString("ee");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNotNumber() {
	    s.turnFromString("AAA");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWrongString() {
	    s.turnFromString("01T");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWrongNumber(){
		s.turnFromString("21A");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWithSymbol(){
		s.turnFromString("-1A");
	}

	@Test
	public void testMakeUnavailable(){
		for(int n=0;n<5;n++){
			for(int m=0;m<5;m++){
				if(s.getSeatStatus(s.turnToString(n, m)))
					s.makeUnavailable(s.turnToString(n, m));
				assertFalse(s.getSeatStatus(s.turnToString(n, m)));
				}
			}
		}
	}
