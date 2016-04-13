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
		frame.setBounds(100, 100, 465, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setBounds(12, 29, 83, 16);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setBounds(12, 58, 56, 16);
		frame.getContentPane().add(lblArrival);
		
		JComboBox<String> DeparturecomboBox = new JComboBox<String>();
		DeparturecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"RKV", "AEY", "IFJ", "EGS", "VES"}));
		DeparturecomboBox.setBounds(95, 26, 83, 22);
		frame.getContentPane().add(DeparturecomboBox);
		
		JComboBox<String> ArrivalcomboBox = new JComboBox<String>();
		ArrivalcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"RKV", "AEY", "IFJ", "EGS", "VES"}));
		ArrivalcomboBox.setBounds(95, 55, 83, 22);
		frame.getContentPane().add(ArrivalcomboBox);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(12, 100, 56, 16);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(95, 94, 99, 22);
		frame.getContentPane().add(dateChooser1);
		
		JLabel lblPeopleCount = new JLabel("People count:");
		lblPeopleCount.setBounds(12, 189, 113, 16);
		frame.getContentPane().add(lblPeopleCount);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8","9"}));
		comboBox.setBounds(127, 186, 73, 22);
		frame.getContentPane().add(comboBox);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setVisible(false);
		dateChooser2.setBounds(220, 94, 99, 22);
		frame.getContentPane().add(dateChooser2);
		
		JCheckBox chckbxBothWays = new JCheckBox("Both Ways");
		chckbxBothWays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser2.setVisible(chckbxBothWays.isSelected());
			}
		});
		
		chckbxBothWays.setBounds(12, 157, 113, 25);
		frame.getContentPane().add(chckbxBothWays);
		
		JLabel wrongFlight1Label = new JLabel("No available departure flight");
		wrongFlight1Label.setBounds(22, 127, 171, 22);
		frame.getContentPane().add(wrongFlight1Label);
		wrongFlight1Label.setVisible(false);
		
		
		JLabel wrongFlight2Label = new JLabel("No available arrival flight");
		wrongFlight2Label.setBounds(220, 131, 131, 14);
		frame.getContentPane().add(wrongFlight2Label);
		wrongFlight2Label.setVisible(false);
		
		Button SubmitStartFormbutton = new Button("Submit");
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
		SubmitStartFormbutton.setBounds(169, 253, 92, 33);
		frame.getContentPane().add(SubmitStartFormbutton);
	}
}
