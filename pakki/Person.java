package pakki;

public class Person {
	private String name;
	private String id;
	private boolean handicapped;
	private boolean specialBaggage;
	private String seat;
	
	public Person(String name, String id, boolean handicapped, boolean specialBaggage, String seat){
		this.name = name;
		this.id = id;
		this.handicapped = handicapped;
		this.specialBaggage = specialBaggage;
		this.seat = seat;
	}
	
	public String getSeat(){
		return seat;
	}
	
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}
	
	public boolean getHandicapped(){
		return handicapped;
	}
	
	public boolean getSpecialBaggage(){
		return specialBaggage;
	}

}
