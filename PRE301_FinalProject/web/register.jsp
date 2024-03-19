<%-- 
    Document   : register
    Created on : 26-Feb-2024, 16:15:44
    Author     : minht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-image: url('images/pizza-image-2.jpeg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .form-container {
                width: 30%;
                background-color: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
            }
            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 5px;
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <div class="left">
                <h2>Register</h2>
                <form id="registerForm" action="register" method="post" onsubmit="return validateForm()">
                    <label for="username">Username:</label><br>
                    <input type="text" id="username" name="userName"><br>

                    <label for="fullname">Full Name:</label><br>
                    <input type="text" id="fullname" name="fullName"><br>

                    <label for="phone">Phone Number:</label><br>
                    <input type="text" id="phone" name="phone"><br>

                    <label for="address">Address:</label><br>
                    <input type="text" id="address" name="address"><br>

                    <label for="password">Password:</label><br>
                    <input type="password" id="password" name="password"><br>

                    <label for="confirmPassword">Confirm Password:</label><br>
                    <input type="password" id="confirmPassword" name="confirmPassword"><br>

                    <input type="submit" name="action" value="Register">
                </form>
            </div>
        </div>>

        <script>
            function validateForm() {
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirmPassword").value;

                if (password !== confirmPassword) {
                    alert("Passwords do not match!");
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>
