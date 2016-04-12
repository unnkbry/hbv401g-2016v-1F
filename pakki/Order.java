package pakki;

import java.util.Iterator;
import java.util.List;
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
	private int orderNr;
	
	public Order(List<Person> list, String email, String phonenumber, String animal, int toddler, int price, Flight flight, int orderNr){
		this.list = list;
		this.email = email;
		this.phonenumber = phonenumber;
		this.animal = animal;
		this.toddler = toddler;
		this.price = price;
		this.flight = flight;
		this.orderNr=orderNr;
	}
	
	public int getPPLCount(){
		return list.size();
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhonenumber(){
		return phonenumber;
	}
	
	public String getAnimal(){
		return animal;
	}
	
	public int getToddler(){
		return toddler;
	}
	
	public int getPrice(){
		return price;
	}
	
	public Flight getFlight(){
		return flight;
	}
	
	public List<Person> getPersonList(){
		return list;
	}
	
	public String getName(){
		Person p= list.get(list.size()-1);
		return p.getName();
	}
	
	public String getId(){
		Person p= list.get(list.size()-1);
		return p.getId();
	}
	
	public int getOrderNr(){
		return orderNr;
	}
	
	public int getSpecialBaggage(){
		int specialBaggage=0;
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			if(it.next().getSpecialBaggage())
				specialBaggage++;
		}
		return specialBaggage;
	}
	
}
