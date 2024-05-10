<%-- 
    Document   : IfAction
    Created on : Feb 27, 2024, 10:28:21 AM
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
        <c:set var="income" scope="session" value="${1000*3}" />
	<c:if test="${income <= 4000}">
		<p>
			My income is:
			<c:out value="${income}" />
		<p>
	</c:if>
    </body>
</html>
