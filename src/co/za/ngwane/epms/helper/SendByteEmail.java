package co.za.ngwane.epms.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;

public class SendByteEmail {
	
   public void sendEmail(String to, String cc, String subject, String body, byte[] attachment) {
	  System.out.println("Sending Mail"); 

      // Setup mail server
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");  
      props.put("mail.smtp.socketFactory.port", "465");  
      props.put("mail.smtp.socketFactory.class",  
              "javax.net.ssl.SSLSocketFactory");  
      props.put("mail.smtp.auth", "true");  
      props.put("mail.smtp.port", "465"); 

      // Get the default Session object.
      Session session = Session.getDefaultInstance(props, new Authenticate("mokkhutu", "f@3953335"));

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress("mokkhutu@gmail.com"));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setText(body);
         
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);
         
         String filename;
         if (attachment != null)
		{
			//construct the pdf body part
			messageBodyPart = new MimeBodyPart();
			filename = "cashupreport.pdf";
			DataSource dataSource1 = new ByteArrayDataSource(attachment, "application/pdf");
			messageBodyPart.setDataHandler(new DataHandler(dataSource1));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
		}
		// Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      } catch (Exception e) {
		e.printStackTrace();
	}
   }
   	

   public void writePDFFileOnDIsk(byte[] data, String fileName) throws IOException{
	   System.out.println("Writing to disk " + fileName); 
     FileOutputStream out = new FileOutputStream("/opt/glassfish3/glassfish/domains/domain1/" +"applications/DRC/WEB-INF/certificates/" + fileName);
     out.write(data);
     out.close();
     System.out.println("Writing to disk done " + fileName); 
   }


}