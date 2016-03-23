package pakki;

import static org.junit.Assert.*;
import java.util.List;
import pakki.Flight;
import pakki.FlightSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class TestFlightSearch {
	private FlightSearch fs;
	
	@Before
	public void setUp() throws Exception {
		fs=new FlightSearch();
	}

	@After
	public void tearDown() throws Exception {
		fs=null;
	}

	@Test
	public void testRightSearch() {
		List<Flight> list=fs.search(3, "time", "AK", "RVK");
		Iterator<Flight> it=list.iterator();
		while(it.hasNext()){
			Flight k=it.next();
			assertTrue(3<=k.getAvailableSeats());
			assertEquals("AK", k.getArrivalAirport());
			assertEquals("RVK", k.getDepartureAirport());
		}
	}
	
	@Test
	public void testAvailableSeats(){
		List<Flight> list=fs.search(80, "time", "AK", "RVK");
		Iterator<Flight> it=list.iterator();
		while(it.hasNext()){
			Flight k=it.next();
			assertTrue(80<=k.getAvailableSeats());
		}
	}
	
	@Test
	public void testWrongSearch(){
		List<Flight> list=fs.search(3, "time", "AK", "RVK");
		Iterator<Flight> it=list.iterator();
		while(it.hasNext()){
			Flight k=it.next();
			assertFalse(3>k.getAvailableSeats());
			assertFalse("RVK"==k.getArrivalAirport());
			assertFalse("AK"==k.getDepartureAirport());
		}
	}
	@Test
	public void testEmpty(){
		List<Flight> list=fs.search(3, "time", "hundur", "kisa");
		Iterator<Flight> it=list.iterator();
		int i=0;
		while(it.hasNext()){
			i++;
		}
		assertTrue(i==0);
	}
		
		
}
