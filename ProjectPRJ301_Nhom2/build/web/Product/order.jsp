<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>title</title>
    </head>
    <link rel="stylesheet" href="css/detail.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        table{
            border-collapse: collapse;
        }
    </style>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!--Main layout-->
            <main>
                <div class="container">

                    <section>
                        <table border="2px" width="40%">
                            <tr>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Size</th>
                                <th>Price</th>
                            </tr>
                        <c:forEach items="${requestScope.carts}" var="c">
                            <tr>
                                <td>${c.product.name}</td>
                                <td>${c.quantity}</td>
                                <td>${c.size}</td>
                                <td>Price: ${c.quantity*c.product.price}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <c:set var="a" value="${requestScope.account}"/>
                    <form action="addorder" method="post">
                        Name:
                        <input type="text" value="${a.name}" readonly/><br/>
                        Phone number:
                        <input type="text" value="${fn:escapeXml(a.phoneNumber)}" name="phone" required/><br/>
                        Address:
                        <input type="text" value="${a.address}" name="address" required/><br/>

                        <button type="submit">Pay</button><br/>
                    </form>
                    <h3>Total money: ${requestScope.totalMoney}</h3>

                </section>


                <!-- Pagination -->  
            </div>
        </main>
        <!--Main layout-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
