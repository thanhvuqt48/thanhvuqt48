<%-- 
    Document   : insert
    Created on : Mar 6, 2024, 8:43:29 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="" crossorigin="anonymous" />
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px; /* Đặt chiều rộng tối đa cho container */
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #00a2fe;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="text"], input[type="number"]
        {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #00a2fe;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #007bbf;
        }

    </style>
    <body>
        <%
            Cookie[] cookieses = request.getCookies();
            String role_raw = "";
            int role;
            if (cookieses != null) {
                for (int i = 0; i < cookieses.length; i++) {
                    Cookie cookie = cookieses[i];
                    if (cookie.getName().equals("role-cookie")) {
                        role_raw = cookie.getValue();
                        try {
                            role = Integer.parseInt(role_raw);
                            if (role == 3) {
                                response.sendRedirect("../productlist");
                            }
                        } catch (NumberFormatException e) {

                        }
                    }

                }
            }
        %>
        <a href="${pageContext.request.contextPath}/login">
            <i class="fas fa-home" style="color: black; width: 28px; font-size: 28px;; padding-bottom: 15px"></i>
        </a>
        <div class="container">
            <h1 style="text-align: center;
                color: #00a2fe  ;
                ">New a Staff</h1>
            <form action="addstaff" method="post">
                
                <label for="username">User Name</label><br>
                <input type="text" id="username" name="username" value="${param.username}" required><br>
                <label for="name">Name</label><br>
                <input id="fullname" type="text" name="fullname" value="${param.fullname }" required></input><br>
                <label for="phonenumber">Phone number</label><br>
                <input id="phonenumber" type="text" name="phonenumber" value="${ param.phonenumber }" required></input><br>
                <label for="address">Address</label><br>
                <input id="address" type="text" name="address" value="${param.address}" required></input>
                <label for="address">Password</label><br>
                <input id="password" type="text" name="password" value="${param.password}" required></input>
                <label for="address">Re-Password</label><br>
                <input id="repassword" type="text" name="repassword" value="${param.password}" required></input>
                <h2 style="color: red">${requestScope.error}</h2>

                <input type="submit" value="ADD" style="font-weight: 700; font-size: 20px">
            </form>
        </div>
    </body>
</html>
