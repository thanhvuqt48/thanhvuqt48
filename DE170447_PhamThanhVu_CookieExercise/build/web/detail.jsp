<%-- 
    Document   : detail
    Created on : Feb 21, 2024, 10:16:33 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
    </head>
    <body>
        <% 
        String displayName = (String) request.getAttribute("us");
        if (displayName == null){
            Cookie[] cookies = request.getCookies();
            
            if (cookies == null){
            response.sendRedirect("login.jsp");
            } else {
                for (int i = 0; i < cookies.length; i++){
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals("cuser")){
                      displayName = cookie.getValue();
                      break;
                    }
                }
                if (displayName == null){
                    response.sendRedirect("login.jsp");
                }
            }
        }
        %>
        <h1>Welcome <%= displayName%></h1>
    </body>
</html>
