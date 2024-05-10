<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL Functions Demo</title>
    </head>
    <body>
        <% String inputString = "Hi, my name is Vu"; %>
        <c:set var="s" value="<%=inputString%>"/>
        <c:if test="${fn:contains(s, 'hi')}">
            <p>Input string contains "hi" substring.</p>
        </c:if>
        <c:if test="${!fn:contains(s, 'hi')}">
            <p>Input string does not contain "test" substring.</p>
        </c:if>
    </body>
</html>
