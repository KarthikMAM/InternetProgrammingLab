import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
    public static void main(String[] args) {
        //Get the Properties and Create a default session
        Properties prop = System.getProperties();
        prop.setProperty("mail.server.com", "127.0.0.1");
        Session session = Session.getDefaultInstance(prop);

        try {
            //Set the mail headers
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("karthik1@mailserver.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("karthik2@mailserver.com"));
            msg.setSubject("First Mail");

            //Create the mime body and attachments
            MimeBodyPart msgBody = new MimeBodyPart();
            msgBody.setContent("Hello World", "text/html");

            MimeBodyPart attFile = new MimeBodyPart();
            attFile.attachFile("RecvMail.java");

            Multipart partMsg = new MimeMultipart();
            partMsg.addBodyPart(msgBody);
            partMsg.addBodyPart(attFile);

            msg.setContent(partMsg);

            Transport.send(msg);

            System.out.println("Message Successfully sent...");
        } catch(Exception e) { e.printStackTrace(); }
    }
}
