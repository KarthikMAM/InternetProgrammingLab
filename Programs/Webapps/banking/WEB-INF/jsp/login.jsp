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
    final String PASS_KEY = "pass";

    String user = request.getParameter(USER_KEY);
    String pass = request.getParameter(PASS_KEY);
%>

<%
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt = con.prepareStatement("select pass from users where user=?;");
    stmt.setString(1, user);
    ResultSet results = stmt.executeQuery();

    if(results.next() && pass.equals(results.getString(1))) {
        session.setAttribute(USER_KEY, user);
        response.sendRedirect("trans.jsp");
    } else {
        session.setAttribute(USER_KEY, null);
        response.sendRedirect("login.html");
    }
%>
