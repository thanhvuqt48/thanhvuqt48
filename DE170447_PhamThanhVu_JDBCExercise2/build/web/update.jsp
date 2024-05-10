<%-- 
    Document   : update
    Created on : Jan 25, 2024, 7:56:56 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Student st = (Student) request.getAttribute("student");
        %>
        <h1>Update Student</h1>

        <form action="updateServlet" method="post">
            Enter ID:<input type="text" readonly name="id" value="<%= st.getId()%>"/><br/><br/>
            Enter Name: <input type="text" name="name" value="<%= st.getName()%>"/><br/><br/>
            Enter Gender: <input type="text" name="gender" value="<%= st.getGender()%>"/><br/>
            Enter Birthday: <input type="text" name="date" value="<%= st.getBirthday()%>"/><br/>
            <input type="submit" value="Update"/><br/>
        </form>
    </body>
</html>
