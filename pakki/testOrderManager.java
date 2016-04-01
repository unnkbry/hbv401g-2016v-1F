package pakki;

import static org.junit.Assert.*;
import pakki.OrderManager;
import pakki.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pakki.Flight;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class testOrderManager {
	private OrderManager om;

	@Before
	public void setUp() throws Exception {
		om=new OrderManager();
	}

	@After
	public void tearDown() throws Exception {
		om=null;
	}

	@Test
	public void testmakePersons() {
		Person p=om.makePersons("name", "id", false, true, "1A", 1);
		assertEquals(p.getSeat(),"1A");
	}
	
	@Test
	public void testmakeOrder(){
		Date d= new Date();
		Flight f=new Flight("arrivalTime","departureTime","arrivalAirport","departureAirport",50, 10, 3, d);
		List<Person> list=new ArrayList<Person>();
		Person p=null;
		boolean b=true;
		for(int n=0; n<5;n++){
			p=new Person("name","id",b, !b, "seat");
			b=!b;
			list.add(p);
		}
		Order o=om.makeOrder(list, "email", "phonenumber", "animal", 2, 100, f, 3);
		assertNotNull(o);
	}

}
