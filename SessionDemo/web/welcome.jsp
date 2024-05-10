<%-- 
    Document   : welcome
    Created on : Feb 21, 2024, 5:49:42 PM
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
        <h2>Day la trang nguoi dung</h2>
        <c:set var="a" value="${sessionScope.account}"/>
        <h1>Hello ${a.username}<br/>
            role: ${a.role}
        </h1>
    </body>
</html>
