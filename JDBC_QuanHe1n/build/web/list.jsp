<%-- 
    Document   : list
    Created on : Jan 31, 2024, 10:18:34 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

        </style>
    </head>
    <body>
        <div id="wrapper">
            <div id="menu_tab">
                <ul>
                    <li><a href="products?cid=${0}">All</a></li>
                        <c:forEach items="${requestScope.data}" var="c">
                        <li><a href="products?cid=${c.id}">${c.name}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <div class="clr"></div>
            <div id="content">
                <c:set var="list" value="${requestScope.products}"/>
                <c:if test="${((list==null) || (list.size()==0))}">
                    <h3>No product</h3>
                </c:if>
                <c:if test="${((list!=null) && (list.size()>0))}">
                    <table border="1px">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Category name</th>
                                <c:forEach items="${list}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.price}</td>
                                <td><img src="${p.image}" width="80px" height="80px"/></td>
                                <td>${p.category.name}</td>
                            </tr>
                        </c:forEach>
                        </tr>
                    </table>
                </c:if>
            </div>
        </div>
    </body>
</html>
