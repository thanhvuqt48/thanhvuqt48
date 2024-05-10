<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>title</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>

            tbody, td, tfoot, th, thead, tr {
                border-color: inherit;
                border-style: solid;
                border-width: 1px;
            }
        </style>
    </head>
    <body>
        <!-- Navbar -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--Main layout-->
            <main>
                <div class="container">

                    <section>
                        <table border="2px" width="100%">
                            <tr>
                                <th>Date</th>
                                <th>Product Name</th>
                                <th>Image</th>
                                <th>Quantity</th>
                                <th>Size</th>
                                <th >Price</th>
                                <td>Name</td>
                                <td>Address</td>
                                <th>Status</th>
                            </tr>
                        <c:forEach items="${requestScope.orders}" var="o">
                            <tr>
                                <td>${o.orderTime}</td>
                                <td>${o.product.name}</td>
                                <td><img src="${o.product.image}" width="60px" height="60px"/></td>
                                <td>${o.quantity}</td>
                                <td>${o.size}</td>
                                <td>Price: ${o.quantity*o.product.price}$</td>
                                <td>${o.account.name}</td>
                                <td>${o.address}</td>
                                <td>
                                    <c:if test="${o.orderStatus == 0}">
                                        Wait for accept
                                    </c:if>
                                    <c:if test="${o.orderStatus == 1}">
                                        Shipping
                                    </c:if>
                                    <c:if test="${o.orderStatus == 2}">
                                        Received
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </section>


                <!-- Pagination -->  
            </div>
        </main>
        <!--Main layout-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
