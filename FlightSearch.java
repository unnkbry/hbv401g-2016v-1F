
public class FlightSearch {
	private DataBaseConnectio dbc;
	public FlightSearch(){
		
	}
	//Veit ekki enn�� hvernig vi� h�fum t�masetningar og hvernig vi� afm�rkum t�mann, einnig veit ekki hvernig vi� f�um ni�urst��urnar
	public List<Flight> search(int peopleCount, String arrivalTime, String aA, String dA){
		return dbc.getFromDB("Select * from flights WHERE availableSeats>=peopleCount and aA=arrivalAirport and da=departureAirport") results 
	}
}
