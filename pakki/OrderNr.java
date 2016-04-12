package pakki;
import java.sql.ResultSet;

import pakki.DataBaseConnection;

public class OrderNr {
	private DataBaseConnection db= new DataBaseConnection();
	
	public int getOrderNr(){
		ResultSet rs = db.getFromDB("Select ordernr from orders");
		int on=0;
		try {
			while (rs.next()) {
				if(rs.getInt("ordernr")>on)
					on=rs.getInt("ordernr");
			}
			on++;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return on;
	}
	
}
