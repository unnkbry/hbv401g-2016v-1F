package pakki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {
	
	private static Connection c = null;
	private static Statement stmt = null;
	private static String url = "jdbc:postgresql://ec2-54-217-202-108.eu-west-1.compute.amazonaws.com:5432/dcfccth327vsdp?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	private static String user = "anzmxlojpltibg";
	private static String password = "A_zdKeCBbPtqi5paQpb32e4smk";

	//Get information from the Database
	public ResultSet getFromDB(String query) {
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, password);
			stmt = c.createStatement();
			rs = stmt.executeQuery(query);
			c.close();
			c=null;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return rs;
	}
	//Change the Database, both create and update 
	public boolean updateDB(String query) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, password);
			stmt = c.createStatement();
			stmt.executeUpdate(query);
			c.close();
			c=null;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		} 
	}
}
