
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
        <% String inputString = "One,Two,Three,Four,Five"; %>
        <c:set var="s" value="<%=inputString%>"/>
        <c:set value="${fn:split(s, ',')}" var="a"/>
        <c:set value="${fn:join(a, ' ')}" var="d"/>
        <p>${d}</p>
       
    </body>
</html>
