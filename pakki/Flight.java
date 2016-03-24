package pakki;
import pakki.DataBaseConnection;
//Vantar Seating og Type, þurfum í raun og veru ekki að gera neitt meira við þennan klasa

//fyrr en við förum að gera kvittanir

public class Flight {
	private String arrivalTime;
	private String departureTime;
	private String arrivalAirport;
	private String departureAirport;
	private int availableSeats;
	// private Type type;
	private int price;
	private Seating seats;
	private int flightnr;

	public Flight(String arrivalTime, String departureTime, String arrivalAirport, String departureAirport, int price,
			int availableSeats, int flightnr // , Type type
			) {
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.arrivalAirport = arrivalAirport;
		this.departureAirport = departureAirport;
		// this.type=type;
		this.price = price;
		this.availableSeats = availableSeats;
		Seating seats=new Seating();
		this.flightnr=flightnr;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}
	public int getFlightnr(){
		return flightnr;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public void bookSeat(String s){
		seats.bookSeat(s);
		availableSeats--;
		//update db!
	}
}
