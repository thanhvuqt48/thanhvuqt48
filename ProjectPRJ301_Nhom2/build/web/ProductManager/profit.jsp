<%-- 
    Document   : admin
    Created on : Mar 12, 2024, 3:24:22 PM
    Author     : ACER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profit.css"/>
        <style>
            .table-data {
                margin: 20px;
            }

            .table-data table {
                width: 100%;
                border-collapse: collapse;
            }

            .table-data th, .table-data td {
                padding: 10px;
                border: 1px solid #ddd;
                text-align: left;
            }

            .table-data th {
                background-color: #f2f2f2;
            }

            .table-data tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            .table-data tr:hover {
                background-color: #ddd;
            }

            .table-data a {
                text-decoration: none;
                color: #333;
            }

            .table-data a:hover {
                text-decoration: underline;
            }
            .table-data form {
                display: inline-block;
                margin-right: 5px; /* Adjust the margin between the buttons */
            }

            .table-data button {
                background-color: #f44336; /* Red color for delete button */
                color: white;
                border: none;
                padding: 8px 12px;
                cursor: pointer;
                border-radius: 4px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
            }

            .table-data button:hover {
                background-color: #d32f2f; /* Darker red color on hover */
            }

            .table-data button[type="submit"] {
                background-color: #4caf50; /* Green color for update button */
            }

            .table-data button[type="submit"]:hover {
                background-color: #388e3c; /* Darker green color on hover */
            }

            /* Thiết lập các thuộc tính cơ bản cho nút */
            .i {
                text-decoration: none; /* Remove underline */
                padding: 8px 16px; /* Add padding around the text */
                margin-right: 20px; /* Add space between the elements */
                border: 1px solid #4CAF50; /* Add border */
                border-radius: 5px; /* Add border radius for rounded corners */
                background-color: #4caf50; /* Add background color */
                color: white; /* Set text color to white */
                font-weight: bold; /* Make text bold */
                text-align: center; /* Center align text */
                display: inline-block; /* Make the anchor elements behave as blocks */
                transition: background-color 0.3s; /* Add smooth transition */
            }

            /* CSS for the hover effect */
            .Success {
                color: blue; /* Màu chữ là màu xanh */
                background-color: lightgreen; /* Màu nền là màu xanh lá cây nhạt */
                font-weight: bold; /* Chữ in đậm */
                font-style: italic; /* Chữ in nghiêng */
                border: 1px solid darkgreen; /* Viền là một đường viền đậm màu xanh lá cây */
                padding: 5px; /* Khoảng trắng giữa nội dung và biên */
            }

        </style>

        <title>AdminHub</title>
    </head>
    <body>


        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Profit</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="totalprofit">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Total Profit</span>
                    </a>
                </li>



                
            </ul>
            <ul class="side-menu">
                
                <li>
                    <a href="./Account/admin.jsp    " class="logout">
                        <i class='bx bxs-log-out-circle' ></i>
                        <span class="text">Back home</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- SIDEBAR -->



        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Total Profit</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Total Profit</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="./Account/admin.jsp">Home</a>
                            </li>
                        </ul>
                    </div>

                </div>

                <ul class="box-info">

                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="text">
                            <h3>${requestScope.total}</h3>
                            <p>Total Profit</p>
                        </span>
                    </li>
                </ul>


                <div class="table-data">
                    <table border="">
                        <tr>
                            <th>ProductID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Quantity</th>
                            <th>Profit</th>
                        </tr>

                        <c:forEach items="${requestScope.list}" var="b">
                            <tr>
                                <td>${b.product.productId}</td>
                                <td>${b.product.name}</td>
                                <td><img src="${b.product.image}" width="70px" height="70px"/> </td>
                                <td>${b.quantity}</td> 
                                <td>${b.profit}</td> 
                            </tr>
                        </c:forEach>
                    </table>


                </div>


            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->


        <script src="script.js"></script>
    </body>
</html>
