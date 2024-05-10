<%-- 
    Document   : list
    Created on : Jan 30, 2024, 10:49:51 AM
    Author     : ACER
--%>

<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #ddd;
            }
        </style>
    </head>
    <body>
        <h1>Student List</h1>
        <table border="1px">
            <tr>
                <th>CustomerID</th>
                <th>Name</th>
                <th>NumberOfPuschaser</th> <!-- Fixed typo: "NumberOrStudent" to "NumberOfStudents" -->
                <th>Action</th>
            </tr>
            <% 
                List<Category> list = (List<Category>)request.getAttribute("data");
                for(Category category : list) { %>
            <tr>
                <td><%= category.getCustomerID() %></td>
                <td><%= category.getName() %></td>
                <td><%= category.getNumberOfPuscharses() %></td> <!-- Fixed method call: "getNumberOfStudents()" -->
                <td>
                    <a href="delete?id=<%=category.getCustomerID()%>">Delete</a>&nbsp;&nbsp;&nbsp;
                    <a href="update?id=<%=category.getCustomerID()%>">Update</a> <!-- Fixed method call: "getClassID()" -->
                </td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
