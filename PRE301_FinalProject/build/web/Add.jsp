<%-- 
    Document   : Add
    Created on : 19-Jan-2024, 15:34:55
    Author     : minht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
        <style>
            body{
                background-color: beige;
            }
            .form {
                width: 50%;
                margin: 20px auto;
                padding: 20px;
                border: 1px solid black;
            }

            .label {
                display: block;
                margin: 10px 0;
                font-weight: bold;
            }

            .input {
                display: block;
                width: 80%;
                padding: 10px;
                border: 1px solid gray;
                border-radius: 5px;
            }

            .submit {
                display: block;
                width: 20%;
                margin: 10px auto;
                padding: 10px;
                border: none;
                border-radius: 5px;
                background-color: green;
                color: white;
                font-weight: bold;
            }
        </style>
    </head>

    <body>
        <form class="form" method="post" action="admin/pizza">
            <label class="label" for="pizzaName">Pizza Name</label>
            <input class="input" type="text" name="pizzaName" id="pizzaName" required>
            <label class="label" for="description">Description</label>
            <input class="input" type="text" name="description" id="description" required>
            <label class="label" for="price">Price</label>
            <input class="input" type="text" name="price" id="price" required pattern="^[0-9]+(\.[0-9]+)?$">
             <label class="label" for="image">Image URL</label>
            <input class="input" type="text" name="image" id="image" required>
            <input class="submit" type="submit" name="action" value="add">
        </form>
    </body>
</html>
