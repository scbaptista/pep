package go.server.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	public static boolean send(String to, String subject, String text) throws Exception {
		try {
			if ((to.trim() != null) && (!ServerUtil.validateEmailAddress(to.trim()))) {
				return false;
			}
			
			if (text.length() > 0) {
				text = text.replaceAll("\n", "<br>");
				String mail = text + "<br><br>" + ServerUtil.getSignature();
			
				return sendEmail(to, subject, mail);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return false;

	}

	private static boolean sendEmail(String to, String subject, String mail) {
		// Recipient's email ID needs to be mentioned.
//	      String to = "abcd@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "pg35390@uminho.pt";

	      // Assuming you are sending email from localhost
	      String host = "smtp.di.uminho.pt";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", "25");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	         return true;
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         return false;
	      }
		
	}

}
