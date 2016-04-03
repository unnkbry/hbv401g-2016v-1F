package pakki;

public interface Seating {

	public String turnToString(int row, int col);
	
	public int [] turnFromString(String s);
	
	public void makeUnavailable(String s);
	
	public String[][] getEmpty();
	
	public boolean getSeatStatus(String s);
}
