
public class FlightSearch {
	private DataBaseConnectio dbc;
	public FlightSearch(){
		
	}
	//Veit ekki ennþá hvernig við höfum tímasetningar og hvernig við afmörkum tímann, einnig veit ekki hvernig við fáum niðurstöðurnar
	public List<Flight> search(int peopleCount, String arrivalTime, String aA, String dA){
		return dbc.getFromDB("Select * from flights WHERE availableSeats>=peopleCount and aA=arrivalAirport and da=departureAirport") results 
	}
}
