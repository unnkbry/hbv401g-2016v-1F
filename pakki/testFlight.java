package pakki;
import pakki.Flight; 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testFlight {
	private Flight f;

	@Before
	public void setUp() throws Exception {
		f=new Flight("arrivalTime", "departureTime", "arrivalAirport", "departureAirport", 300 );
	}
	
	
	@After
	public void tearDown() throws Exception {
		f=null;
	}

	@Test
	public void testGetDepartureTime() {
		assertEquals("departureTime", f.getDepartureTime());
	}
	
	@Test
	public void testGetArrivalTime(){
		assertEquals("arrivalTime", f.getArrivalTime());
	}

}
