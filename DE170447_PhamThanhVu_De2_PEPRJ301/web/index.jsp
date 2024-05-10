<%-- 
    Document   : home
    Created on : Mar 21, 2024, 7:38:45 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Magazine Management</h1>
        <table border="1px">
            <tr>
                <th>Magazine ID</th>
                <th>Magazine Name</th>
                <th>Issue Number</th>
                <th>Publisher</th>
            </tr>
            <c:forEach  items="${requestScope.magazines}" var="m">
                <tr>
                    <td>${m.id}</td>
                    <td>${m.name}</td>
                    <td>${m.issueNumber}</td>
                    <td>${m.publisher}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="add"><button type="submit">Add magazine</button></a>
        <h3>Total user: ${sessionScope.counter}</h3>
    </body>
</html>
