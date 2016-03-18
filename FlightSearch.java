//Man ekki hvernig maður vitnar í aðra klasa
//availableSeats, arrivalAirport, departureAirport
import java.sql.ResultSet;
import DataBaseConnection;
import Flight;
public interface List<Flight>;

public class FlightSearch {
	private DataBaseConnection dbc;
	public FlightSearch(){
		
	}
	//Veit ekki ennþá hvernig við höfum tímasetningar og hvernig við afmörkum tímann, einnig veit ekki hvernig við fáum niðurstöðurnar
	public List<Flight> search(int peopleCount, String arrivalTime, String aA, String dA){
		ResultSet rs= dbc.getFromDB("Select * from flights WHERE availableSeats>=peopleCount and aA=arrivalAirport and da=departureAirport");
		try{
			while(rs.next()){
	    		
			}
		}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	System.err.println(e.getClass().getName()+": "+e.getMessage());
	    	System.exit(0);
	    }
	}
}
