package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlightSearchResult {

	private JFrame frame;
	private JTable table;
	
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
	 * Create the application.
	 */
	public FlightSearchResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				        int row = table.rowAtPoint(evt.getPoint());
//				        if () {
//				        }
				    }
				});
		scrollPane.setBounds(12, 42, 261, 119);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(12, 13, 67, 16);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(91, 13, 56, 16);
		frame.getContentPane().add(lblArrival);
	}
}
