<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>XML Core Actions Example</title>
</head>
<body>
    <h1>XML Core Actions Example</h1>
    
    <%-- XML data to be parsed --%>
    <%
        String xmlData = "<book><title>Harry Potter</title><author>J.K. Rowling</author></book>";
    %>
    
    <%-- Parse the XML data --%>
    <x:parse var="parsedXml" xml="<%= xmlData %>"/>
    
    <%-- Output the parsed XML --%>
    <x:out select="$parsedXml/book/title"/> <!-- Output: Harry Potter -->
    <x:out select="$parsedXml/book/author"/> <!-- Output: J.K. Rowling -->
    
    <%-- Modify and set new XML data --%>
    <%
        String newXmlData = "<book><title>The Hobbit</title><author>J.R.R. Tolkien</author></book>";
    %>
    <x:set var="parsedXml" select="<%= newXmlData %>"/>
    
    <%-- Output the modified XML --%>
    <x:out select="$parsedXml/book/title"/> <!-- Output: The Hobbit -->
    <x:out select="$parsedXml/book/author"/> <!-- Output: J.R.R. Tolkien -->
</body>
</html>