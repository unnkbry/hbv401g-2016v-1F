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
		s=i[0];
		String [] a=i[0].split("\\.");
		List<Flight> list = fs.search(3, s, "AK", "AK");
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k=it.next();
			String p=k.getDate();
			s= p.toLocaleString();
			i=s.split(" ");
			s=i[0];
			String [] b=i[0].split("\\.");
			if(a[1]=="1")
				boolean bo= a[2]==b[2]&&Math.abs(a[1]-b[1].toString())<=1||b[2]-1==a[2]&&b[1]==12;
			else if(a[1]=="12")
				boolean bo= b[2]==a[2]&&Math.abs(b[1]-a[1])<=1||b[2]+1=a[2]&&b[1]==1;			
			else
				boolean bo= b[2]==a[2]&&Math.abs(b[1]-a[1])<=1;
			assertTrue(bo);
		}
	}
	
	@Test
	public void testpplCountZero(){
		List<Flight> list = fs.search(0, "time", "AK", "AK");
		assertNull(list);
	}
	
	@Test
	public void testpplCountNegative(){
		List<Flight> list = fs.search(-2, "time", "AK", "AK");
		assertNull(list);
	}
	

}
