//Man ekki hvernig ma�ur vitnar � a�ra klasa
//availableSeats, arrivalAirport, departureAirport
import java.sql.ResultSet;
import DataBaseConnection;
import Flight;
public interface List<Flight>;

public class FlightSearch {
	private DataBaseConnection dbc;
	public FlightSearch(){
		
	}
	//Veit ekki enn�� hvernig vi� h�fum t�masetningar og hvernig vi� afm�rkum t�mann, einnig veit ekki hvernig vi� f�um ni�urst��urnar
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
