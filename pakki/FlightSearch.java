package pakki;

//í db: availableSeats, arrivalAirport, departureAirport, arrivalTime departureTime date? flightId
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import pakki.DataBaseConnection;
import pakki.Flight;
import java.util.Date;

public class FlightSearch {
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private DataBaseConnection dbc = new DataBaseConnection();

	// Veit ekki ennþá hvernig við höfum tímasetningar og hvernig við afmörkum
	// tímann, einnig veit ekki hvernig við fáum niðurstöðurnar
	// spurning að hafa date og svo arrivalTime og departurTime, þa date er
	// dagsetning og hitt eru tímasetningar

	public List<Flight> search(int peopleCount, Date d, String aA, String dA){
		if(peopleCount<=0)
			return null;
		ResultSet rs = dbc.getFromDB("Select * from flights WHERE arrivalAirport='" + aA
				+ "' and availableSeats>='" + peopleCount + "' and '" + dA + "'=departureAirport");
		List<Flight> list = new ArrayList<Flight>();
		Flight f = null;
		try {
			while (rs.next()) {
				f = new Flight(rs.getString("arrivalTime"), rs.getString("departureTime"),
						rs.getString("arrivalAirport"), rs.getString("departureAirport"), rs.getInt("price"),
						rs.getInt("availableseats"), rs.getInt("flightid"), rs.getDate("date"));
				boolean b= checkDate(f, d);
				if(b)
					list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return list;
	}
	private boolean checkDate(Flight f, Date d){
		Date foundDate=f.getDate();
		String searcheds=df.format(d);
		String founds=df.format(foundDate);
		String [] foundi= founds.split("/");
		String [] searchedi = searcheds.split("/");
		int SD= Integer.parseInt(searchedi[0]);
		int SM=Integer.parseInt(searchedi[1]);
		int SY=Integer.parseInt(searchedi[2]);
		int FD= Integer.parseInt(foundi[0]);
		int FM=Integer.parseInt(foundi[1]);
		int FY=Integer.parseInt(foundi[2]);
		int [] ML={31,28,31,30,31,30,31,31,30,31,30,31};
		if(SY%4==0)
			ML[1]=29;
		boolean bo=false;
		int help;
		if(SM==FM){
			System.out.println("searchday: "+ SD+ " foundday: "+ FD);
			bo=Math.abs(SD-FD)<=7;
		}
		else if(SM==FM+1){
			help=ML[FM-1]-FD;
			bo=SD+help<=7;
		}
		else if(SM==FM-1){
			help=ML[SM-1]-SD;
			bo=FD+help<=7;
		}
		else if(SY==FY+1&&SM==1&&FM==12){
			help=ML[FM-1]-FD;
			bo=SD+help<=7;
		}
		else if(SY==FY-1&&SM==12&&FM==1){
			help=ML[SM-1]-SD;
			bo=FD+help<=7;
		}
		return bo;
	}
}