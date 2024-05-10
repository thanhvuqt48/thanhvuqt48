<%-- 
    Document   : update
    Created on : Jan 30, 2024, 10:20:23 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ClassManagement" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <h1 style="color:blue">Update class</h1>
        <%
            ClassManagement c = (ClassManagement) request.getAttribute("class");
        %>

        <form action="update" method="post" id="up">
            <table>
                <tr>
                    <td>Enter ID:</td>
                    <td><input type="text" readonly name="id" value="<%= c.getId()%>"/></td>
                </tr>
                <tr>
                    <td>Enter Name:</td>
                    <td><input type="text" name="name" value="<%= c.getName()%>"/></td>
                </tr>
                <tr>
                    <td>Enter Number Of Student:</td>
                    <td><input type="text" name="num" value="<%= c.getNumberOfStudent()%>"/></td>
                </tr>
            </table>
        </form>
        <%
            String e = (String) request.getAttribute("error");
            if(e != null){
        %>
        <h3 style="color:red"><%=e%></h3>
        <%    
            }
        %>
        
    </body>
</html>
