package pakki;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Receipt {

	private JFrame frame;
	private Order o;
	private Order o2;
	
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
					Receipt window = new Receipt(null,null);
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
	
	public Receipt(Order o, Order o2) {
		this.o=o;
		this.o2=o2;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 382, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(35, 68, 49, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblOrderNumber = new JLabel("Order Number:");
		lblOrderNumber.setBounds(35, 28, 87, 16);
		frame.getContentPane().add(lblOrderNumber);
		
		JLabel OrderLabel = new JLabel(Integer.toString(o.getOrderNr()));
		OrderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		OrderLabel.setBounds(134, 26, 63, 16);
		frame.getContentPane().add(OrderLabel);
		
		JLabel NameLabel = new JLabel(o.getName());
		NameLabel.setBounds(96, 68, 133, 16);
		frame.getContentPane().add(NameLabel);
		
		JLabel lblSocialSecurityNumber = new JLabel("SSN:");
		lblSocialSecurityNumber.setBounds(35, 97, 49, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel SSClabel = new JLabel(o.getId());
		SSClabel.setBounds(96, 97, 105, 16);
		frame.getContentPane().add(SSClabel);
		
		JLabel DepartureLabel = new JLabel("Departure:");
		DepartureLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		DepartureLabel.setBounds(31, 151, 73, 16);
		frame.getContentPane().add(DepartureLabel);
		
		JLabel ArrivalLabel = new JLabel("Arrival:");
		ArrivalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ArrivalLabel.setBounds(35, 180, 69, 16);
		frame.getContentPane().add(ArrivalLabel);
		
		JLabel Departure2Label = new JLabel("Departure:");
		Departure2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Departure2Label.setVisible(false);
		Departure2Label.setBounds(194, 151, 73, 16);
		frame.getContentPane().add(Departure2Label);
		
		JLabel Arrival2Label = new JLabel("Arrival:");
		Arrival2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Arrival2Label.setVisible(false);
		Arrival2Label.setBounds(204, 180, 63, 16);
		frame.getContentPane().add(Arrival2Label);
		
		JLabel lblPrice = new JLabel("Final Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(57, 411, 119, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel PriceLabel = new JLabel(Integer.toString(o.getPrice()));
		PriceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		PriceLabel.setBounds(194, 410, 76, 16);
		frame.getContentPane().add(PriceLabel);
		
		Button Closebutton = new Button("Close");
		Closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		Closebutton.setBounds(134, 467, 79, 24);
		frame.getContentPane().add(Closebutton);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 240, 282, 142);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFlightPrice = new JLabel("Flight Price:");
		lblFlightPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlightPrice.setBounds(12, 13, 128, 16);
		panel.add(lblFlightPrice);
		
		JLabel lblNewLabel = new JLabel("Toddler Price:");
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 42, 128, 16);
		panel.add(lblNewLabel);
		
		JLabel lblAnimalPrice = new JLabel("Animal Price:");
		lblAnimalPrice.setVisible(false);
		lblAnimalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnimalPrice.setBounds(12, 71, 128, 16);
		panel.add(lblAnimalPrice);
		
		JLabel lblSpecialBaggagePrice = new JLabel("Special Baggage Price:");
		lblSpecialBaggagePrice.setVisible(false);
		lblSpecialBaggagePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecialBaggagePrice.setBounds(0, 98, 140, 16);
		panel.add(lblSpecialBaggagePrice);
		
		JLabel FlightPriceLabel = new JLabel(Integer.toString(o.getFlight().getPrice()*o.getPPLCount()));
		FlightPriceLabel.setBounds(152, 13, 56, 16);
		panel.add(FlightPriceLabel);
		if(o.getToddler()>0){
			JLabel ToddlerPriceLabel = new JLabel(Integer.toString(o.getToddler()*5000));
			ToddlerPriceLabel.setVisible(true);
			ToddlerPriceLabel.setBounds(152, 42, 56, 16);
			panel.add(ToddlerPriceLabel);
		}
		if(o.getAnimal()!=""){
			JLabel AnimalPriceLabel = new JLabel(Integer.toString(10000));
			AnimalPriceLabel.setVisible(true);
			AnimalPriceLabel.setBounds(152, 71, 56, 16);
			panel.add(AnimalPriceLabel);
		}
		if(o.getSpecialBaggage()>0){
			JLabel SBPLabel = new JLabel(Integer.toString(o.getSpecialBaggage()*6000));
			SBPLabel.setVisible(true);
			SBPLabel.setBounds(152, 98, 56, 16);
			panel.add(SBPLabel);
		}
		Image img;
		JLabel myndlabel = new JLabel("");
		if(o.getAnimal() == "dog"){
			System.out.println("Dog");
			img = new ImageIcon(this.getClass().getResource("dog.png")).getImage();
		}
		else if(o.getAnimal() == "Cat"){
			img = new ImageIcon(this.getClass().getResource("cat.png")).getImage();
		}
		else if(o.getAnimal() == "Fish"){
			img = new ImageIcon(this.getClass().getResource("fish.png")).getImage();
		}
		else if(o.getAnimal() == "Bunny"){
			System.out.println("bunny");
			img = new ImageIcon(this.getClass().getResource("bunny.png")).getImage();
		}
		else if(o.getAnimal() == "Snake"){
			img = new ImageIcon(this.getClass().getResource("snake.png")).getImage();
		}
		else if(o.getAnimal() == "Bird"){
			img = new ImageIcon(this.getClass().getResource("bird.png")).getImage();
		}
		
		else{
			img = new ImageIcon(this.getClass().getResource("dog.png")).getImage();
			System.out.println("else");
		}
		myndlabel.setIcon(new ImageIcon(img));
		myndlabel.setBounds(236, 28, 94, 97);
		frame.getContentPane().add(myndlabel);
		
		JLabel D1 = new JLabel(o.getFlight().getDepartureAirport());
		D1.setBounds(116, 151, 56, 16);
		frame.getContentPane().add(D1);
		
		JLabel A1 = new JLabel(o.getFlight().getDepartureAirport());
		A1.setBounds(116, 180, 56, 16);
		frame.getContentPane().add(A1);
		
		if(o2!=null){
			JLabel D2 = new JLabel(o2.getFlight().getDepartureAirport());
			D2.setBounds(274, 151, 68, 16);
			frame.getContentPane().add(D2);
			
			JLabel A2 = new JLabel(o2.getFlight().getArrivalAirport());
			A2.setBounds(274, 180, 56, 16);
			frame.getContentPane().add(A2);
		}
	}
}
