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
    final String VIEW = "view";
    final String AMT = "amount";
    final String MODE = "mode";

    String user = (String)session.getAttribute(USER_KEY);
    int balance = 0;
    int transAmt = new Integer(request.getParameter(AMT));
    String mode = request.getParameter(MODE);

    if(user == null || transAmt == 0 || mode == null) {
        response.sendRedirect("trans.jsp");
    }
%>

<%
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt = con.prepareStatement("select amt from account where user = ?;");
    stmt.setString(1, user);
    ResultSet result = stmt.executeQuery();

    if(result.next()) {
        balance = result.getInt(1);

        if(WITHDRAW.equals(mode)) {
            if(balance >= transAmt) {
                balance -= transAmt;
            } else {
                transAmt = 0;
            }
        } else {
            balance += transAmt;
        }

        PreparedStatement update = con.prepareStatement("update account set amt=? where user=?;");
        update.setInt(1, balance);
        update.setString(2, user);
        update.execute();
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
            <table>
                <tr>
                    <th colspan="2"><h4>Transaction Results</h4></th>
                </tr>
                <tr>
                    <td><b>Client</b></td>
                    <td><%= user %></td>
                </tr>
                <% if(transAmt == 0) { %>
                    <tr>
                        <th colspan="2">
                            <br>
                            <b>Transaction Failure due to insufficient funds</b>
                        </th>
                <% } else { %>
                    <tr>
                        <td><b>Standing Balance</b></td>
                        <td><%= balance %></td>
                    </tr>
                    <tr>
                        <td><b>Transaction Amount</b></td>
                        <td><%= transAmt %></td>
                    </tr>
                <% } %>
                <tr>
                    <th colspan="2">
                        <br>
                        <button onclick="location.href='trans.jsp'">Another Transaction</button>
                    </th>
                </tr>
            </table>
        </center>
</html>
