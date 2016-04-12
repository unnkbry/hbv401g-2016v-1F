package pakki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {
	private static Connection c = null;
	private static Statement stmt = null;
	//private static String url = "jdbc:postgresql://localhost:5432/Flug";
	private static String url = "postgres://anzmxlojpltibg:A_zdKeCBbPtqi5paQpb32e4smk@ec2-54-217-202-108.eu-west-1.compute.amazonaws.com:5432/dcfccth327vsdp";
	private static String user = "postgres";

	public ResultSet getFromDB(String query) {
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, "Lovisa95");
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

	public boolean updateDB(String query) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, "Lovisa95");
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
