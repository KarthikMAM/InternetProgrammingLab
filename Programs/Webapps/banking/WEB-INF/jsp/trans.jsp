<%@ page import="java.io.*, java.sql.*"%>

<%
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost/db";
    final String USER = "root";
    final String PASS = "2309";

    Class.forName(DRIVER);
%>

<%
    final String USER_KEY = "user";
    final String WITHDRAW = "withdraw";
    final String DEPOSIT = "deposit";

    String user = (String)session.getAttribute(USER_KEY);

    if(user == null) {
        response.sendRedirect("login.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styles.css" charset="utf-8">
        <title><%= user %></title>
    </head>
    <body>
        <center>
            <form action="process.jsp" method="post">
                <table>
                    <tr>
                        <th colspan="2">
                            <br>
                            <h4>Transaction Form</h4>
                        </th>
                    </tr>
                    <tr>
                        <td><b>Option</b></td>
                        <td>
                            <input type="radio" name="mode" value="<%= WITHDRAW %>"><%= WITHDRAW %></input><br>
                            <input type="radio" name="mode" value="<%= DEPOSIT %>"><%= DEPOSIT %></input><br>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Amount</b></td>
                        <td><input type="number" name="amount"></td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <br>
                            <input type="submit" value="Go!"></input>
                        </th>
                    </tr>
                </table>
            </form>
        </center>
</html>
