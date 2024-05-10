<%-- 
    Document   : student
    Created on : Jan 23, 2024, 11:29:41 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student, java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
    <center>
        <% 
                List<Student> stList = (List<Student>) request.getAttribute("data");
        %>
        <table border="1px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Action</th>
            </tr>
            <%
                if (stList != null){
            %>

            <%
            for (Student st : stList){        
            %>
            <tr>
                <td><%= st.getId()%></td>
                <td><%= st.getName()%></td>
                <td><%= st.getGender()%></td>
                <td><%= st.getBirthday()%></td>
                <td>
                    <a href="updateServlet?id=<%= st.getId()%>">Update</a>
                    <a href="deleteServlet?id=<%= st.getId()%>">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%  
            }
        %>
        <h3 ><a href="add.jsp">Create</a></h3>
    </center>


</body>
</html>
