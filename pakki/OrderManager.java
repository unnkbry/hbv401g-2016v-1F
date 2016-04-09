package pakki;

import pakki.DataBaseConnection;
import pakki.Person;
import pakki.Order;
import pakki.Flight;
import java.util.List;
import java.util.Iterator;

public class OrderManager{
	private int personCount;
	private DataBaseConnection db = new DataBaseConnection();
	public OrderManager(){
		personCount=0;
	}

	public Person makePersons(String name, String id, boolean handicapped, boolean specialBaggage, String seat, int ordernr) {
		db.updateDB("insert into persons values('" + name + "','" + id + "','" + handicapped + "','" + specialBaggage
				+ "','" + seat + "','"+ ordernr+"')");
		Person p = new Person(name, id, handicapped, specialBaggage, seat);
		personCount++;
		return p;
	}

	public Order makeOrder(List<Person> list, String email, String phonenumber, String animal, int toddler,
			Flight f, int ordernr) {
		boolean a=true;
		if(animal=="")
			a=false;
		int price=calcPrice(f.getPrice(), toddler, list, a);
		db.updateDB("insert into orders values('" + email + "','" + phonenumber + "','" + animal + "','" + toddler
				+ "','" + price + "','"+ f.getFlightnr()+"','"+ordernr+"')");
		Order o = new Order(list, email, phonenumber, animal, toddler, price, f);
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			f.bookSeat(it.next().getSeat());
		}
		return o;
	}
	
	public int calcPrice(int seatPrice, int toddler, List<Person> list, boolean animal){
		int specialBaggage=0;
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			if(it.next().getSpecialBaggage())
				specialBaggage++;
		}
		int price = seatPrice*personCount+toddler*5000+specialBaggage*6000;
		if(animal)
			price=price+10000;
		return price;
	}
}
