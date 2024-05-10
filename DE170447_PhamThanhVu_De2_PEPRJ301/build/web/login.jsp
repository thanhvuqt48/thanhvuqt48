<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            form {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
            }
            h1 {
                color: #333;
                text-align: center;
            }
            input[type=text], input[type=password] {
                width: calc(100% - 22px);
                padding: 10px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            input[type=submit]:hover {
                background-color: #45a049;
            }
            .remember-me {
                margin: 10px 0;
            }
        </style>
    </head>
    <body>
       
        <h1>Login Form</h1>
        <form action="login" method="post">
            <div>
                Enter username: <input type="text" name="user"/><br/>
            </div>
            <div>
                Enter password: <input type="password" name="pass"/><br/>
            </div>
            <div class="remember-me">
                <input type="checkbox" name="rem"/> Remember me<br/>
            </div>
            <div>
                <input type="submit" value="LOGIN"/>
            </div>
        </form>
    </body>
</html>
