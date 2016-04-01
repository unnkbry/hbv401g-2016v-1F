package pakki;

import static org.junit.Assert.*;
import java.util.List;
import pakki.Flight;
import pakki.FlightSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.Date;

public class TestFlightSearch {
	private FlightSearch fs;

	@Before
	public void setUp() throws Exception {
		fs = new FlightSearch();
	}

	@After
	public void tearDown() throws Exception {
		fs = null;
	}

	@Test
	public void testDestinationSearch() {
		List<Flight> list = fs.search(3, "time", "AK", "RVK");
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k = it.next();
			assertEquals("AK", k.getArrivalAirport());
			assertEquals("RVK", k.getDepartureAirport());
		}
	}

	@Test
	public void testAvailableSeats() {
		List<Flight> list = fs.search(80, "time", "AK", "RVK");
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k = it.next();
			assertTrue(80 <= k.getAvailableSeats());
		}
	}

	@Test
	public void testWrongSearch() {
		List<Flight> list = fs.search(3, "time", "AK", "RVK");
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k = it.next();
			assertFalse(3 > k.getAvailableSeats());
			assertFalse("RVK" == k.getArrivalAirport());
			assertFalse("AK" == k.getDepartureAirport());
		}
	}

	@Test
	public void testEmpty() {
		List<Flight> list = fs.search(3, "time", "AK", "AK");
		Iterator<Flight> it = list.iterator();
		assertFalse(it.hasNext());
	}
	
	
	@Test
	public void testTime(){
		Date d= new Date();
		String s=d.toLocaleString();
		String[] i=s.split(" ");
		String [] a=i[0].split("\\.");
		int searchedYear=Integer.parseInt(a[2]);
		int searchedMonth=Integer.parseInt(a[1]);
		List<Flight> list = fs.search(3, s, "AK", "RVK");
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k=it.next();
			Date p=k.getDate();
			s= p.toLocaleString();
			i=s.split("\\.");
			int foundMonth=Integer.parseInt(i[1]);
			i=i[2].split(" ");
			int foundYear = Integer.parseInt(i[0]);
			boolean bo=false;
			if(searchedMonth==1)
				bo= searchedYear==foundYear&&Math.abs(searchedMonth-foundMonth)<=1||foundYear-1==searchedYear&&foundMonth==12;
			else if(searchedMonth==12)
				bo= searchedYear==foundYear&&Math.abs(searchedMonth-foundMonth)<=1||foundYear+1==searchedYear&&foundMonth==1;			
			else
				bo= searchedYear==foundYear&&Math.abs(searchedMonth-foundMonth)<=1;
			assertTrue(bo);
		}
	}
	
	@Test
	public void testpplCountZero(){
		List<Flight> list = fs.search(0, "time", "AK", "RVK");
		assertNull(list);
	}
	
	@Test
	public void testpplCountNegative(){
		List<Flight> list = fs.search(-2, "time", "AK", "RVK");
		assertNull(list);
	}
}