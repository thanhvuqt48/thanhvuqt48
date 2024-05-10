
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
        <% String inputString = "www Hi, my name is Vu .net"; %>
        <c:set var="s" value="<%=inputString%>"/>
        <c:if test="${fn:startsWith(s, 'www')}">
            <p>Input string starts with "www" substring.</p>
        </c:if>
        <c:if test="${!fn:startsWith(s, 'www')}">
            <p>Input string does not start with "www" substring.</p>
        </c:if>
    </body>
</html>
