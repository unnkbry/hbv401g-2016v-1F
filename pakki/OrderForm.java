package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import pakki.OrderManager;
import pakki.Person;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class OrderForm {

	private JFrame frame;
	private JTextField NametextField;
	private JTextField SocialtextField;
	private OrderManager om;
	private int counter;
	private int pplCount;
	private Flight f1;
	private Flight f2;
	private List<Person> list;
	private List<Person> list2;
	private int orderNr;
	private int orderNr2;
	private JTable table;
	private JTable table2;
	private String seat1;
	private String seat2;
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
					OrderForm window = new OrderForm(null, null,null, null, 3,1,5,4);
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
	public OrderForm(List<Person> list, List<Person> list2, Flight f1, Flight f2, int pplCount, int counter, int orderNr, int orderNr2) {
		this.pplCount=pplCount;
		this.counter=counter;
		this.f1=f1;
		this.f2=f2;
		this.list=list;
		this.list2=list2;
		this.orderNr=orderNr;
		this.orderNr2=orderNr2;
		om=new OrderManager();
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(51, 44, 141, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
		lblSocialSecurityNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSocialSecurityNumber.setBounds(14, 78, 178, 16);
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
		chckbxHandicapped.setBounds(14, 119, 135, 25);
		frame.getContentPane().add(chckbxHandicapped);
		
		JCheckBox chckbxSpecialBaggage = new JCheckBox("Special Baggage");
		chckbxSpecialBaggage.setBounds(14, 151, 152, 25);
		frame.getContentPane().add(chckbxSpecialBaggage);
		
		JLabel lblChooseSeat = new JLabel("Choose Departure Seat:");
		lblChooseSeat.setBounds(15, 192, 168, 16);
		frame.getContentPane().add(lblChooseSeat);
		
		Button Nextbutton = new Button("Next");
		Nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seat1!=null&&seat1!=""&&seat1!="Yours"){
					Person p=om.makePersons(NametextField.getText(), SocialtextField.getText(), chckbxHandicapped.isSelected(), chckbxSpecialBaggage.isSelected(), seat1, orderNr);
					list.add(p);
					counter++;
					if(f2!=null&&seat2!=null&&seat2!=""&&seat2!="Yours"){
						p=om.makePersons(NametextField.getText(), SocialtextField.getText(), chckbxHandicapped.isSelected(), chckbxSpecialBaggage.isSelected(), seat2, orderNr2);
						list2.add(p);
					}
					if(pplCount==counter+1){
						frame.dispose();
						LastOrderForm lof = new LastOrderForm(list, list2, f1, f2, orderNr, orderNr2);
						JFrame LastOrderFormWindow = lof.getFrame();
						LastOrderFormWindow.setVisible(true);
					}
					else {
						frame.dispose();
						OrderForm OF = new OrderForm(list, list2, f1, f2, pplCount, counter++, orderNr, orderNr2);
						JFrame OrderFormWindow = OF.getFrame();
						OrderFormWindow.setVisible(true);
					}
				}
				else
					System.out.println("vinsamlegast veldu ��r s�ti");
			}
		});
		Nextbutton.setBounds(194, 456, 98, 24);
		frame.getContentPane().add(Nextbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 225, 204, 211);
		frame.getContentPane().add(scrollPane);
		
		String column_names[]= {"A","B","C","D","E","F"};
	
		String [] [] s=f1.getSeats();
		
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			s=f1.getWithout(s, it.next().getSeat());
		}
		table = new JTable(new DefaultTableModel(
				s, 
				new String[]{
						"A","B","C","D","E","F"
						}
				));

		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);	
		JLabel seat1Label = new JLabel("");
		seat1Label.setBounds(180, 188, 72, 20);
		frame.getContentPane().add(seat1Label);
		
		JLabel seat2Label = new JLabel("");
		seat2Label.setBounds(364, 186, 64, 22);
		frame.getContentPane().add(seat2Label);
		
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
		        
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            seat1 = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		            seat1Label.setText(seat1);
		          }
		        }
		      }

		    });
		
		if(f2!=null){
			JScrollPane scrollPane2 = new JScrollPane();
			scrollPane2.setBounds(256, 225, 211, 214);
			frame.getContentPane().add(scrollPane2);
			scrollPane2.setViewportView(table2);
			JLabel lblChooseSeat_1 = new JLabel("Choose Arrival Seat:");
			lblChooseSeat_1.setBounds(273, 192, 152, 16);
			frame.getContentPane().add(lblChooseSeat_1);
			String [] [] s2=f2.getSeats();
			it=list2.iterator();
			while(it.hasNext()){
				s2=f2.getWithout(s2, it.next().getSeat());
			}
			table2 = new JTable(s2, column_names);
			scrollPane2.setViewportView(table2);
			table2.setCellSelectionEnabled(true);
			ListSelectionModel cellSelectionModel2 = table2.getSelectionModel();
			cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cellSelectionModel2.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) { 
			        int[] selectedRow = table2.getSelectedRows();
			        int[] selectedColumns = table2.getSelectedColumns();
			        for (int i = 0; i < selectedRow.length; i++) {
			          for (int j = 0; j < selectedColumns.length; j++) {
			            seat2 = (String) table2.getValueAt(selectedRow[i], selectedColumns[j]);
			            seat2Label.setText(seat2);
			          }
			        }		        
			      }
				});
		}
	}
}