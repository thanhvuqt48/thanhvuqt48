
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String inputString = "Hi, my name is Vu .net"; %>
        <c:set var="s" value="<%=inputString%>"/>
        <c:if test="${fn:endsWith(s, '.net')}">
            <p>Input string ends with ".net" substring.</p>
        </c:if>
        <c:if test="${!fn:endsWith(s, '.net')}">
            <p>Input string does not end with ".net" substring.</p>
        </c:if>
    </body>
</html>
