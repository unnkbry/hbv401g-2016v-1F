package pakki;
import pakki.DataBaseConnection;
import java.sql.ResultSet;

public class Seats{
	private boolean [][] seats;
	private int rows;
	private int cols;
	private int flightnr;
	private DataBaseConnection db;
	
	public Seats(int rows, int cols, int flightnr){
		db=new DataBaseConnection();
		seats=new boolean[rows][cols];
		this.rows=rows;
		this.cols=cols;
		this.flightnr=flightnr;
		ResultSet rs = db.getFromDB("Select * from seating where flightnr='" + flightnr+"'");
		try{
			while(rs.next()){
				seats[rs.getInt("rowid")][rs.getInt("colid")]=rs.getBoolean("seatstatus");
			}
		}
		 catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}	
	}

	public String turnToString(int row, int col){
		String [] Alphabet= {"A","B","C","D","E","F"};
		String r="";
		if(row<10){
			r="0"+r;
		}
		r=r+Integer.toString(row+1);
		r=r+Alphabet[col];
		return r;
	}
	
	public int [] turnFromString(String s){
		char[] i=s.toCharArray();
		int[]seat=new int[2];
		seat[0]=Character.getNumericValue(i[0])*10+Character.getNumericValue(i[1])-1;
		char [] Alphabet	= {'A','B','C','D','E','F'};
		for(int n=0;n<5;n++){
			if(Alphabet[n]==i[2])				
				seat[1]=n;
		}
		return seat;
	}
	
	public void makeUnavailable(String s){
		int [] seat=turnFromString(s);
		db.updateDB("update seating set seatstatus='false' where flightnr='"+flightnr+"' and colid='"+seat[0]+"' and rowid='"+seat[1]+"'");
		seats[seat[0]][seat[1]]=false;
	}
	
	public String[][] getEmpty(){
		String[][] s=new String[rows][cols];
		for(int c=0;c<cols;c++){
			for(int r=0;r<rows;r++){
				if(seats[r][c])
					s[r][c]=turnToString(r,c);
				else s[r][c]="   ";
			}
		}
		return s;
	}
	
	public boolean getSeatStatus(String s){
		int [] seat=turnFromString(s);
		return seats[seat[0]][seat[1]];
	}
}
