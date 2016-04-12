package pakki;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LastOrderForm {
	
	private JTextField NametextField;
	private JTextField SocialtextField;
	private JTextField SeatingtextField;
	private OrderManager om;
	private int counter;
	private int pplCount;
	private String flightnr;
	private String flightnr2;
	private List<Person> list;
	private int orderNr;
	private JFrame frame;

	
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
					LastOrderForm window = new LastOrderForm();
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
	
	public LastOrderForm(List<Person> list, String flightnr, String flightnr2, int orderNr){
		initialize();
	}
	
	
	public LastOrderForm() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(14, 44, 152, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
		lblSocialSecurityNumber.setBounds(14, 78, 152, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		NametextField = new JTextField();
		NametextField.setBounds(218, 41, 231, 22);
		frame.getContentPane().add(NametextField);
		NametextField.setColumns(10);
		
		SocialtextField = new JTextField();
		SocialtextField.setBounds(218, 75, 231, 22);
		frame.getContentPane().add(SocialtextField);
		SocialtextField.setColumns(10);
		
		JCheckBox chckbxHandicapped = new JCheckBox("Handicapped");
		chckbxHandicapped.setBounds(14, 108, 113, 25);
		frame.getContentPane().add(chckbxHandicapped);
		
		JCheckBox chckbxSpecialBaggage = new JCheckBox("Special Baggage");
		chckbxSpecialBaggage.setBounds(14, 138, 135, 25);
		frame.getContentPane().add(chckbxSpecialBaggage);
		
		SeatingtextField = new JTextField();
		SeatingtextField.setBounds(124, 189, 77, 22);
		frame.getContentPane().add(SeatingtextField);
		SeatingtextField.setColumns(10);
		
		JLabel lblChooseSeat = new JLabel("Choose Seat:");
		lblChooseSeat.setBounds(14, 192, 77, 16);
		frame.getContentPane().add(lblChooseSeat);
		
		Button Nextbutton = new Button("Next");
		Nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p=om.makePersons(NametextField.getText(), SocialtextField.getText(), chckbxHandicapped.isSelected(), chckbxSpecialBaggage.isSelected(), SeatingtextField.getText(), orderNr);
				list.add(p);
	
				frame.dispose();
				Receipt receipt = new Receipt();
				JFrame ReceiptWindow = receipt.getFrame();
				ReceiptWindow.setVisible(true);
				
			}
		});
		Nextbutton.setBounds(356, 222, 79, 24);
		frame.getContentPane().add(Nextbutton);
		
	}
}
