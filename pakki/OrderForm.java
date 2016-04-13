package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import pakki.OrderManager;
import pakki.Person;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class OrderForm {

	private JFrame frame;
	private JTextField NametextField;
	private JTextField SocialtextField;
	private JTextField DeparturetextField;
	private OrderManager om;
	private int counter;
	private int pplCount;
	private Flight f1;
	private Flight f2;
	private List<Person> list;
	private int orderNr;
	private JTable table;
	private JTable table2;
	private String seat1;
	private String seat2;
	
	int nrOfRows = 99;
	private JTextField ArrivaltextField;
	
	
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
					OrderForm window = new OrderForm(null, null,null,3,1,5);
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
	public OrderForm(List<Person> list, Flight f1, Flight f2, int pplCount, int counter, int orderNr) {
		this.pplCount=pplCount;
		this.counter=counter;
		this.f1=f1;
		this.f2=f2;
		this.list=list;
		this.orderNr=orderNr;
		om=new OrderManager();
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 649);
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
		
		DeparturetextField = new JTextField();
		DeparturetextField.setBounds(158, 189, 62, 22);
		frame.getContentPane().add(DeparturetextField);
		DeparturetextField.setColumns(10);
		
		JLabel lblChooseSeat = new JLabel("Choose Departure Seat:");
		lblChooseSeat.setBounds(14, 192, 152, 16);
		frame.getContentPane().add(lblChooseSeat);
		
		Button Nextbutton = new Button("Next");
		Nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p=om.makePersons(NametextField.getText(), SocialtextField.getText(), chckbxHandicapped.isSelected(), chckbxSpecialBaggage.isSelected(), DeparturetextField.getText(), orderNr);
				list.add(p);
				counter++;
				if(pplCount==counter+1){
					frame.dispose();
					LastOrderForm lof = new LastOrderForm(list, f1, f2, orderNr);
					JFrame LastOrderFormWindow = lof.getFrame();
					LastOrderFormWindow.setVisible(true);
				}
				else {
					frame.dispose();
					OrderForm OF = new OrderForm(list, f1, f2, pplCount, counter++, orderNr);
					JFrame OrderFormWindow = OF.getFrame();
					OrderFormWindow.setVisible(true);
				}
			}
		});
		Nextbutton.setBounds(208, 245, 79, 24);
		frame.getContentPane().add(Nextbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 296, 436, 282);
		frame.getContentPane().add(scrollPane);
		
		String column_names[]= {"A","B","C","D","E","F"};
		
		String [] [] s=f1.getSeats();
		table = new JTable(s, column_names);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event){
				seat1 = (String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
			}
		});
		
		if(f2!=null){
			JScrollPane scrollPane2 = new JScrollPane();
			scrollPane2.setBounds(100, 296, 436, 282);
			frame.getContentPane().add(scrollPane);
			JLabel lblChooseSeat_1 = new JLabel("Choose Arrival Seat:");
			lblChooseSeat_1.setBounds(278, 192, 135, 16);
			frame.getContentPane().add(lblChooseSeat_1);
			ArrivaltextField = new JTextField();
			ArrivaltextField.setBounds(403, 189, 64, 22);
			frame.getContentPane().add(ArrivaltextField);
			ArrivaltextField.setColumns(10);
			String [] [] s2=f2.getSeats();
			table2 = new JTable(s2, column_names);
			scrollPane2.setViewportView(table2);
		}
	}
}
