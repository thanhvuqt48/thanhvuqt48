<%-- 
    Document   : book
    Created on : Mar 3, 2024, 8:52:08 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Page</title>
    </head>
    <body>
        <h2>List of Books - Page ${requestScope.page}</h2>

        <table border="1px">
            <tr>
                <th>BookID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Description</th>
                <th>PublishYear</th>
                <th>Category</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="b">
                <tr>
                    <td>${b.bookId}</td>
                    <td>${b.title}</td>
                    <td>${b.author}</td>
                    <td>${b.description}</td>
                    <td>${b.publishYear}</td>
                    <td>${b.category}</td>
                </tr>
            </c:forEach>

        </table>
        <c:set var="page" value="${requestScope.page}" />
        <c:set var="numberPage" value="${requestScope.numberPage}" />
        <div class="pagination">
            <a href="book?page=${1}"> << </a>&nbsp;
            <a href="book?page=${page-1 == 0 ? 1 : page-1}"> < </a>&nbsp;
            ${page}&nbsp;
            <a href="book?page=${page+1 > numberPage ? numberPage : page+1}"> > </a>&nbsp;
            <a href="book?page=${numberPage}"> >> </a>&nbsp;
        </div>
    </body>
</html>
