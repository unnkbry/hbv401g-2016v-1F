package pakki;

import java.util.List;
import java.util.ArrayList;
import pakki.Person;
import pakki.Flight;

public class Order {
	private List<Person> list;
	private String email;
	private String phonenumber;
	private String animal;
	private int toddler;
	private int price;
	private Flight flight;
	
	public Order(List<Person> list, String email, String phonenumber, String animal, int toddler, int price, Flight flight){
		this.list = list;
		this.email = email;
		this.phonenumber = phonenumber;
		this.animal = animal;
		this.toddler = toddler;
		this.price = price;
		this.flight = flight;
	}
}
