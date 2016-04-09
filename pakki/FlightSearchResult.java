package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class FlightSearchResult {

	private JFrame frame;
	private JTable table;
	private List<Flight> listi;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Constructors
	 */
	public FlightSearchResult(List<Flight> listi){
		this.listi=listi;
		initialize();
	}
	public FlightSearchResult() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightSearchResult window = new FlightSearchResult();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});
		scrollPane.setBounds(12, 42, 261, 119);
		frame.getContentPane().add(scrollPane);
		JTable table = new JTable();
		String[] colHeadings = {"Arrival Airport", "Departure Airport", "Date", "Departure Time", "Price"};
		int numRows = listi.size();
		DefaultTableModel table_model = new DefaultTableModel(colHeadings,numRows);
		String [][] s= new String [numRows][5];
		System.out.println("fjöldi raða: " + numRows);
		Iterator<Flight> it = listi.iterator();
		int counter = 0;
		while (it.hasNext()) {
			Flight f=it.next();
			System.out.println(f.getArrivalAirport());
			String date=df.format(f.getDate());
			s[counter][0]=f.getArrivalAirport();
			s[counter][1]=f.getDepartureAirport();
			s[counter][2]=date;
			s[counter][3]=f.getDepartureTime();
			s[counter][4]=Integer.toString(f.getPrice());
			counter++;
		}
		table=new JTable(new DefaultTableModel(
			s,
			new String[] {
				"Arrival Airport", "Departure Airport", "Date", "Departure Time", "Price"
			}
		));
		scrollPane.setViewportView(table);
	}
}
