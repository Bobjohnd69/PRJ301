<%-- 
    Document   : order
    Created on : 12-Mar-2024, 09:32:51
    Author     : minht
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-reboot.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css">
        <style>
            body{
                background-color: #ff9999;
            }
            .profile {
                width: 500px;
                padding: 20px;
                margin: 0 auto;
                background-color: #f8d7da;
                border: 4px solid #330033;
                border-radius: 20px;
            }
            .profile h2 {
                margin-bottom: 20px;
            }
            .profile p {
                margin-bottom: 10px;
            }

            .profile label {
                display: block;
                margin-bottom: 5px;
            }
            .profile input {
                width: 100%;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
       <a href="landPage.jsp" class="btn btn-primary">Go back</a>
        <%
            String active = (String) request.getAttribute("active");
            if (active.equalsIgnoreCase("profile")) {
        %>
        <div class="profile">
            <h2>Customer Profile</h2>
            <p><strong>Customer Name:</strong> ${acc.getCusUserName()}</p>
            <p><strong>Full Name:</strong> ${acc.getCusName()}</p>
            <p><strong>Address:</strong> ${acc.getAddress()}</p>
            <p><strong>Phone Number:</strong> ${acc.getPhoneNum()}</p>
        </div>
        <%          } else if (active.equalsIgnoreCase("updateProfile")) {

        %>
        <div class="profile">
            <h2>Customer Profile</h2>
            <form method="post" action="profile">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="userName" value="${acc.getCusUserName()}">

                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" value="${acc.getCusName()}"> 

                <label for="password">Password:</label>
                <input type="text" id="password" name="password" value="${acc.getPassword()}">
                
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${acc.getAddress()}">

                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value="${acc.getPhoneNum()}">
                <input type="hidden" name="cusID" value="${acc.getCusID()}">
                <input type="submit" class="btn btn-primary" name="action" value="Update">
            </form>
        </div>
        <%          } else if (active.equals("orderHistory")) {
            List<order> orderList = (List) session.getAttribute("orderList");
            if (orderList != null) {
                for (order i : orderList) {
                    String status = "Canceled";
                    if (i.getStatus() == 1) {
                        status = "Making";
                    } else if (i.getStatus() == 2) {
                        status = "done";
                    }
        %>
        <div class="profile">
            <h2>Order <%= i.getOrderID()%></h2>
            <p><strong>Buy Date:</strong> <%= i.getBuyDate()%></p>
            <p><strong>Total:</strong><%= i.getTotal()%></p>
            <p><strong>Status:</strong><%= status%></p>
        </div>
        <%          }
                }
            }
        %>
        
    </body>
</html>