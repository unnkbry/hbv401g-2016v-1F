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
import java.awt.Font;
import java.awt.Color;
import pakki.Flight;

public class FlightSearchResult {

	private JFrame frame;
	private JTable table;
	private JTable table2;
	private List<Flight> listi;
	private List<Flight> listi2;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	int fn;
	int fn2;
	int pplCount;
	Flight f2;
	Flight f1;
	
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
		frame.setBounds(100, 100, 816, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		/*scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});*/
		scrollPane.setBounds(12, 78, 764, 137);
		frame.getContentPane().add(scrollPane);
		JScrollPane scrollPane2 = new JScrollPane();
		/*scrollPane2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
				       
				    }
				});*/
		scrollPane2.setBounds(12, 275, 764, 137);
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
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event){
				fn= Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
				Iterator<Flight> it = listi.iterator();
				while (it.hasNext()) {
					Flight f=it.next();
					if(fn==f.getFlightnr())
						f1=f;
				}
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
					fn2= Integer.parseInt(table2.getValueAt(table2.getSelectedRow(), 5).toString());
					if(listi2!=null){
						Iterator<Flight> it = listi2.iterator();
						while (it.hasNext()) {
							Flight f=it.next();
							if(fn2==f.getFlightnr())
								f2=f;
						}
					}
				}
			});
			
		}
		scrollPane.setViewportView(table);
		scrollPane2.setViewportView(table2);
		
		JLabel lblDepartureFlight = new JLabel("Departure Flight:");
		lblDepartureFlight.setForeground(Color.GRAY);
		lblDepartureFlight.setBounds(12, 59, 104, 16);
		frame.getContentPane().add(lblDepartureFlight);
		
		JLabel lblReturningFlight = new JLabel("Returning Flight:");
		lblReturningFlight.setForeground(Color.GRAY);
		lblReturningFlight.setBounds(12, 246, 133, 16);
		frame.getContentPane().add(lblReturningFlight);
		
		JButton btnConfirm = new JButton("Choose Flight");
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBackground(new Color(0, 0, 139));
		btnConfirm.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OrderNr on= new OrderNr();
				List<Person> list=new ArrayList<Person>();
				if(pplCount==1){
					LastOrderForm LOF = new LastOrderForm(list, f1, f2, on.getOrderNr());
					JFrame LastOrderFormWindow = LOF.getFrame();
					LastOrderFormWindow.setVisible(true);
				}
				else{
					
					OrderForm OF = new OrderForm(list, f1, f2, pplCount, 0, on.getOrderNr());
					JFrame OrderFormWindow = OF.getFrame();
					OrderFormWindow.setVisible(true);
				}
			}
		});
		btnConfirm.setBounds(322, 440, 144, 40);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblPickYourFlight = new JLabel("Pick your flight by clicking on it's row in the table.\r\n");
		lblPickYourFlight.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPickYourFlight.setBounds(15, 16, 386, 20);
		frame.getContentPane().add(lblPickYourFlight);
	}
}
