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
            String username = "";
            String password = "";
            if (cookieses != null) {
                for (int i = 0; i < cookieses.length; i++) {
                    Cookie cookie = cookieses[i];
                    if (cookie.getName().equals("uid-cookie")) {
                        username = cookie.getValue();
                    } else if (cookie.getName().equals("password-cookie")) {
                        password = cookie.getValue();
                    }
                }
                if (!username.isEmpty() && !password.isEmpty()) {
                    response.sendRedirect("./productlist");
                }
            }
        %>
        <form action="${pageContext.request.contextPath}/updateinformation" method="post">
            <div class="login-container">
                <div class="background-image">
                    <img src="${pageContext.request.contextPath}/images/bgnike.jpg" alt="Background Image">
                </div>
                <div class="login-header">
                    <img src="${pageContext.request.contextPath}/images/lognike.png" alt="">
                </div>

                <div class="login-body" style="margin-top: 50px ">
                    <!-- Form Login -->
                    <div class="login-form-container">
                        <div class="login-form-header">
                            <h6 >
                                Update Information     
                            </h6>
                        </div>

                        <div class="login-form">
                            <c:set var="a" value="${requestScope.ac}"/>
                            <input type="text" class="login-form-input" placeholder="Username" name="username" value="${a.username == null ? param.username : a.username}" readonly>
                            <input type="text" class="login-form-input" placeholder="Fullname" name="fullname" value="${a.name == null ? param.fullname : a.name }" required>
                            <input type="number" class="login-form-input" placeholder="Phonenumber" name="phonenumber" value="${a.phoneNumber == null ? param.phoneNumber : a.phoneNumber}"  required>
                            <input type="text" class="login-form-input" placeholder="Address" name="address" value="${a.address == null ? param.address : a.address}"  required>
                            <h3 style="color: red; padding-top: 10px; font-weight: 400">${requestScope.error}</h3>
                            <button class="login-form-button" type="submit">Update Account</button>
                        </div>



                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
