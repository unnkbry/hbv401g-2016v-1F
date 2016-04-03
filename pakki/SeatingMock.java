package pakki;

public class SeatingMock implements Seating{

		private boolean [][] seats;
		private int rows;
		private int cols;
		
		
		//array of boolean is made for the seating it is true if the seat is available
		//the seat is randomly available or not
		public SeatingMock(int rows, int cols, int flightnr){
			seats=new boolean[rows][cols];
			this.rows=rows;
			this.cols=cols;
			int random=0;
			for(int n=0;n< rows;n++){
				for(int m=0;m<cols;m++){
					random=(int)(Math.random()*2);
					if(random==0)
						seats[n][m]=true;
					else
						seats[n][m]=false;
				}
			}	
		}

		//The seat number gets the right value fx seat 0,0 gets the value 01A
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
		
		//The seat is converted from the value that is on the flight ticket
		// to the values used to refer the array
		public int [] turnFromString(String s){
			if(s.length()!=3)
				throw new IllegalArgumentException();
			char[] i=s.toCharArray();
			int[]seat=new int[2];
			seat[0]=Character.getNumericValue(i[0])*10+Character.getNumericValue(i[1])-1;
			if(Character.getNumericValue(i[0])>9||Character.getNumericValue(i[1])>9||seat[0]>=rows||Character.getNumericValue(i[0])<0||Character.getNumericValue(i[1])<1)
				throw new IllegalArgumentException();
			System.out.println(i[0]+ ": "+ Character.getNumericValue(i[0]));
			char [] Alphabet	= {'A','B','C','D','E','F'};
			seat[1]=6;
			for(int n=0;n<5;n++){
				if(Alphabet[n]==i[2])				
					seat[1]=n;
			}
			if(seat[1]>5)
				throw new IllegalArgumentException();
			return seat;
		}
		
		//seat with the value s is made unavailable
		public void makeUnavailable(String s){
			int [] seat=turnFromString(s);
			seats[seat[0]][seat[1]]=false;
		}
		
		//Returns a two dimensional array of Strings the string is "   " 
		//if the seat is taken, otherwise it contains the name of the seat
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
		
		//returns true if the seat is not taken, otherwise false
		public boolean getSeatStatus(String s){
			int [] seat=turnFromString(s);
			return seats[seat[0]][seat[1]];
		}
}
