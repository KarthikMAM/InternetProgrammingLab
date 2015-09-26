<%@ page import="java.io.*, java.sql.*" %>

<%
    //Constants for JDBC Connection
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/db";
    final String DB_USR = "root";
    final String DB_PASS = "2309";

    Class.forName(JDBC_DRIVER);
%>

<%
    //Constants for request processing
    final String REQUEST = "request";
    final String LOG_IN = "login";
    final String LOG_OUT = "logout";
    final String USER = "user";
    final String PASS = "pass";
    final String VISIT_COUNT = "visitCount";
%>

<%
    int visitCount = 0;
    String clientRequest = request.getParameter(REQUEST);

    if(LOG_OUT.equals(clientRequest)) {
        //If the client wishes to log out then invalidate the session
        //and redirect the user to this page again without any parameters
        session.invalidate();
        response.sendRedirect("index.jsp");
    } else if (LOG_IN.equals(clientRequest)) {
        //Get the user name and the password
        String user = request.getParameter(USER);
        String pass = request.getParameter(PASS);

        try {
            //Create the connection and
            //Prepare the query
            Connection con = DriverManager.getConnection(DB_URL, DB_USR, DB_PASS);
            PreparedStatement stmt = con.prepareStatement("select pass from users where user=?");
            stmt.setString(1, user);

            //Execute the query
            //and get the password and compare it with the user password
            //If success set the user visit count
            //else invalidate the session and redirect
            ResultSet result = stmt.executeQuery();
            if(result.next() && pass.equals(result.getString(1))) {
                session.setAttribute(VISIT_COUNT, visitCount);
            } else {
                session.invalidate();
            }
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            //Any exception must be handled here
        }
    } else if(session.getAttribute(VISIT_COUNT) != null) {
        //If the session attribute VISIT_COUNT is set
        //Then update the visit count
        visitCount = (int)session.getAttribute(VISIT_COUNT) + 1;
        session.setAttribute(VISIT_COUNT, visitCount);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title><%= visitCount != 0 ? visitCount == 1 ? "Welcome" : "Welcome Back" : "Login" %></title>
        <style>
            * {
                font-family: sans-serif;
                transition: all ease 200ms;
            }

            input:hover {
                box-shadow: 0px 0px 10px #3f4;
            }
        </style>
    </head>
    <body>
        <% /*
            * If the user has Successfully logged in
            * then visit count will be greater than 0 so display the visitCount page
            * otherwise display the login page again
            */ %>
        <% if(visitCount == 0) { %>
            <center>
                <form action="index.jsp" method="post">
                    <table border="1px">
                        <tr>
                            <th colspan="2">LOGIN FORM</th>
                        </tr>
                        <tr>
                            <td><b>User Name</b></td>
                            <td><input type="text" name="<%= USER%>"/></td>
                        </tr>
                        <tr>
                            <td><b>Password</b></td>
                            <td><input type="text" name="<%= PASS%>"/></td>
                        </tr>
                        <tr>
                            <td colspan=2><center><input type="submit" name="<%= REQUEST%>" value="<%= LOG_IN%>"/></center></td>
                        </tr>
                    </table>
                </form>
            </center>
        <% } else { %>
            <center>
                <h4>Visit Count = <%= visitCount %> </h4>
                <form action="index.jsp" method="post">
                    <input type="submit" name="<%= REQUEST%>" value="<%= LOG_OUT%>"/>
                </form>
            </center>
        <% } %>
    </body>
</html>
