<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>title</title>
    </head>
    <link rel="stylesheet" href="css/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="" crossorigin="anonymous" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productlistCSS.css">
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <!--Main layout-->
            <main>
                <div class="container">

                    <section>
                        <table border="2px" width="100%">
                            <tr>
                                <th>Product Name</th>
                                <th>Image</th>
                                <th>Quantity</th>
                                <th>Size</th>
                                <th>Price</th>
                                <th>Action</th>
                            </tr>
                        <c:forEach items="${requestScope.carts}" var="c">
                            <tr>
                                <td>${c.product.name}</td>
                                <td><img src="${c.product.image}" width="80px" height="80px"/></td>
                                <td>
                                    <form action="process">
                                        <input type="hidden" name="pid" value="${c.product.productId}"/>
                                        <input type="hidden" name="quantity" value="${c.quantity}"/>
                                        <input type="hidden" name="size" value="${c.size}"/>
                                        <button tpye="sumbit" name="op" value="-">-</button>
                                        ${c.quantity}
                                        <button tpye="sumbit" name="op" value="+">+</button>
                                    </form>
                                </td>
                                <td>${c.size}</td>
                                <td>Price: ${c.quantity*c.product.price}$</td>
                                <td><a href="remove?pid=${c.product.productId}&uid=${c.account.uid}&size=${c.size}">Remove</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <h3>Total money: ${requestScope.totalMoney}</h3>
                    <form action="productlist">
                        <button type="submit">Back to home</button>
                    </form>
                    <form action="orderproduct" method="post">
                        <button type="submit">Buy now</button>
                    </form>
                </section>


                <!-- Pagination -->  
            </div>
        </main>
        <!--Main layout-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
