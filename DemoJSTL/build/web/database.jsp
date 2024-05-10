<%-- 
    Document   : database
    Created on : Feb 27, 2024, 11:15:52 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource 
            
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" 
            url="jdbc:sqlserver://localhost:1433;databaseName= Trading2024" 
            user="sa"
            password='123'
            var='DS'
            />

        <sql:query dataSource="${DS}" var="result">
            SELECT * from YouID;
        </sql:query>

    </body>
</html>
