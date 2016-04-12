package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
	private JTextField SeatingtextField;
	private OrderManager om;
	private int counter;
	private int pplCount;
	private Flight f1;
	private Flight f2;
	private List<Person> list;
	private int orderNr;
	private JTable table;

	int nrOfRows = 99;
	
	
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
		frame.setBounds(100, 100, 549, 875);
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
		Nextbutton.setBounds(356, 222, 79, 24);
		frame.getContentPane().add(Nextbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 309, 183, 482);
		frame.getContentPane().add(scrollPane);
		
		String column_names[]= {"A","B","C","D","E","F"};
		DefaultTableModel table_model=new DefaultTableModel(column_names,nrOfRows);
		
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
	}
}
