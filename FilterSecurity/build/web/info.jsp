<%-- 
    Document   : info
    Created on : Mar 20, 2024, 11:19:38 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Profile page</h1>
        <h3>
            Username:${sessionScope.account.username}<br/>
            <c:if test="${sessionScope.account.role==1}">
                CHÀO MỪNG BẠN ĐẾN VỚI KÊNH BÁN HÀNG!
            </c:if>
            <c:if test="${sessionScope.account.role==2}">
                CHÀO MỪNG BẠN KHÁCH HÀNG!
            </c:if>
        </h3>
    </body>
</html>
