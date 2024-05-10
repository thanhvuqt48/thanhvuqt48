<%-- 
    Document   : login
    Created on : Mar 6, 2024, 5:33:18 AM
    Author     : ADMIN
--%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginCSS.css">
        <title>Login</title>
    </head>
    <body>
        <%
            Cookie[] cookieses = request.getCookies();
            String uid = "";
            String password = "";
            if (cookieses != null) {
                for (int i = 0; i < cookieses.length; i++) {
                    Cookie cookie = cookieses[i];
                    if (cookie.getName().equals("uid-cookie")) {
                        uid = cookie.getValue();
                    } else if (cookie.getName().equals("password-cookie")) {
                        password = cookie.getValue();
                    }
                }
                if (!uid.isEmpty() && !password.isEmpty()) {
                    response.sendRedirect("./product");
                }
            }
        %>




        <div class="login-container">
            <div class="background-image">
                <img src="${pageContext.request.contextPath}/images/bgnike.jpg" alt="Background Image">
            </div>
            <div class="login-header">
                <img src="${pageContext.request.contextPath}/images/lognike.png" alt="">
            </div>

            <div class="login-body">
                <!-- Form Login -->
                <div class="login-form-container">
                    <div class="login-form-header">
                        <h6>
                            Change Password
                        </h6>
                    </div>

                    <form action="${pageContext.request.contextPath}/changepass" method="post">
                        <div class="login-form">
                            <input type="password" class="login-form-input" placeholder="Old password" name="oldpass" >
                            <input type="password" class="login-form-input" placeholder="New password" name="newpass">
                            <input type="password" class="login-form-input" placeholder="Re-password" name="repass">
                            <h3 style="color: red; padding-top: 10px; font-weight: 400">${requestScope.error}</h3>
                            <button class="login-form-button" type="Submit">Change password</button>

                        </div>
                    </form>
                            <a  href="${pageContext.request.contextPath}/productlist"><button style="    margin-top: -1px;" class="login-form-button" type="Submit">Back home</button></a>




                </div>
            </div>
        </div>
    </div>
</body>
</html>

