import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletClass extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            ObjectInputStream in = new ObjectInputStream(req.getInputStream());
            String user = (String) in.readObject();
            String pass = (String) in.readObject();

            String result = "Failure";
            if("karthik".equals(user) && "karthik".equals(pass)) {
                result = "Success";
            }

            res.setContentType("application/x-java-serialized-object");
            ObjectOutputStream out = new ObjectOutputStream(res.getOutputStream());
            out.writeObject(result);
            out.flush();
            out.close();
        } catch(Exception e) {}
    }
}
