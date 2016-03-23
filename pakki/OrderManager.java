package pakki;
import pakki.DataBaseConnection;
import pakki.Person;
import pakki.Order;
import pakki.Flight;

public class OrderManager {
	private DataBaseConnection db=new DataBaseConnection();
	
	public Person makePersons(String name, String id, boolean handicapped, boolean specialBaggage, String seat){
		db.updateDB("insert into persons values('"+name+"','"+id+"','"+handicapped+"','"+specialBaggage+"','"+seat+"','" );
		Person p=new Person(name, id, handicapped, specialBaggage, seat); 		
	}
	
	public void makeOrder(List<Person> list, String email, String phonenumber, String animal, int toddler, int price, Flight f){
		//db.updateDB("insert into order values('"+name+"','"+id+"','"+handicapped+"','"+specialBaggage+"','"+seat+"','" );
		Order o=new Order(list, email, phonenumber, animal, toddler, price, f);
	}
}
