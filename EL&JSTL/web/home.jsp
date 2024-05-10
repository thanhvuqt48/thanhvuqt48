<%-- 
    Document   : home
    Created on : Jan 20, 2024, 5:11:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ví dụ cho JSTL</h1>
        <c:set var="s" value="${requestScope.st}"/>
        <h2>Hello ${s.name}</h2>
        <img src="${(s.gender ? 'images/male.jpg' : 'images/female.png')}" alt="alt"/>
        <c:if test="${(s.mark >= 5)}">
            <h3>Passed</h3>
        </c:if>
        <c:if test="${(s.mark < 5)}">
            <h3>Failed</h3>
        </c:if>

        <form action="new">
            Enter number of student: <input type="text" name="num"/>
            <input type="submit" value="Enter"/>
        </form>
        <h1>Danh sách sinh viên</h1>
        <table border="1px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Mark</th>
                <th>Rank</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td><img src="${(i.gender ? 'images/male.jpg' : 'images/female.png')}" width='30%'/></td>
                    <td>${i.mark}</td>
                    <td>
                        <c:choose>
                            <c:when test="${i.mark < 5}">
                                Tinh anh
                            </c:when>
                            <c:when test="${(i.mark >= 5 && i.mark < 8)}">
                                Cao thủ
                            </c:when>
                                <c:when test="${i.mark >=8}">
                                Thách đấu
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
