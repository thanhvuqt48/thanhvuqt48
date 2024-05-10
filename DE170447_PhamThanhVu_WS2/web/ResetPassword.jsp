<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:choose>
    <c:when test="${empty param.lang}">
        <f:setLocale value="en_US" scope="session" />
    </c:when>
    <c:otherwise>
        <f:setLocale value="${param.lang}" scope="session" />
        <c:set var="lang" value="${param.lang}" scope="session" />
    </c:otherwise>
</c:choose>
<f:setBundle basename="lang.Language" var="bundle" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><f:message bundle="${bundle}" key="title" /></title>
         <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            h1 {
                color: #333;
            }
            form {
                margin-top: 20px;
            }
            input[type="text"] {
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ddd;
                border-radius: 4px;
                width: calc(100% - 22px); /* Adjust width to account for padding and border */
            }
            input[type="submit"] {
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                background-color: #5cb85c;
                color: white;
                cursor: pointer;
            }
            .language-selector {
                margin-top: 10px;
            }
            .language-selector a {
                text-decoration: none;
                color: #337ab7;
                padding: 5px;
            }
            .language-selector a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body style="padding-top: 160px">
        <div class="container">
            <h1 style="text-align: center"><f:message bundle="${bundle}" key="reset" /></h1>
            <form >
                <f:message key="header" bundle="${bundle}" /><br/>
                <input type="text" placeholder="<f:message key="enter" bundle="${bundle}" />" /><br/>
                <f:message key="message" bundle="${bundle}" /><br/>
                <input type="submit" value="<f:message key="submit" bundle="${bundle}" />"/>

            </form>
            <div class="language-selector">
                <a href="?lang=vi_VN"><f:message bundle="${bundle}" key="vi" /></a>
                | <a href="?lang=en_US"><f:message bundle="${bundle}" key="en" /></a>
            </div>
        </div>
    </body>
</html>
