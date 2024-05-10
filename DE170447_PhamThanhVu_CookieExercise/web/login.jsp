<%-- 
    Document   : login
    Created on : Feb 21, 2024, 5:43:31 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        
    </head>
    <body>
       
        <h1>Login Form</h1>
        <form action="login" method="post">
            Enter username: <input type="text" name="user"/><br/>
            Enter password: <input type="text" name="pass"/><br/>
            <input type="checkbox" name="rem"/>Remember me<br/>
            <input type="submit" value="LOGIN"/>
        </form>
    </body>
</html>
