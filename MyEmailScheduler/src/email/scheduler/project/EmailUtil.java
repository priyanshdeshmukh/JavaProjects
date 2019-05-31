package email.scheduler.project;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	
	
	public static void main(String[] args) {
		sendEmail("priyanshdeshmukh06@gmail.com","Email Testing Subject1", "Email Testing Body1");
	}
	
	
	
	public static void sendEmail(String toEmail, String subject, String body){
		try
	    {
		  	
		  final String fromEmail = "priyansh.deshmukh@harbingergroup.com"; //requires valid gmail id
		  final String password = "april@123"; // correct password for gmail id
		 
		  Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
		  };
		  
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.office365.com"); //SMTP Host
		  props.put("mail.smtp.port", "587"); //TLS Port
	      props.put("mail.smtp.auth", "true"); //enable authentication
//		  props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
		  Session session = Session.getInstance(props, auth); 
		  MimeMessage msg = new MimeMessage(session);
		  Multipart multipart = new MimeMultipart();  // Attachment transmission format
		  BodyPart messageBodyPart = new MimeBodyPart();
		  
	      messageBodyPart = new MimeBodyPart();
          String filename = "D:\\newCsvFilewithPipe.csv";
          DataSource source = new FileDataSource(filename);
          messageBodyPart.setDataHandler(new DataHandler(source));
          messageBodyPart.setFileName(filename);
          multipart.addBodyPart(messageBodyPart);

          // Send the complete message parts
          msg.setContent(multipart);
		  
	      //set message headers
	  //    msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	    //  msg.addHeader("format", "flowed");
	     // msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("priyanshdeshmukh06@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("priyanshdeshmukh06@gmail.com", false));

	      msg.setSubject(subject);

	     // msg.setText(body);

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
		
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}