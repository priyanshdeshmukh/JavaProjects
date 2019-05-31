package emailpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailBySite {
	public static void main(String[] args) throws AddressException {

		String host = "smtp.gmail.com";
		final String user = "priyanshdeshmukh06@gmail.com";// change accordingly
		final String password = "pihuuyuj06";// change accordingly

//		String to = "priyanshdeshmukh06@gmail.com";// change accordingly

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// final String user = props.getProperty("spring.mail.username");
		// final String password = props.getProperty("spring.mail.password");

		try {
			InputStream is = new FileInputStream("resources/application.properties");
			try {
				props.load(is);
				System.out.println(props.getProperty("spring.mail.username"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		InternetAddress[] sendTo = new InternetAddress[2];
		
			sendTo[0] = new InternetAddress("suraj.paigude@harbingergroup.com");
			sendTo[1] = new InternetAddress("priyanshdeshmukh06@gmail.com");
		

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipients(javax.mail.internet.MimeMessage.RecipientType.TO,sendTo);
			message.setSubject("Test Mail");
			message.setText("This is simple program of sending email using JavaMail API");

			// send the message
//			 Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}