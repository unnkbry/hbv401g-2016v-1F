package pakki;
//Vantar Seating og Type, þurfum í raun og veru ekki að gera neitt meira við þennan klasa
//fyrr en við förum að gera kvittanir

public class Flight {
	private String arrivalTime;
	private String departureTime;
	private String arrivalAirport;
	private String departureAirport;
	private int availableSeats;
	//private Type type;
	private int price;
	//private Seating seats;
	
	public Flight(String arrivalTime, String departureTime, String arrivalAirport, 
			String departureAirport, int price, int availableSeats //, Type type, int price, Seating seats
			){
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
		this.arrivalAirport=arrivalAirport;
		this.departureAirport=departureAirport;
		//this.type=type;
		this.price=price;
		this.availableSeats=availableSeats;
		//this.seats=seats;
	}
	
	public String getArrivalTime(){
		return arrivalTime;
	}
	
	public String getDepartureTime(){
		return departureTime;
	}
	
	public int getAvailableSeats(){
		return availableSeats;
	}
	
	public String getArrivalAirport(){
		return arrivalAirport;
	}
	public String getDepartureAirport(){
		return departureAirport;
	}
	
	
	
}
