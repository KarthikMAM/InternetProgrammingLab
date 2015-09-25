<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Session Tracking</title>
    </head>
    <body>
        <center>
            <%
                int visitCount = 0;

                if("reset".equals(request.getParameter("submit"))){
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                } else {
                    String visitCountKey = "visitCount";

                    if(session.isNew()) {
                        session.setAttribute(visitCountKey, visitCount);
                    }

                    visitCount = (int)session.getAttribute(visitCountKey) + 1;
                    session.setAttribute(visitCountKey, visitCount);
                }
            %>
            <% out.println("Visit Count : " + visitCount); %>
            <form action="index.jsp" method="get">
                <button name="submit" value="reset">reset</button>
                <button name="submit" value="refresh">refresh</button>
            </form>
        </center>
    </body>
</html>
