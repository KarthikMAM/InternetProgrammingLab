import java.util.*;
import javax.mail.*;

public class RecvMail {
    public static void main(String[] args) throws Exception {
        Properties prop = System.getProperties();
        prop.setProperty("mail.pop3.host", "127.0.0.1");

        Session session = Session.getDefaultInstance(prop);
        Store store = session.getStore("pop3");
        store.connect("karthik2@mailserver.com", "root");

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        for(Message msg: inbox.getMessages()) {
            System.out.println("From : " + msg.getFrom()[0]);
            System.out.println("Content : " + msg.getContent());
        }
        inbox.close(false);
        store.close();
    }
}
