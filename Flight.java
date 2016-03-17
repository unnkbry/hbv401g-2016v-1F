
public class Flight {
	private String arrivalTime;
	private String departureTime;
	private String arrivalAirport;
	private String departureAirport;
	private Type type;
	private int price;
	private Seating seats;
	
	public Flight(String arrivalTime, String departureTime, String arrivalAirport, 
			String departureAirport, Type type, int price, Seating seats){
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
		this.arrivalAirport=arrivalAirport;
		this.departureAirport=departureAirport;
		this.type=type;
		this.price=price;
		this.seats=seats;
	}
	
	public String getArrivalTime(){
		return arrivalTime;
	}
	
	public String getDepartureTime(){
		return departureTime;
	}
	
	
	
	
	
	
}
