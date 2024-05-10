<%-- 
    Document   : admin
    Created on : Feb 21, 2024, 5:55:49 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Day la trang admin</h1>
        <h1>Hello Admin ${sessionScope.account.username}<br/>
            role: ${sessionScope.account.role}
        </h1>
    </body>
</html>
