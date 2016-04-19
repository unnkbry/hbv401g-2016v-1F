package pakki;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StartForm {
	private FlightSearch fs = new FlightSearch();
	private JFrame frame;
	private List<Flight> list;
	private List<Flight> list2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartForm window = new StartForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartForm(){
		list=null;
		list2= null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeparture.setBounds(12, 61, 83, 22);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrival.setBounds(22, 96, 73, 16);
		frame.getContentPane().add(lblArrival);
		
		JComboBox<String> DeparturecomboBox = new JComboBox<String>();
		DeparturecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"RKV", "AEY", "IFJ", "EGS", "VES"}));
		DeparturecomboBox.setBounds(107, 61, 83, 22);
		frame.getContentPane().add(DeparturecomboBox);
		
		JComboBox<String> ArrivalcomboBox = new JComboBox<String>();
		ArrivalcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"RKV", "AEY", "IFJ", "EGS", "VES"}));
		ArrivalcomboBox.setBounds(107, 93, 83, 22);
		frame.getContentPane().add(ArrivalcomboBox);
		
		JLabel lblDate = new JLabel("Pick a date:");
		lblDate.setBounds(12, 150, 83, 16);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(12, 179, 130, 22);
		frame.getContentPane().add(dateChooser1);
		
		JLabel lblPeopleCount = new JLabel("People count:");
		lblPeopleCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeopleCount.setBounds(12, 294, 83, 16);
		frame.getContentPane().add(lblPeopleCount);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8","9"}));
		comboBox.setBounds(107, 291, 73, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPickAReturn = new JLabel("Pick a return date:");
		lblPickAReturn.setVisible(false);
		lblPickAReturn.setBounds(181, 150, 129, 16);
		frame.getContentPane().add(lblPickAReturn);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setVisible(false);
		dateChooser2.setBounds(181, 179, 130, 22);
		frame.getContentPane().add(dateChooser2);
		
		JCheckBox chckbxBothWays = new JCheckBox("Both Ways");
		chckbxBothWays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser2.setVisible(chckbxBothWays.isSelected());
				lblPickAReturn.setVisible(chckbxBothWays.isSelected());
			}
		});
		
		chckbxBothWays.setBounds(12, 236, 113, 25);
		frame.getContentPane().add(chckbxBothWays);
		
		JLabel wrongFlight1Label = new JLabel("No available departure flights");
		wrongFlight1Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		wrongFlight1Label.setForeground(Color.RED);
		wrongFlight1Label.setBounds(12, 207, 171, 22);
		frame.getContentPane().add(wrongFlight1Label);
		wrongFlight1Label.setVisible(false);
		
		
		JLabel wrongFlight2Label = new JLabel("No available arrival flights");
		wrongFlight2Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		wrongFlight2Label.setForeground(Color.RED);
		wrongFlight2Label.setBounds(181, 209, 171, 18);
		frame.getContentPane().add(wrongFlight2Label);
		wrongFlight2Label.setVisible(false);
		
		Button SubmitStartFormbutton = new Button("Search Flights");
		SubmitStartFormbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departureAirport=(String) DeparturecomboBox.getItemAt(DeparturecomboBox.getSelectedIndex());
				String arrivalAirport=(String) ArrivalcomboBox.getItemAt(ArrivalcomboBox.getSelectedIndex());
				int peopleCount=Integer.parseInt(comboBox.getItemAt(comboBox.getSelectedIndex()));
				boolean bothWays = chckbxBothWays.isSelected();
				Date d= (Date) dateChooser1.getDate();
				Date d2=null;
				boolean work1=false;
				boolean work2=false;
				if(d!=null){
					list=fs.search(peopleCount,  d, arrivalAirport, departureAirport);
					if(list.size()!=0)
						work1=true;
				}
				if(!bothWays)
					work2=true;
				if(bothWays&&dateChooser2.getDate()!=null){
					d2=(Date) dateChooser2.getDate();
					list2=fs.search(peopleCount,  d2, departureAirport, arrivalAirport);
					if(list2.size()!=0)
						work2=true;
				}
				if(!work1&&!work2){
					wrongFlight1Label.setVisible(true);
					wrongFlight2Label.setVisible(true);
					list=null;
					list2=null;
				}
				else if(!work2&&work1){
					wrongFlight2Label.setVisible(true);
					wrongFlight1Label.setVisible(false);
					list=null;
					list2=null;
				}
				else if(work2&&!work1){
					wrongFlight2Label.setVisible(false);
					wrongFlight1Label.setVisible(true);
					list=null;
					list2=null;
				}
				else{
					frame.dispose();
					FlightSearchResult searchResult = new FlightSearchResult(list, list2, peopleCount);
					JFrame searchResultWindow = searchResult.getFrame();
					searchResultWindow.setVisible(true);
				}
			}
		});
		SubmitStartFormbutton.setBounds(115, 346, 92, 33);
		frame.getContentPane().add(SubmitStartFormbutton);
		
		JLabel lblPleaseChooseYour = new JLabel("Welcome, choose your desired vacation");
		lblPleaseChooseYour.setToolTipText("");
		lblPleaseChooseYour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseChooseYour.setBounds(12, 13, 405, 16);
		frame.getContentPane().add(lblPleaseChooseYour);
		
	}
}
