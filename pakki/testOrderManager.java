package pakki;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pakki.OrderManager;
import pakki.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
		Person p=om.makePersons("Linda", "0", false, true, "01A", 1);
		assertEquals(p.getSeat(),"01A");
	}
	
	@Test
	public void testmakeOrder(){
		Date d= new Date();
		Flight f=new Flight("arrivalTime","departureTime","arrivalAirport","departureAirport",50, 10, 1, d);
		List<Person> list=new ArrayList<Person>();
		Person p=null;
		boolean b=true;
		for(int n=0; n<1;n++){
			p=new Person("name","id",b, !b, "02B");
			b=!b;
			list.add(p);
		}
		Order o=om.makeOrder(list, "sunhun", "phonenumber", "animal", 2, f, 3);
		assertNotNull(o);
	}
}
