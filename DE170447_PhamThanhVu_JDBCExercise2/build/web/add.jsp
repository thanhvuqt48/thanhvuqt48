<%-- 
    Document   : add
    Created on : Jan 24, 2024, 10:14:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String e = (String) request.getAttribute("error");
        %>
        <h1>Add new student</h1>
        <%
            if (e != null){
        %>
        <h3><%=e%></h3>
        <%    
            }
        %>
        <form action="add">
            Enter ID: <input type="text" name="id"/><br/>
            Enter Name: <input type="text" name="name"/><br/>
            Enter Gender: <input type="text" name="gender"/><br/>
            Enter Birthday: <input type="text" name="date"/><br/>
             <input type="submit" value="Submit"/><br/>
        </form>
    </body>
</html>
