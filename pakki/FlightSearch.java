package pakki;
//í db: availableSeats, arrivalAirport, departureAirport, arrivalTime departureTime date? flightId
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import pakki.DataBaseConnection;
import pakki.Flight;

public class FlightSearch{
	private DataBaseConnection dbc=new DataBaseConnection();

	//Veit ekki ennþá hvernig við höfum tímasetningar og hvernig við afmörkum tímann, einnig veit ekki hvernig við fáum niðurstöðurnar
	//spurning að hafa date og svo arrivalTime og departurTime, þa date er dagsetning og hitt eru tímasetningar
	
	public List<Flight> search(int peopleCount, String arrivalTime, String aA, String dA){
		ResultSet rs= dbc.getFromDB("Select * from flights WHERE flights.arrivalAirport='" + aA + "' and availableSeats>='" + peopleCount+"' and '" + dA+  "'=departureAirport");
		List<Flight> list = new ArrayList<Flight>();
		Flight f=null;
		try{
			while(rs.next()){
				f=new Flight(rs.getString("arrivalTime"), rs.getString("departureTime"), rs.getString("arrivalAirport"), rs.getString("departureAirport"), rs.getInt("price"), rs.getInt("availableseats"));
				list.add(f);
				
			}
		}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	System.err.println(e.getClass().getName()+": "+e.getMessage());
	    	System.exit(0);
	    }
		return list;
	}
}
