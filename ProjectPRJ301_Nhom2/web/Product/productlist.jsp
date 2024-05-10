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
    <script>
        var isDropdownVisible = false; // Biến trạng thái của dropdown

        function toggleDropdown() {
            var dropdown = document.getElementById("dropdown");
            if (!isDropdownVisible) {
                dropdown.classList.add("show"); // Hiển thị dropdown
            } else {
                dropdown.classList.remove("show"); // Ẩn dropdown
            }
            isDropdownVisible = !isDropdownVisible; // Đảo ngược trạng thái
        }

// Đóng dropdown nếu người dùng nhấn ra ngoài dropdown
        window.onclick = function (event) {
            if (!event.target.matches('.account-button')) {
                var dropdown = document.getElementById("dropdown");
                if (isDropdownVisible) {
                    dropdown.classList.remove("show"); // Ẩn dropdown
                    isDropdownVisible = false; // Cập nhật trạng thái
                }
            }
        }

    </script>
    <body>

        <!--Main layout-->
        <jsp:include page="header.jsp"></jsp:include>
            
            <div class="container" style="padding-top: 50px; ">
                <!-- Navbar -->
                <!-- Navbar -->

                <!-- Products -->
                <section>
                    <div class="text-center">
                        <div class="row">

                        <c:forEach items="${requestScope.list}" var="p">
                            <div class="col-lg-3 col-md-6 mb-4">
                                <div class="card" style="height: 509px">
                                    <a href="detailproduct?pid=${p.productId}" style="text-decoration: none; color: black" >
                                        <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                             data-mdb-ripple-color="light">
                                            <img src="${p.image}"
                                                 class="w-100" style="height: 300px; border-radius: 8px" />

                                            <div class="mask">
                                                <div class="d-flex justify-content-start align-items-end h-100">
                                                    <h5><span class="badge bg-dark ms-2">NEW</span></h5>
                                                </div>
                                            </div>
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <h5 class="card-title mb-2" style="font-size: 20px;">${p.name}</h5>
                                            <p>Shoes</p>
                                            <h6 class="mb-3 price">${p.price}$</h6>
                                        </div>
                                    </a>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>

            <!-- Pagination -->
            <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">
                <c:set var="page" value="${requestScope.page}" />

                <c:set var="numberPage" value="${requestScope.numberPage}" />
                <div class="pagination">
                    <a href="productlist?page=${1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&laquo;</a>&nbsp;
                    <a href="productlist?page=${page-1 == 0 ? 1 : page-1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&lsaquo;</a>&nbsp;&nbsp;
                    <span style="float: left; padding: 8px 16px; background-color: #ddd; color: black;">${page}</span>&nbsp;&nbsp;
                    <a href="productlist?page=${page+1 > numberPage ? numberPage : page+1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&rsaquo;</a>&nbsp;
                    <a href="productlist?page=${numberPage}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&raquo;</a>&nbsp;
                </div>
            </nav>

            <!-- Pagination -->  
        </div>
    </main>
    <!--Main layout-->

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
