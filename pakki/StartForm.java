package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class StartForm {

	private JFrame frame;

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
	public StartForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 373, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setBounds(12, 29, 83, 16);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setBounds(12, 58, 56, 16);
		frame.getContentPane().add(lblArrival);
		
		JComboBox DeparturecomboBox = new JComboBox();
		DeparturecomboBox.setModel(new DefaultComboBoxModel(new String[] {"RVK", "AK", "�SA"}));
		DeparturecomboBox.setBounds(95, 26, 83, 22);
		frame.getContentPane().add(DeparturecomboBox);
		
		JComboBox ArrivalcomboBox = new JComboBox();
		ArrivalcomboBox.setModel(new DefaultComboBoxModel(new String[] {"RVK", "AK", "�SA"}));
		ArrivalcomboBox.setBounds(95, 55, 83, 22);
		frame.getContentPane().add(ArrivalcomboBox);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(12, 100, 56, 16);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(95, 94, 99, 22);
		frame.getContentPane().add(dateChooser1);
		
		JLabel lblPeopleCount = new JLabel("People count:");
		lblPeopleCount.setBounds(12, 189, 83, 16);
		frame.getContentPane().add(lblPeopleCount);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(95, 186, 73, 22);
		frame.getContentPane().add(comboBox);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setVisible(false);
		dateChooser2.setBounds(220, 94, 99, 22);
		frame.getContentPane().add(dateChooser2);
		
		JCheckBox chckbxBothWays = new JCheckBox("Both Ways");
		chckbxBothWays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(chckbxBothWays.isSelected());
				dateChooser2.setVisible(chckbxBothWays.isSelected());
			}
		});
		chckbxBothWays.setBounds(12, 140, 113, 25);
		frame.getContentPane().add(chckbxBothWays);
		
		Button SubmitStartFormbutton = new Button("Submit");
		SubmitStartFormbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSearchResult searchresult = new FlightSearchResult();
				// searchresult.setVisible(true);
			}
		});
		SubmitStartFormbutton.setBounds(145, 250, 79, 24);
		frame.getContentPane().add(SubmitStartFormbutton);
		
	}
}
