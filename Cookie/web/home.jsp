<%-- 
    Document   : home
    Created on : Feb 21, 2024, 9:48:08 PM
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
        <h1>Danh sach cookies</h1>
        <c:forEach items="${pageContext.request.cookies}" var="c">
            ${c.name} - ${c.value}<br/>
        </c:forEach>
    </body>
</html>
