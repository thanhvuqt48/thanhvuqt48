<%-- 
    Document   : addMagazine
    Created on : Mar 21, 2024, 7:49:47 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new magazine</h1>
        <form action="add" method="post">
            Enter Magazine ID: <input type="text" name="id"/><br/>
            Enter Magazine Name: <input type="text" name="name"/><br/>
            Enter Issue Number: <input type="text" name="number"/><br/>
            Enter Publisher: <input type="text" name="publisher"/><br/>
             <input type="submit" value="Submit"/><br/>
        </form>
    </body>
</html>
