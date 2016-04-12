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
	private List<Flight> listi2;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Constructors
	 */
	public FlightSearchResult(List<Flight> listi, List<Flight> listi2){
		this.listi=listi;
		this.listi2=listi2;
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
		frame.setBounds(100, 100, 816, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});
		scrollPane.setBounds(12, 42, 764, 200);
		frame.getContentPane().add(scrollPane);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});
		scrollPane2.setBounds(12, 284, 764, 200);
		frame.getContentPane().add(scrollPane2);
		JTable table = new JTable();
		int numRows = listi.size();
		String [][] s= new String [numRows][5];
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
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane2);
		JTable table2=null;
		System.out.println(listi2);
		if(listi2!=null){
			table2 = new JTable();
			int numRows2 = listi2.size();
			String [][] s2= new String [numRows2][5];
			it = listi.iterator();
			counter = 0;
			while (it.hasNext()) {
				Flight f=it.next();
				String date=df.format(f.getDate());
				s2[counter][0]=f.getArrivalAirport();
				s2[counter][1]=f.getDepartureAirport();
				s2[counter][2]=date;
				s2[counter][3]=f.getDepartureTime();
				s2[counter][4]=Integer.toString(f.getPrice());
				counter++;
			}
			table2=new JTable(new DefaultTableModel(
				s2,
				new String[] {
					"Arrival Airport", "Departure Airport", "Date", "Departure Time", "Price"
				}
			));
		}
		scrollPane.setViewportView(table);
		scrollPane2.setViewportView(table2);
		
		JLabel lblDepartureFlight = new JLabel("Departure Flight:");
		lblDepartureFlight.setBounds(12, 13, 104, 16);
		frame.getContentPane().add(lblDepartureFlight);
		
		JLabel lblReturningFlight = new JLabel("Returning Flight:");
		lblReturningFlight.setBounds(12, 255, 114, 16);
		frame.getContentPane().add(lblReturningFlight);
	}
}
