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
            String role = "";
            if (cookieses != null) {
                for (int i = 0; i < cookieses.length; i++) {
                    Cookie cookie = cookieses[i];
                    if (cookie.getName().equals("uid-cookie")) {
                        uid = cookie.getValue();
                    } else if (cookie.getName().equals("role-cookie")) {
                        role = cookie.getValue();
                    }
                }
                if (!uid.isEmpty() && !role.isEmpty() && role.equals("3")) {
                    response.sendRedirect("./Product/productlist");
                } else if (!uid.isEmpty() && !role.isEmpty() && role.equals("1")){
                    response.sendRedirect("./admin.jsp");
                } else if (!uid.isEmpty() && !role.isEmpty() && role.equals("2")){
                    response.sendRedirect("./staff.jsp");
                }
            }
        %>



        <form action="${pageContext.request.contextPath}/login" method="post">
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
                            <h4>
                                Login
                            </h4>
                        </div>

                        <div class="login-form">
                            <input type="text" class="login-form-input" placeholder="Username" name="username" value="${param.username}">
                            <input type="password" class="login-form-input" placeholder="Password" name="password">
                            <h3 style="color: red; padding-top: 10px; font-weight: 400">${requestScope.error}</h3>
                            <button class="login-form-button" type="Submit">Sign In</button>

                            <div class="login-form-rememberMe">
                                <input type="checkbox" class="remberMe-cbx" id="checkbox_id" name="remember">
                                <label class="remember-lbl" for="checkbox_id">Remember me</label>
                            </div>
                        </div>


                        <div class="login-form-signupnow">
                            New to account?
                            <a href="./signup.jsp" class="login-form-signupnow-link">Sign up now.</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

