<%-- 
    Document   : nhap
    Created on : Feb 21, 2024, 4:19:07 PM
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
        <h1>Nhap danh sach</h1>
        <form action="nhap">
            Nhap ho va ten: <input type="text" name="name"/><br/>
            <input type="submit" value="NHAP DU LIEU"/>
        </form>
        <h2>Danh sach nhap vao</h2>
        <h3 style="color:chocolate">${sessionScope.fu}</h3>
        <h3>
            <c:set var="i" value="1"/>
            <c:forEach items="${sessionScope.names}" var="c">
                ${i}. ${c}<br/>
                <c:set var="i" value="${(i+1)}"/>
                
            </c:forEach>
        </h3>
    </body>
</html>
