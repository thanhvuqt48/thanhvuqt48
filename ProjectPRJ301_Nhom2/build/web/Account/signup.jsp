<%-- 
    Document   : signup
    Created on : Mar 6, 2024, 9:55:30 AM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signupCSS.css">
        <title>Sign Up</title>
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
                if (!uid.isEmpty() && !role.isEmpty()) {
                    response.sendRedirect("../productlist");
                }
            }
        %>

        <form action="${pageContext.request.contextPath}/signup" method="post">
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
                                Sign up      
                            </h4>
                        </div>

                        <div class="login-form">
                            <input type="text" class="login-form-input" placeholder="Username" name="username" value="${param.username}" required>
                            <input type="text" class="login-form-input" placeholder="Fullname" name="fullname" value="${param.fullname}" required>
                            <input type="text" class="login-form-input" placeholder="Phonenumber" name="phonenumber" value="${param.phonenumber}"  required>
                            <input type="text" class="login-form-input" placeholder="Address" name="address" value="${param.address}"  required>
                            <input type="password" class="login-form-input" placeholder="Enter the password" name="password"  required>
                            <input type="password" class="login-form-input" placeholder="Re-Enter the password" name="repassword"  required>
                            <h3 style="color: red; padding-top: 10px; font-weight: 400">${requestScope.error}</h3>
                            <button class="login-form-button" type="submit">Sign up</button>
                        </div>


                        <div class="login-form-signupnow">
                            You have account?
                            <a href="./login.jsp" class="login-form-signupnow-link">Sign in now.</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
