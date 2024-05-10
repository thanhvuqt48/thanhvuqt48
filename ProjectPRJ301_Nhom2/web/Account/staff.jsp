<%-- 
    Document   : staff
    Created on : Mar 14, 2024, 5:54:06 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/staffCSS.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="" crossorigin="anonymous" />
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
                            if (role != 2) {
                                response.sendRedirect("../productlist");
                            }
                        } catch (NumberFormatException e) {

                        }
                    }

                }
            }
        %>
        <div class="login-container">
            <div class="background-image">
                <img src="${pageContext.request.contextPath}/images/backgroundmn.jpg" alt="Background Image">
            </div>
            <div class="header">
                <h1>STAFF</h1>
                <a href="${pageContext.request.contextPath}/productlist">
                    <i class="fas fa-home" style="color: white; width: 28px; font-size: 28px;"></i>
                </a>
            </div>

            <div class="role">
                <a href="${pageContext.request.contextPath}/productlistmanager"><button>List Product</button></a>
                <a href="${pageContext.request.contextPath}/addproduct"><button>New Product</button></a>
                <a href="${pageContext.request.contextPath}/stafforder"><button>Order Product</button></a>
                <a href="${pageContext.request.contextPath}/stafforderdone"><button>Order Product Done</button></a>
            </div>
        </div>

    </body>
</html>
