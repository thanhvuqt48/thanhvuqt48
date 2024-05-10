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
                            if (role != 2 && role !=1) {
                                response.sendRedirect("../productlist");
                            }
                        } catch (NumberFormatException e) {

                        }
                    }

                }
            }
        %>
        <div class="container">
            <h1 style="text-align: center;
                color: #00a2fe  ;
                ">Update a product</h1>
            <form action="updateproduct" method="post">
                <label for="productid">Product ID:</label><br>
                <input type="text" id="productid" name="productid" value="${requestScope.product.getProductId() == null ? param.productid : requestScope.product.getProductId()} " readonly><br>
                <label for="productname">Product Name</label><br>
                <input type="text" id="productname" name="productname" value="${requestScope.product.getName()  == null ? param.productname : requestScope.product.getName()}" readonly><br>
                <label for="price">Price</label><br>
                <input id="price" type="text" name="price" value="${requestScope.product.getPrice() == null ? param.price : requestScope.product.getPrice()}" required></input><br>
                <label for="description">Description</label><br>
                <c:set var="description" value="${fn:trim(requestScope.product.getDescribe() == null ? param.describe : requestScope.product.getDescribe())}" />
                <textarea rows="5" cols="20" id="describe" name="describe" required>${description}</textarea><br>
                <label for="image">Image</label><br>
                <image style="width: 200px" name="image" src="${requestScope.product.getImage()}"><br>
                <label for="description">Category</label><br>
                <input id="category" type="text" name="category" value="${requestScope.product.getCategory().getName() == null ? param.category : requestScope.product.getCategory().getName()}" readonly></input>
                <h2 style="color: red">${requestScope.error}</h2>

                <input type="submit" value="Update" style="font-weight: 700; font-size: 20px">
            </form>
        </div>
    </body>
</html>
