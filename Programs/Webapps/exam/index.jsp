<%@ page import="java.sql.*,java.io.*"%>

<%
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/db";
    String USER = "root";
    String PASS = "2309";
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Questions</title>
    </head>
    <body>
        <h3><center>Online Test</h3></center>
        <%
            try {
                Connection con = null;
                ResultSet questions = null;
                ResultSet options = null;

                Class.forName(JDBC_DRIVER);
                con = DriverManager.getConnection(DB_URL, USER, PASS);

                questions = con.prepareStatement("select * from questions").executeQuery();
                options = con.prepareStatement("select * from options").executeQuery();

                out.println("<form action='results.jsp' method='get'>");
                    while(questions.next()) {
                        out.println("<b> " + questions.getString(1) + ". " + questions.getString(2) + " <b><br>");

                        for(int i=0; i<3; i++) {
                            options.next();
                            out.println("<input type='radio' name='" + questions.getString(1) + "'" + "value='" + options.getString(2) + "'>");
                            out.println((i + 1) + ". " + options.getString(2) + "<br>");
                            out.println("</input>");
                        }

                        out.println("<br>");
                    }
                out.println("<input type='submit' value='Check Results'>");
                out.println("</form>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
