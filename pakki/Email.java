package pakki;

public class Email {
	
	public static void main(String[] args){
		String[] to = {"ragnh94@gmail.com"};
		if(EmailSender.sendMail
				("dreamteam.flightservice@gmail.com", 
						"0412952019", 
						"Thank you for using the flight-service from DreamTeam! Here is your receipt!", to)) {
			System.out.println("email sent successful");
		}
		else System.out.println("Some error occured");	
	}
}
