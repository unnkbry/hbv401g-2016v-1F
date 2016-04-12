package pakki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Receipt {

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
					Receipt window = new Receipt();
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
	
	public Receipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(113, 99, 49, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblOrderNumber = new JLabel("Order Number:");
		lblOrderNumber.setBounds(61, 28, 87, 16);
		frame.getContentPane().add(lblOrderNumber);
		
		JLabel OrderLabel = new JLabel("XXXXX");
		OrderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		OrderLabel.setBounds(166, 26, 63, 16);
		frame.getContentPane().add(OrderLabel);
		
		JLabel NameLabel = new JLabel("Kalli J\u00F3nsson");
		NameLabel.setBounds(166, 99, 322, 16);
		frame.getContentPane().add(NameLabel);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
		lblSocialSecurityNumber.setBounds(12, 128, 161, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel label = new JLabel("020892-2329");
		label.setBounds(166, 128, 105, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Departure:");
		lblNewLabel.setBounds(89, 157, 73, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setBounds(106, 186, 56, 16);
		frame.getContentPane().add(lblArrival);
	}

}
