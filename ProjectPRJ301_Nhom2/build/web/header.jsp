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
    <style>
        table{
            border-collapse: collapse;
        }
    </style>

    <script type="text/javascript">
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


    </div>

    <!--Main layout-->
    <main style="background-color: #e0e0e0">
        <nav class="navbar navbar-expand-lg navbar-dark pb-3 pt-3 shadow p-2" style="background-color: #e0e0e0">
            <!-- Container wrapper -->
            <div class="container-fluid">

                <!-- Navbar brand -->
                <a class="navbar-brand" href="#"><img src="./images/logonike1.png" alt="alt" style="width: 120px;"/></a>

                <!-- Toggle button -->
                <button 
                    class="navbar-toggler" 
                    type="button" 
                    data-mdb-toggle="collapse" 
                    data-mdb-target="#navbarSupportedContent2" 
                    aria-controls="navbarSupportedContent2" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"  style="font-size: 18px;">

                        <!-- Link -->
                        <li class="nav-item acitve">
                            <a class="nav-link text-black" href="productlist?cid=${0}"> &nbsp;&nbsp;&nbsp; All &nbsp;&nbsp;&nbsp;</a>
                        </li>
                        <c:set value="${requestScope.categories}" var="c"/>
                        <c:forEach items="${c}" var="c">
                            <li class="nav-item acitve">
                                <a class="nav-link text-black" href="productlist?cid=${c.id}">   ${c.name} &nbsp;&nbsp;&nbsp; </a>
                            </li>
                        </c:forEach>

                    </ul>

                    <!-- Search -->
                    <form action="searchproduct" class="search-form">

                        <div class="search-container">
                            <input oninput="searchByName(this)" value="${txtS}" name="txt"  type="text" placeholder="Search..." class="search-input" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
                            <button type="submit" class="search-button">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>

                    </form>
                    <c:if test="${not empty cookie['uid-cookie']}">
                        <form action="logout" method="post">
                            <button type="submit" class="button logout-button">Logout</button>
                        </form> 

                        <button style="padding:0 15px" class="account-button" onclick="toggleDropdown()">
                            <i class="fas fa-user" ></i>
                        </button>
                        <div id="dropdown" class="dropdown-content">
                            <a href="updateinformation">Edit information</a>
                            <a href="./Account/updatepass.jsp">Change password</a>
                        </div>
                    </c:if>


                    <c:if test="${empty cookie['uid-cookie']}">
                        <button class="account-button">
                            <a href="${pageContext.request.contextPath}/login"><i class="fas fa-user"></i></a>
                        </button>
                    </c:if>

                    <form action="cart">
                        <button class="cart-button">
                            <i class="fas fa-shopping-cart"></i>
                        </button>
                    </form>

                </div>
            </div>
            <!-- Container wrapper -->
        </nav>
        <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-mdb-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./images/bghome.png" style="    width: 100%;
                         height: 100%;
                         object-fit: cover; " alt="Wild Landscape"/>
                </div>

            </div>
        </div>
</body>
</html>