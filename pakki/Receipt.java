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
		DepartureLabel.setBounds(31, 178, 73, 16);
		frame.getContentPane().add(DepartureLabel);
		
		JLabel ArrivalLabel = new JLabel("Arrival:");
		ArrivalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ArrivalLabel.setBounds(35, 197, 69, 16);
		frame.getContentPane().add(ArrivalLabel);
		
		JLabel Departure2Label = new JLabel("Departure:");
		Departure2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Departure2Label.setVisible(true);
		Departure2Label.setBounds(194, 178, 73, 16);
		frame.getContentPane().add(Departure2Label);
		

		
		JLabel Arrival2Label = new JLabel("Arrival:");
		Arrival2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Arrival2Label.setVisible(true);
		Arrival2Label.setBounds(204, 197, 63, 16);
		frame.getContentPane().add(Arrival2Label);
		

		
		JLabel lblPrice = new JLabel("Final Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(57, 411, 119, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel PriceLabel = new JLabel(Integer.toString(o.getPrice() + o2.getPrice()));
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
		
		JPanel flight1panel = new JPanel();
		flight1panel.setBounds(10, 240, 162, 150);
		frame.getContentPane().add(flight1panel);
		flight1panel.setLayout(null);
		
		JLabel lblFlight1Price = new JLabel("Flight Price:");
		lblFlight1Price.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlight1Price.setBounds(-62, 13, 128, 16);
		flight1panel.add(lblFlight1Price);
		
		JLabel lblToddler1Label = new JLabel("Toddler Price:");
		lblToddler1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToddler1Label.setBounds(0, 40, 72, 16);
		flight1panel.add(lblToddler1Label);
		
		JLabel lblAnimal1Price = new JLabel("Animal Price:");
		lblAnimal1Price.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnimal1Price.setBounds(-20, 67, 86, 16);
		flight1panel.add(lblAnimal1Price);
		
		JLabel lblSpecialBaggage1Price = new JLabel("Special Baggage Price:");
		lblSpecialBaggage1Price.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecialBaggage1Price.setBounds(-27, 94, 140, 16);
		flight1panel.add(lblSpecialBaggage1Price);
		
		JLabel FlightPrice1Label = new JLabel(Integer.toString(o.getFlight().getPrice()*o.getPPLCount()));
		FlightPrice1Label.setBounds(148, 13, 56, 16);
		flight1panel.add(FlightPrice1Label);
		
		JLabel ToddlerPrice1Label = new JLabel(Integer.toString(o.getToddler()*5000));
		ToddlerPrice1Label.setVisible(true);
		ToddlerPrice1Label.setBounds(148, 40, 56, 16);
		flight1panel.add(ToddlerPrice1Label);
		
		int s=1;
		if(o.getAnimal()=="")
			s=0;
		
		JLabel AnimalPrice1Label = new JLabel(Integer.toString(s*10000));
		AnimalPrice1Label.setVisible(true);
		AnimalPrice1Label.setBounds(123, 67, 56, 16);
		flight1panel.add(AnimalPrice1Label);
		
		JLabel SBP1Label = new JLabel(Integer.toString(o.getSpecialBaggage()*6000));
		SBP1Label.setVisible(true);
		SBP1Label.setBounds(148, 94, 23, 16);
		flight1panel.add(SBP1Label);
		
		JLabel lblFinalPrice1 = new JLabel("Final Price:");
		lblFinalPrice1.setBounds(37, 125, 59, 14);
		flight1panel.add(lblFinalPrice1);
		
		JLabel FinalPrice1Label = new JLabel(Integer.toString(o.getPrice()));
		FinalPrice1Label.setBounds(106, 125, 46, 14);
		flight1panel.add(FinalPrice1Label);
		
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
		D1.setBounds(116, 178, 66, 16);
		frame.getContentPane().add(D1);
		
		JLabel A1 = new JLabel(o.getFlight().getArrivalAirport());
		A1.setBounds(116, 197, 63, 16);
		frame.getContentPane().add(A1);
		
		JLabel lblFlightNumber = new JLabel("Flight Number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlightNumber.setBounds(15, 156, 89, 16);
		frame.getContentPane().add(lblFlightNumber);
		
		JLabel FN1 = new JLabel(Integer.toString(o.getFlight().getFlightnr()));
		FN1.setBounds(116, 156, 56, 16);
		frame.getContentPane().add(FN1);
		
		JLabel lblFlightNumber_1 = new JLabel("Flight Number:");
		lblFlightNumber_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlightNumber_1.setBounds(173, 156, 94, 16);
		frame.getContentPane().add(lblFlightNumber_1);
		
		JLabel FN2 = new JLabel(Integer.toString(o2.getFlight().getFlightnr()));
		FN2.setBounds(277, 156, 56, 16);
		frame.getContentPane().add(FN2);
		
		JLabel D2 = new JLabel(o2.getFlight().getDepartureAirport());
		D2.setBounds(277, 178, 68, 16);
		frame.getContentPane().add(D2);
			
		JLabel A2 = new JLabel(o2.getFlight().getArrivalAirport());
		A2.setBounds(277, 197, 56, 16);
		frame.getContentPane().add(A2);
		
		JPanel flight2panel = new JPanel();
		flight2panel.setBounds(182, 240, 174, 150);
		frame.getContentPane().add(flight2panel);
		flight2panel.setLayout(null);
		
		JLabel lblFlight2Price = new JLabel("Flight Price:");
		lblFlight2Price.setBounds(10, 11, 56, 14);
		flight2panel.add(lblFlight2Price);
		
		JLabel lblToddler2Price = new JLabel("Toddler Price:");
		lblToddler2Price.setBounds(10, 40, 66, 14);
		flight2panel.add(lblToddler2Price);
		
		JLabel lblAnimal2Price = new JLabel("Animal Price:");
		lblAnimal2Price.setBounds(10, 71, 66, 14);
		flight2panel.add(lblAnimal2Price);
		
		JLabel lblSpecialBaggage2Price = new JLabel("Special Baggage Price:");
		lblSpecialBaggage2Price.setBounds(10, 97, 108, 14);
		flight2panel.add(lblSpecialBaggage2Price);
		
		JLabel FlightPrice2Label = new JLabel(Integer.toString(o2.getFlight().getPrice()*o2.getPPLCount()));
		FlightPrice2Label.setBounds(148, 11, 46, 14);
		flight2panel.add(FlightPrice2Label);
		
		JLabel ToddlerPrice2Label = new JLabel(Integer.toString(o2.getToddler()*5000));
		ToddlerPrice2Label.setBounds(148, 40, 46, 14);
		flight2panel.add(ToddlerPrice2Label);
		
		int r=1;
		if(o2.getAnimal()=="")
			r=0;
		
		JLabel AnmialPrice2Label = new JLabel(Integer.toString(r*10000));
		AnmialPrice2Label.setBounds(128, 71, 46, 14);
		flight2panel.add(AnmialPrice2Label);
		
		JLabel SBS2Label = new JLabel(Integer.toString(o2.getSpecialBaggage()*6000));
		SBS2Label.setBounds(148, 97, 46, 14);
		flight2panel.add(SBS2Label);
		
		JLabel lblFinalPrice2 = new JLabel("Final Price:");
		lblFinalPrice2.setBounds(38, 125, 56, 14);
		flight2panel.add(lblFinalPrice2);
		
		JLabel FinalPrice2Label = new JLabel(Integer.toString(o2.getPrice()));
		FinalPrice2Label.setBounds(118, 125, 46, 14);
		flight2panel.add(FinalPrice2Label);
	
		
		
		
		if(o2==null){
			flight2panel.setVisible(false);
			/*FN2.setVisible(false);
			D2.setVisible(false);
			A2.setVisible(false);
			Departure2Label.setVisible(false);
			Arrival2Label.setVisible(false);
			flight2panel.setVisible(false);
			*/
		}
	}
}
