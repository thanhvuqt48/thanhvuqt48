<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Product - page ${requestScope.page} </title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="" crossorigin="anonymous" /> 
        <style>
            /* Add your CSS styles here */
            /* Pagination styles */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f2f2f2;
            }

            .container {
                margin: auto;
                width: 80%;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #00a2fe  ;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th{
                background-color: #3ff92e;
            }

            th, td {
                padding: 10px;
                text-align: left;
                border: 1px solid #ddd;
            }

            /* Pagination styles */
            .pagination {
                padding-top: 20px;
                text-align: center;
            }

            /* Phần tử các nút phân trang */
            .pagination a {
                color: black;
                float: none;
                padding: 8px 16px;
                text-decoration: none;
                transition: background-color .3s;
                background-color: #00a2fe;
                border-radius: 5px
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
            }

            /* Phần tử nút phân trang được chọn */
            .pagination a.active {
                background-color: #4CAF50;
                color: white;
            }

            span{
                background-color: #00a2fe;
                padding: 8px;
                border-radius: 5px
            }
        </style>
    </head>
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
                            if (role == 3 ) {
                                response.sendRedirect("../productlist");
                            }
                        } catch (NumberFormatException e) {

                        }
                    }

                }
            }
        %>
        <h2>List of Staff - page ${requestScope.page} </h2>
        <a href="${pageContext.request.contextPath}/login">
            <i class="fas fa-home" style="color: black; width: 28px; font-size: 28px;; padding-bottom: 15px"></i>
        </a>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Phone number</th>
                <th>Address</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            <!-- Iterate over the list of books -->
            <c:forEach var="staff" items="${requestScope.data}">
                <tr>
                    <td>${staff.getUsername()}</td>
                    <td>${staff.getName()}</td>
                    <td>${staff.getPhoneNumber()}</td>
                    <td>${staff.getAddress()}</td>
                    <td>${staff.getPassword()}</td>
                    <td>
                        <a href="deletestaff?id=${staff.getUid()}" style="color: red; text-decoration: none">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="updatestaff?id=${staff.getUid()}" style="color: blue; text-decoration: none">Update</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <!--phân trang-->
        <c:set var="page" value="${requestScope.page}" />
        <c:set var="numberPage" value="${requestScope.numberPage}" />
        <div class="pagination">
            <a href="productlistmanager?page=${1}">&laquo;</a>&nbsp;
            <a href="productlistmanager?page=${page-1 == 0 ? 1 : page-1}">&lsaquo;</a>&nbsp;&nbsp;
            <span>${page}</span>&nbsp;&nbsp;
            <a href="productlistmanager?page=${page+1 > numberPage ? numberPage : page+1}">&rsaquo;</a>&nbsp;
            <a href="productlistmanager?page=${numberPage}">&raquo;</a>&nbsp;
        </div>
    </body>
</html>
