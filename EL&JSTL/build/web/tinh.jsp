<%-- 
    Document   : tinh
    Created on : Jan 28, 2024, 10:49:51 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function choice(change){
                document.getElementById("d").value = change;
                document.getElementById("f1").submit();
            }
        </script>
    </head>
    <body>
        <h1>Exchange money</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <form id="f1" action="" method="post">
            Nhập tiền Việt: <input type="text" name="money"/></br>
            </br>
            <input type="hidden" id="d" name="change" value=""/>
            <input type="button" onclick="choice('0')" value="DOI sang USD"/>
            <input type="button" onclick="choice('1')" value="DOI sang YEN"/>
        </form>
        <h2 style="color: blue">Tien doi: ${requestScope.kqua}</h2> 
    </body>
</html>
