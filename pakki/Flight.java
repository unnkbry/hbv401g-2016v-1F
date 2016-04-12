package pakki;
import java.util.Date;
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
	private Seats seats;
	private int flightnr;
	private Date date;

	public Flight(String arrivalTime, String departureTime, String arrivalAirport, String departureAirport, int price,
			int availableSeats, int flightnr, Date date // , Type type
			) {
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.arrivalAirport = arrivalAirport;
		this.departureAirport = departureAirport;
		// this.type=type;
		this.price = price;
		this.availableSeats = availableSeats;
		seats = new Seats(20,30,1);
		this.flightnr=flightnr;
		this.date=date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public Date getDate(){
		return date;
	}
	
	public Seats getSeat(){
		return seats;
	}

	public int getFlightnr(){
		return flightnr;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String[][] getAvailableSeats() {
		return seats.getEmpty();
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public int bookSeat(String s){
		seats.makeUnavailable(s);
		availableSeats--;
		return availableSeats;
	}
	
	public int getPrice(){
		return price;
	}
}
