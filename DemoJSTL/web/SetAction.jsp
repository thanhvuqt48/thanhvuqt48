<%-- 
    Document   : SetAction
    Created on : Feb 27, 2024, 10:25:50 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="Income" value="${4000*2}" /> 
	<c:out value="${Income}" />
    </body>
</html>
