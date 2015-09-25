import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StudentSystem extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db";
    static final String USER = "root";
    static final String PASS = "2309";

    private String id;
    private String name;
    private String roll;
    private String branch;
    private String year;
    private String semester;
    private String dob;
    private String address;
    private String submit;

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        id = req.getParameter("id");
        name = req.getParameter("name");
        roll = req.getParameter("roll");
        branch = req.getParameter("branch");
        year = req.getParameter("year");
        semester = req.getParameter("semester");
        dob = req.getParameter("dob");
        address = req.getParameter("address");
        submit = req.getParameter("submit");


        try {
            Connection con = null;
            PreparedStatement stmt = null;

            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DB_URL, USER, PASS);
            switch(submit) {
                case "Add": {
                    stmt = con.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?, ?);");

                    stmt.setString(1, id);
                    stmt.setString(2, name);
                    stmt.setString(3, roll);
                    stmt.setString(4, branch);
                    stmt.setString(5, year);
                    stmt.setString(6, semester);
                    stmt.setString(7, dob);
                    stmt.setString(8, address);

                    stmt.execute();
                    break;
                }
                case "Edit": {
                    stmt = con.prepareStatement("update student set name = ?, roll = ?, branch = ?, year = ?, semester = ?, dob = ?, address = ? where id = ?;");

                    stmt.setString(8, id);
                    stmt.setString(1, name);
                    stmt.setString(2, roll);
                    stmt.setString(3, branch);
                    stmt.setString(4, year);
                    stmt.setString(5, semester);
                    stmt.setString(6, dob);
                    stmt.setString(7, address);

                    stmt.execute();
                    break;
                }
                case "Delete": {
                    stmt = con.prepareStatement("delete from student where id=?");

                    stmt.setString(1, id);

                    stmt.execute();
                    break;
                }
                default: {
                    break;
                }
            }

            stmt = con.prepareStatement("select * from student where id=?");
            stmt.setString(1, id);



            ResultSet result = stmt.executeQuery();

            if(result.next()) {
                id = result.getString(1);
                name = result.getString(2);
                roll = result.getString(3);
                branch = result.getString(4);
                year = result.getString(5);
                semester = result.getString(6);
                dob = result.getString(7);
                address = result.getString(8);
            }

            res.getWriter().printf(htmlDoc, id, name, roll, branch, year, semester, dob, address, submit + " Successful!");
        } catch(Exception e) { }
    }


    static public String htmlDoc =
    "<!DOCTYPE html>" +
    "<html>" +
        "<head>" +
            "<title>Student Information System</title>" +
        "</head>" +
        "<body>" +
            "<h4><center>Student Information System</center></h4>" +
            "<form name=\"detailsForm\" action=\"StudentSystem\" method=\"get\">" +
                "<table>" +
                    "<tr>" +
                        "<td><button name=\"submit\" value=\"Find\" onclick=\"buttonClick()\">Search</button></td>" +
                        "<td><button name=\"submit\" value=\"Add\" onclick=\"buttonClick()\">Add</button></td>" +
                        "<td><button name=\"submit\" value=\"Edit\" onclick=\"buttonClick()\">Edit</button></td>" +
                        "<td><button name=\"submit\" value=\"Delete\" onclick=\"buttonClick()\">Delete</button></td>" +
                    "</tr>" +
                "</table>" +
                "<table>" +
                    "<tr>" +
                        "<td><b>ID</b></td>" +
                        "<td><input type=\"text\" name=\"id\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Name</b></td>" +
                        "<td><input type=\"text\" name=\"name\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Roll</b></td>" +
                        "<td><input type=\"text\" name=\"roll\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Branch</b></td>" +
                        "<td><input type=\"text\" name=\"branch\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Year</b></td>" +
                        "<td><input type=\"text\" name=\"year\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Semester</b></td>" +
                        "<td><input type=\"text\" name=\"semester\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>DOB</b></td>" +
                        "<td><input type=\"text\" name=\"dob\" value=\"%s\"/></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><b>Address</b></td>" +
                        "<td><input type=\"text\" name=\"address\" value=\"%s\"/></td>" +
                    "</tr>" +
                "</table>" +
                "<p>%s</p>" +
            "</form>" +
        "</body>" +
    "</html>";
}
