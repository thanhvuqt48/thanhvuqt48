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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detailproductCSS.css">
    <script type="text/javascript">
        function choice(change) {
            if (change === 'cart') {
                document.getElementById("f1").action = change;
                document.getElementById("f1").submit();
            } else {
                document.getElementById('type').value = 1;
                document.getElementById("f1").action = change;
                document.getElementById("f1").submit();
            }

        }
        function disableOthers(clickedInput) {
            const inputs = document.querySelectorAll('input[name="size"]');
            inputs.forEach(input => {
                if (input !== clickedInput) {
                    input.checked = false;
                }
            });
        }
        function validateForm() {
            var quantity = document.getElementsByName("quantity")[0].value;
            var size = document.querySelector('input[name="size"]:checked');

            if (quantity === "" || size === null) {
                alert("Please fill out both quantity and size fields.");
                return false;
            }

            // Kiểm tra quantity có lớn hơn 0 không
            if (parseInt(quantity) <= 0) {
                alert("Please enter a quantity greater than 0.");
                return false;
            }

            return true;
        }

    </script>
    <style>
        /* CSS cho các nút chọn size */
      

        .size-button {
            display: inline-block;
            margin: 0 5px; /* Khoảng cách giữa các nút */
            padding: 5px 10px;
            border: 1px solid #ccc;
            cursor: pointer;
        }

        .size-button:hover {
            background-color: #f0f0f0; /* Màu nền khi di chuột qua */
        }

    </style>
    <body>
        <%
            Cookie[] cookieses = request.getCookies();
            String username = "";
            String password = "";
            String uid = "";
            if (cookieses != null) {
                for (int i = 0; i < cookieses.length; i++) {
                    Cookie cookie = cookieses[i];
                    if (cookie.getName().equals("uid-cookie")) {
                        uid = cookie.getValue();
                    }
                }
            }
        %>

    </div>

    <!--Main layout-->
    <main style="background-color: #e0e0e0">
        <jsp:include page="header.jsp"></jsp:include>
        <section>
            <div>
                <div class="row">
                    <c:set var="p" value="${requestScope.product}"/>    
                    <div class="col-lg-6 text-center" >
                        <div class="card" style="margin-left: 30px; margin-bottom: 25px;">
                            <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                 data-mdb-ripple-color="light">
                                <img src="${p.image}"
                                     class="w-50" />
                            </div>
                            <div class="card-body">

                                <h5 class="card-title mb-2">${p.name}</h5>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="product-card" style="margin-bottom: 25px;">
                            <div class="product-header">
                                <h5 class="product-title">${p.name}</h5>
                                <a href="order.jsp"></a>
                            </div>
                            <h5>Description</h5>
                            <div class="product-description">
                                <p>${p.describe}</p>
                            </div>
                            <h5>Price: ${p.price}$</h5>


                            <form id="f1" action="" method="post" class="buy-now-form">
                                <h5>Quantity:</h5>
                                <input type="number" name="quantity" required/><br/><br/>
                                <h5>Size:</h5>
                                <input type="hidden" name="uid" value="${1}"/>
                                <input id="type" type="hidden" name="type" value=""/>

                                <div id="sizeButtons">
                                    <c:forEach begin="36" end="42" varStatus="loop">
                                        <input type="radio" id="size${loop.index}" name="size" value="${loop.index}" required />
                                        <label class="size-button" for="size${loop.index}">${loop.index}</label>
                                    </c:forEach>
                                </div>



                                <input type="hidden" name="pid" value="${p.productId}"/>

                                <c:if test="${requestScope.role != '2' && requestScope.role != '1' }">
                                    <div style="display: flex">
                                        <input type="button" onclick="if (validateForm()) {
                                                    choice('orderproduct');
                                                }" value="Buy now" class="buy-now-btn"/><br/>
                                        <input type="button" onclick="if (validateForm()) {
                                                    choice('cart');
                                                }" value="Add to cart" class="add-to-cart-btn"/>

                                    </div>
                                </c:if>
                            </form>

                        </div>
                    </div>

                </div>
            </div>
        </section>
    </main>
    <!--Main layout-->

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
