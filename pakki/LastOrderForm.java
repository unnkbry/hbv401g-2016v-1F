package pakki;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class LastOrderForm {
	
	private JTextField NametextField;
	private JTextField SocialtextField;
	private JTextField SeatingtextField;
	private OrderManager om;
	private Flight f1;
	private Flight f2;
	private List<Person> list;
	private int orderNr;
	private JFrame frame;
	private JTextField PhonenumbertextField;
	private JTextField EmailtextField;

	
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
					LastOrderForm window = new LastOrderForm(null,null,null,5);
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
	
	public LastOrderForm(List<Person> list, Flight f1, Flight f2, int orderNr){
		om=new OrderManager();
		this.f1=f1;
		this.f2=f2;
		this.orderNr=orderNr;
		this.list=list;
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(14, 44, 152, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
		lblSocialSecurityNumber.setBounds(14, 78, 152, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel ToddlerLabel = new JLabel("How many?");
		ToddlerLabel.setVisible(false);
		ToddlerLabel.setBounds(245, 258, 71, 16);
		frame.getContentPane().add(ToddlerLabel);
		
		JComboBox<String> ToddlerBox= new JComboBox<String>();
		ToddlerBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		ToddlerBox.setVisible(false);
		ToddlerBox.setBounds(328, 255, 121, 22);
		frame.getContentPane().add(ToddlerBox);
			
		JLabel PetLabel = new JLabel("What kind?");
		PetLabel.setVisible(false);
		PetLabel.setBounds(245, 287, 71, 16);
		frame.getContentPane().add(PetLabel);
		
		NametextField = new JTextField();
		NametextField.setBounds(218, 41, 231, 22);
		frame.getContentPane().add(NametextField);
		NametextField.setColumns(10);
		
		SocialtextField = new JTextField();
		SocialtextField.setBounds(218, 75, 231, 22);
		frame.getContentPane().add(SocialtextField);
		SocialtextField.setColumns(10);
		
		JCheckBox chckbxHandicapped = new JCheckBox("Handicapped");
		chckbxHandicapped.setBounds(14, 190, 113, 25);
		frame.getContentPane().add(chckbxHandicapped);
		
		JCheckBox chckbxSpecialBaggage = new JCheckBox("Special Baggage");
		chckbxSpecialBaggage.setBounds(14, 220, 135, 25);
		frame.getContentPane().add(chckbxSpecialBaggage);
		
		SeatingtextField = new JTextField();
		SeatingtextField.setBounds(106, 348, 77, 22);
		frame.getContentPane().add(SeatingtextField);
		SeatingtextField.setColumns(10);
		
		JLabel lblChooseSeat = new JLabel("Choose Seat:");
		lblChooseSeat.setBounds(14, 351, 77, 16);
		frame.getContentPane().add(lblChooseSeat);
		
		JComboBox<String> PetBox = new JComboBox<String>();
		PetBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Dog", "Cat", "Bunny", "Fish", "Giraffe", "Hamster", "Bird", "Snake"}));
		PetBox.setVisible(false);
		PetBox.setBounds(328, 284, 121, 22);
		frame.getContentPane().add(PetBox);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(14, 114, 113, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		PhonenumbertextField = new JTextField();
		PhonenumbertextField.setBounds(218, 111, 231, 22);
		frame.getContentPane().add(PhonenumbertextField);
		PhonenumbertextField.setColumns(10);
		
		JCheckBox ToddlerCheck = new JCheckBox("Travelling with a Toddler");
		ToddlerCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToddlerBox.setVisible(ToddlerCheck.isSelected());
				ToddlerLabel.setVisible(ToddlerCheck.isSelected());
			}
		});
		
		ToddlerCheck.setBounds(14, 250, 176, 25);
		frame.getContentPane().add(ToddlerCheck);
		
		JCheckBox PetCheck = new JCheckBox("Travelling with a Pet");
		PetCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetBox.setVisible(PetCheck.isSelected());
				PetLabel.setVisible(PetCheck.isSelected());
			}
		});
		
		PetCheck.setBounds(14, 280, 152, 25);
		frame.getContentPane().add(PetCheck);		
		
	Button Nextbutton = new Button("Next");
	Nextbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Person p=om.makePersons(NametextField.getText(), SocialtextField.getText(), chckbxHandicapped.isSelected(), chckbxSpecialBaggage.isSelected(), SeatingtextField.getText(), orderNr);
			list.add(p);
			String a="";
			int t=0;
			if(PetCheck.isSelected())
				a=(String)PetBox.getItemAt(PetBox.getSelectedIndex());
			if(ToddlerCheck.isSelected())
				t=Integer.parseInt(ToddlerBox.getItemAt(ToddlerBox.getSelectedIndex()));
			Order o=om.makeOrder(list, EmailtextField.getText(), PhonenumbertextField.getText(), a, t, f1, orderNr);
			Order o2=null;
			if(f2!=null)
				o2 = om.makeOrder(list, EmailtextField.getText(), PhonenumbertextField.getText(), a, t, f2, orderNr);
			frame.dispose();
			Receipt receipt = new Receipt(o,o2);
			JFrame ReceiptWindow = receipt.getFrame();
			ReceiptWindow.setVisible(true);
			
		}
	});
	Nextbutton.setBounds(370, 349, 79, 24);
	frame.getContentPane().add(Nextbutton);
	
	JLabel lblEmail = new JLabel("Email:");
	lblEmail.setBounds(14, 148, 56, 16);
	frame.getContentPane().add(lblEmail);
	
	EmailtextField = new JTextField();
	EmailtextField.setBounds(218, 145, 231, 22);
	frame.getContentPane().add(EmailtextField);
	EmailtextField.setColumns(10);
	
	}
}