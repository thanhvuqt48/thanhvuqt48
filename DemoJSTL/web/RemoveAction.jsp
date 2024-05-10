<%-- 
    Document   : RemoveAction
    Created on : Feb 27, 2024, 10:26:45 AM
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
        <c:set var="income" scope="session" value="${4000*2}" />
	<p>
		Before Remove Value is:
		<c:out value="${income}" />
	</p>
	<c:remove var="income" /> 
	<p>
		After Remove Value is:
		<c:out value="${income}" />
	</p>
    </body>
</html>
