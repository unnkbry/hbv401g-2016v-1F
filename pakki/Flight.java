package pakki;
//Vantar Seating og Type, �urfum � raun og veru ekki a� gera neitt meira vi� �ennan klasa
//fyrr en vi� f�rum a� gera kvittanir

public class Flight {
	private String arrivalTime;
	private String departureTime;
	private String arrivalAirport;
	private String departureAirport;
	//private Type type;
	private int price;
	//private Seating seats;
	
	public Flight(String arrivalTime, String departureTime, String arrivalAirport, 
			String departureAirport, int price //, Type type, int price, Seating seats
			){
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
		this.arrivalAirport=arrivalAirport;
		this.departureAirport=departureAirport;
		//this.type=type;
		this.price=price;
		//this.seats=seats;
	}
	
	public String getArrivalTime(){
		return arrivalTime;
	}
	
	public String getDepartureTime(){
		return departureTime;
	}
	
	
	
	
	
	
}