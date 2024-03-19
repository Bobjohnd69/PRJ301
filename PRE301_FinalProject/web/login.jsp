<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <style>
            body {
                background-image: url('images/pizza-image-1.jpeg');
                background-repeat: no-repeat;
                background-size: cover;
                background-position: center center;
                background-attachment: fixed;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            #login-container {
                position: absolute;
                display: flex;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
            }
            #login-container .input-group {
                margin-bottom: 15px;
            }
            #login-container .input-group input {
                width: calc(100% - 10px);
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-bottom: 5px;
            }
            #login-container .input-group a {
                font-size: 12px;
                color: #555;
                text-decoration: none;
            }
            #login-container .input-group a:hover {
                text-decoration: underline;
            }
            #login-container .input-group .btn-login {
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                border: none;
                color: white;
                border-radius: 5px;
                cursor: pointer;
            }
            #login-container .input-group .btn-login:hover {
                background-color: #45a049;
            }
            .pizza-image {
                float: center;
                width: 100%;
            }
            #login-container .pizza-image img {
                width: 100%;
            }

            .left, .right {
                flex: 1;
            }
        </style>
    </head>
    <body>

        <div id="login-container">
            <div class="left"> 
                <form method="post" action="login">
                    <div class="input-group">
                        <input type="text" placeholder="Username" name="userName">
                    </div>
                    <div class="input-group">
                        <input type="password" placeholder="Password" name="password">
                    </div>
                    <div class="input-group">
                        Forgot password?<a href="#"> Click here</a>
                    </div>
                    <div class="input-group">
                        Don't have an account?<a href="register.jsp"> Click here</a>
                    </div>
                    <div class="input-group">
                        <input type="submit" name="action" value="Login" class="btn-login">
                    </div>
                </form>
                <p style="color: red; display: inline-block; ">${notif}</p>
            </div>
            <div class="right">
                <img src="images/pizza-image-3.jpeg" alt="Pizza Image" class="pizza-image">
            </div>
        </div>

            
    </body>
</html>