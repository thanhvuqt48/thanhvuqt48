<%-- 
    Document   : list
    Created on : Feb 29, 2024, 11:02:38 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border-collapse: collapse;
            }
            .content{
                margin: auto;
                width: 80%;
                float: left;
                height: auto;
                margin-left: 50px;
            }
            .pagination{
                display: inline-block;
            }
            .pagination a{
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active{
                background-color: #4CAF50;
                color: white;
            }
            .pagination a:hover:not(.active){
                background-color: chocolate;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <h1>List of Products</h1>
            <c:set var="page" value="${requestScope.page}" />
            <div class="pagination">
                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                    <a class="${i==page?'active':''}" href="list?page=${i}">${i}</a>
                </c:forEach>
            </div>
            <table border="1px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Release Date</th>
                    <th>Describe</th>
                    <th>Image</th>
                    <th>Category name</th>
                </tr>
                <c:forEach items="${requestScope.data}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.quantity}</td>
                        <td>${p.price}</td>
                        <td>${p.releaseDate}</td>
                        <td>${p.describe}</td>
                        <td><img src="${p.image}" width="80px" height="80px"/></td>
                        <td>${p.category.name}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
