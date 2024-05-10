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
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
            }

            .container {
                margin: auto;
                width: 500px;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                color: #343a40;
                text-align: center;
                margin-bottom: 20px;
            }

            form {
                margin-top: 20px;
            }

            table {
                width: 100%;
            }

            td {
                padding: 10px;
            }

            input[type="text"],
            input[type="password"] {
                width: calc(100% - 20px);
                padding: 8px;
                border: 1px solid #ced4da;
                border-radius: 3px;
                background-color: #f8f9fa;
            }

            input[type="text"]:focus,
            input[type="password"]:focus {
                outline: none;
                border-color: #007bff;
            }

            input[type="submit"] {
                width: calc(100% - 20px);
                padding: 10px;
                background-color: #007bff;
                color: #ffffff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            .language-selector {
                text-align: center;
                margin-top: 20px;
            }

            .language-selector a {
                margin: 0 5px;
                text-decoration: none;
                color: #007bff;
            }

            .language-selector a:hover {
                text-decoration: underline;
            }

        </style>
    </head>
    <body style="padding-top: 160px">
        <div class="container">
            <h1 style="text-align: center"><f:message bundle="${bundle}" key="register" /></h1>
            <form >
                <table>
                    <tr>
                        <td><f:message key="username" bundle="${bundle}" /></td>
                        <td><input type="text" name="usernam" /></td>
                    </tr>
                    <tr>
                        <td><f:message key="email" bundle="${bundle}" /></td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td><f:message key="password" bundle="${bundle}" /></td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Submit" /></td>
                    </tr>
                </table>
            </form>
            <div class="language-selector">
                <a href="?lang=vi_VN"><f:message bundle="${bundle}" key="vi" /></a>
                | <a href="?lang=en_US"><f:message bundle="${bundle}" key="en" /></a>
            </div>
        </div>
    </body>
</html>
