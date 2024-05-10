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

        input[type="text"], input[type="number"], select
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
        <a href="${pageContext.request.contextPath}/login">
            <i class="fas fa-home" style="color: black; width: 28px; font-size: 28px;; padding-bottom: 15px"></i>
        </a>
        <div class="container">
            <h1 style="text-align: center;
                color: #00a2fe  ;
                ">Add new product</h1>
            <form action="addproduct" method="post">
                <label for="productid">Product ID:</label><br>
                <input type="text" id="productid" name="productid" value="${param.productid}" ><br>
                <label for="productname">Product Name</label><br>
                <input type="text" id="productname" name="productname" value="${param.productname}" ><br>
                <label for="price">Price</label><br>
                <input id="price" type="text" name="price" value="${param.price}" required></input><br>
                <label for="description">Describe</label><br>
                <c:set var="description" value="${fn:trim(param.describe)}" />
                <textarea rows="5" cols="20" id="describe" name="describe" required>${description}</textarea><br>
                <label for="image">Image</label><br>
                <input id="image" type="file" name="image" value="${param.image}" accept="image/png, image/jpeg" required></input><br>
                <label for="description">Category</label><br>
                <select name="category">
                    <option value="1">Nike Air Force 1</option>
                    <option value="2">Nike Air Jordan 1</option>
                    <option value="3">Nike Air Max</option>
                    <option value="4">Nike Pegasus</option>
                </select>

                <h2 style="color: red">${requestScope.error}</h2>

                <input type="submit" value="Add Product" style="font-weight: 700; font-size: 20px">
            </form>
        </div>
    </body>
</html>
