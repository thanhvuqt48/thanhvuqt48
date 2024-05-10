<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Set Locale Example</title>
</head>
<body>
    <h1>Set Locale Example</h1>
    
    <%-- Set the locale to English (United States) --%>
    <fmt:setLocale value="en_US" scope="session" />

    <%-- Define the current date/time --%>
    <%-- Using JSP expression --%>
    <%-- <% java.util.Date now = new java.util.Date(); %> --%>
    
    <%-- Using JSTL <c:set> --%>
    <c:set var="now" value="<%= new java.util.Date() %>" />
    
    <%-- Retrieve and display the current locale --%>
    <p>Current Locale: <fmt:formatDate value="${now}" type="date" /></p>
</body>
</html>