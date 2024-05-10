<%-- 
    Document   : check
    Created on : Apr 25, 2024, 3:46:08 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="tab">
            <c:set var="cat" value="${requestScope.cats}"/>
            <c:set var="ci" value="${requestScope.cid}"/>
            <form action="check">
                <c:forEach begin="0" end="${cat.size() - 1}" var="i">
                    <input type="checkbox" name="id" value="${cat.get(i).getId()}"
                           ${ci[i]?"checked":""} onclick="this.form.submit()" />
                    ${cat.get(i).getName()}
                    <br/>
                </c:forEach>

            </form>
        </div>
            <div class="content">
                <h1>List of Phones</h1>
                <table border="1px">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Release Date</th>
                        <th>Describe</th>
                        <th>Quantities</th>
                        <th>Price</th>
                        <th>Category</th>
                    </tr>
                    <c:forEach items="${requestScope.data}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td><img src="${p.image}" width="100px" height="100px"/></td>
                            <td>${p.releaseDate}</td>
                            <td>${p.describe}</td>
                            <td>${p.quantity}</td>
                            <td>${p.price}</td>
                            <td>${p.category.name}</td>
                        </tr>
                    </c:forEach>
                </table>
                
            </div>   

    </body>
</html>
