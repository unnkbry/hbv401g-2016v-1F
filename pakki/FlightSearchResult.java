package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightSearchResult {

	private JFrame frame;
	private JTable table;
	private JTable table2;
	private List<Flight> listi;
	private List<Flight> listi2;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String fn;
	String fn2;
	int pplCount;
	
	/**
	 * Constructors
	 */
	public FlightSearchResult(List<Flight> listi, List<Flight> listi2, int pplCount){
		this.listi=listi;
		this.listi2=listi2;
		this.pplCount=pplCount;
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
		frame.setBounds(100, 100, 816, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		/*scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});*/
		scrollPane.setBounds(12, 42, 764, 200);
		frame.getContentPane().add(scrollPane);
		JScrollPane scrollPane2 = new JScrollPane();
		/*scrollPane2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});*/
		scrollPane2.setBounds(12, 284, 764, 200);
		frame.getContentPane().add(scrollPane2);
		table = new JTable();
		int numRows = listi.size();
		String [][] s= new String [numRows][6];
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
			s[counter][5]=Integer.toString(f.getFlightnr());
			counter++;
		}
		table=new JTable(new DefaultTableModel(
			s,
			new String[] {
				"Arrival Airport", "Departure Airport", "Date", "Departure Time", "Price", "Flightnr"
			}
		));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event){
				fn= table.getValueAt(table.getSelectedRow(), 5).toString();
				System.out.println(fn);
			}
		});
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane2);
		System.out.println(listi2);
		if(listi2!=null){
			table2 = new JTable();
			int numRows2 = listi2.size();
			String [][] s2= new String [numRows2][6];
			it = listi2.iterator();
			counter = 0;
			while (it.hasNext()) {
				Flight f=it.next();
				String date=df.format(f.getDate());
				s2[counter][0]=f.getArrivalAirport();
				s2[counter][1]=f.getDepartureAirport();
				s2[counter][2]=date;
				s2[counter][3]=f.getDepartureTime();
				s2[counter][4]=Integer.toString(f.getPrice());
				s2[counter][5]=Integer.toString(f.getFlightnr());
				counter++;
			}
			table2=new JTable(new DefaultTableModel(
				s2,
				new String[] {
					"Arrival Airport", "Departure Airport", "Date", "Departure Time", "Price", "flightnr"
				}
			));
			table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event){
					fn2= table2.getValueAt(table2.getSelectedRow(), 5).toString();
					System.out.println(fn2);
				}
			});
		}
		scrollPane.setViewportView(table);
		scrollPane2.setViewportView(table2);
		
		JLabel lblDepartureFlight = new JLabel("Departure Flight:");
		lblDepartureFlight.setBounds(12, 13, 104, 16);
		frame.getContentPane().add(lblDepartureFlight);
		
		JLabel lblReturningFlight = new JLabel("Returning Flight:");
		lblReturningFlight.setBounds(12, 255, 114, 16);
		frame.getContentPane().add(lblReturningFlight);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				List<Person> list=new ArrayList<Person>();
				if(pplCount==1){
					LastOrderForm LOF = new LastOrderForm(list, fn, fn2, 5);
					JFrame LastOrderFormWindow = LOF.getFrame();
					LastOrderFormWindow.setVisible(true);
				}
				else{
					OrderForm OF = new OrderForm(list, fn, fn2, pplCount, 0, 5);
					JFrame OrderFormWindow = OF.getFrame();
					OrderFormWindow.setVisible(true);
				}
			}
		});
		btnConfirm.setBounds(351, 495, 104, 40);
		frame.getContentPane().add(btnConfirm);
	}
}
