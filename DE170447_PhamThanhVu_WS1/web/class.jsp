<%-- 
    Document   : home
    Created on : Jan 30, 2024, 10:04:59 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ClassManagement, java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class Management</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
    <center id="center">
        <%
            List<ClassManagement> list = (List<ClassManagement>) request.getAttribute("data");
        %>
        <table border="1px" id="bang">
            <tr>
                <th>Class ID</th>
                <th>Name</th>
                <th>Number Of Student</th>
                <th>Action</th>
            </tr>
            <%
                for (ClassManagement c : list){
            %>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getName()%></td>
                <td><%= c.getNumberOfStudent()%></td>
                <td>
                    <a href="delete?id=<%= c.getId()%>">Delete</a>
                    <a href="update?id=<%= c.getId()%>">Update</a>
                </td>
            </tr>
            <%    
                }
            %>
        </table>
    </center>
</body>
</html>
