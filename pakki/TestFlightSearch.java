package pakki;

import static org.junit.Assert.*;
import java.util.List;
import pakki.Flight;
import pakki.FlightSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFlightSearch {
	private FlightSearch fs;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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
	public void testTime(){
		Date d= new Date();
		String s = df.format(d);
		String [] i = s.split("/");
		int SD=Integer.parseInt(i[0]);
		int SM=Integer.parseInt(i[1]);
		int SY=Integer.parseInt(i[2]);
		List<Flight> list = fs.search(3, s, "AK", "EG");
		int [] ML={31,28,31,30,31,30,31,31,30,31,30,31};
		if(SY%4==0)
			ML[1]=29;
		Iterator<Flight> it = list.iterator();
		while (it.hasNext()) {
			Flight k=it.next();
			d=k.getDate();
			s= df.format(d);
			i=s.split("/");
			int FD=Integer.parseInt(i[0]);
			int FM=Integer.parseInt(i[1]);
			int FY=Integer.parseInt(i[2]);
			boolean bo=false;
			int help;
			if(SM==FM)
				bo=Math.abs(SD-FD)<=7;
			else if(SM==FM+1){
				help=ML[FM-1]-FD;
				bo=SD+help<=7;
			}
			else if(SM==FM-1){
				help=ML[SM-1]-SD;
				bo=FD+help<=7;
			}
			else if(SY==FY+1&&SM==1&&FM==12){
				help=ML[FM-1]-FD;
				bo=SD+help<=7;
			}
			else if(SY==FY-1&&SM==12&&FM==1){
				help=ML[SM-1]-SD;
				bo=FD+help<=7;
			}
			assertTrue(bo);
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