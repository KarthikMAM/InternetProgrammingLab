<%@ page import="java.sql.*,java.io.*" %>

<%
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/db";
    String USER = "root";
    String PASS = "2309";
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Results</title>
    </head>
    <body>
        <%
            Connection con = null;
            ResultSet answers = null;

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            answers = con.prepareStatement("select * from answers;").executeQuery();

            int score = 0;
            while(answers.next()) {
                String userAns = request.getParameter(answers.getString(1));
                if(userAns != null && userAns.equals(answers.getString(2))) {
                    score++;
                }
            }
        %>
        <center>
            <h4><%= "Your Score is " + score %></h4>
        </center>
    </body>
</html>
