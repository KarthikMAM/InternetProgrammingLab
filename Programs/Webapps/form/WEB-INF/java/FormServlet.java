import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
    public String setRow(String fName, String fValue) {
        String row =
            "<tr>" +
                "<td>" + "<b>" + fName + "</b>" + "</td>" +
                "<td>" + fValue + "</td>" +
            "</tr>";
        return row;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String[] fieldNames = {
            "pName",
            "pTitle",
            "pJob",
            "pContact",
            "pBday",
            "pMobile",
            "pEmail",
            "pMarried"
        };

        String responseText = "<html><body><table>";
        for(int i=0; i<fieldNames.length; i++) {
            responseText += setRow(fieldNames[i], req.getParameter(fieldNames[i]));
        }
        responseText += "</body></html></table>";

        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println(responseText);
        } catch(Exception e) {e.printStackTrace();}
    }
}

/*http://localhost:8080/FormServlet/?
pName=jbhjhbhj
&pTitle=hbjbhjb
&pJob=bhjh
&pContact=9487907066
&pBday=ds&pID=98
&pMobile=9487907066
&pEmail=fhjdkfh%40jkfh.com
&pMarried=Married#*/
