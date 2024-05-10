<%-- 
    Document   : book
    Created on : Mar 3, 2024, 8:52:08 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
        <h2>Employee List</h2>

        <table border="1px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.address}</td>
                    <td>${e.email}</td>
                    
                </tr>
            </c:forEach>

        </table>
        <c:set var="page" value="${requestScope.page}" />
        <c:set var="numberPage" value="${requestScope.numberPage}" />
        <div class="pagination">
            <a href="employee?page=${1}}"> << </a>&nbsp;
            <a href="employee?page=${page-1 == 0 ? 1 : page-1}"> < </a>&nbsp;
            ${page}&nbsp;
            <a href="employee?page=${page+1 > numberPage ? numberPage : page+1}}"> > </a>&nbsp;
            <a href="employee?page=${numberPage}"> >> </a>&nbsp;
        </div>
    </body>
</html>
