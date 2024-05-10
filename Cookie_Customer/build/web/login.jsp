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
        <% 
            Cookie[] cookies = request.getCookies();
            String username = "";
            String password = "";
            if (cookies != null){
                for (int i = 0; i < cookies.length; i++){
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals("cuser")){
                        username = cookie.getValue();
                    } else if (cookie.getName().equals("cpass")){
                        password = cookie.getValue();
                    }
                }
                if (password.equals("123") && username.equals("administrator")){
                    response.sendRedirect("list");
                }
            }
        
        %>
        <h1>Login Form</h1>
        <form action="login" method="post">
            Enter username: <input type="text" name="user"/><br/>
            Enter password: <input type="text" name="pass"/><br/>
            <input type="checkbox" name="rem"/>Remember me<br/>
            <input type="submit" value="LOGIN"/>
        </form>
    </body>
</html>
