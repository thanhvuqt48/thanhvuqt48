<%-- 
    Document   : update
    Created on : Jan 30, 2024, 10:20:23 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <style>
            body, html {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
            }

            /* Style for the form container */
            form {
                width: 50%;
                margin: 0 auto;
            }
         
            /* Style for the table within the form */
            table {
                width: 100%;
                border-collapse: collapse;
            }

            /* Style for table cells */
            td {
                padding: 5px;
            }

            /* Style for input fields */
            input[type="text"], input[type="submit"] {
                padding: 5px;
                width: 100%;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            /* Style for submit button */
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
            }

            /* Style for submit button on hover */
            input[type="submit"]:hover {
                background-color: #45a049;
            }

            /* Style for error message */
            h3 {
                color: red;
            }
            h1{
                text-align: center;
                font-family: 'Open Sans', sans-serif;

                }
        </style>
    </head>
    <body>
        <h1>Update class</h1>
        <%
            Category c = (Category) request.getAttribute("category");
        %>

        <form action="update" method="post" id="up">
            <table>
                <tr>
                    <td>Enter ID:</td>
                    <td><input type="text" readonly name="id" value="<%= c.getCustomerID()%>"/></td>
                </tr>
                <tr>
                    <td>Enter Name:</td>
                    <td><input type="text" name="name" value="<%= c.getName()%>"/></td>
                </tr>
                <tr>
                    <td>Enter Number Of Student:</td>
                    <td><input type="text" name="num" value="<%= c.getNumberOfPuscharses()%>"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form>
        <%
            String e = (String) request.getAttribute("error");
            if (e != null) {
        %>
        <h3 style="color:red"><%=e%></h3>
        <%
            }
        %>

    </body>
</html>
