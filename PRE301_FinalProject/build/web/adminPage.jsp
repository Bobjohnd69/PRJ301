<%-- 
    Document   : adminPage
    Created on : 28-Feb-2024, 08:43:43
    Author     : minht
--%>

<%@page import="DTO.order"%>
<%@page import="java.util.List"%>
<%@page import="DTO.pizza"%>
<%@page import="DTO.pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-reboot.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css">
        <link rel="stylesheet" href="css/style_admin.css">
        <script src="https://code.jquery.com/jquery-2.1.3.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
        <div class="logo-container">
            <div class="logo left">
                <a href="landPage.jsp"> <img id="logo" src="images/logo.png"></a>
            </div>
            <div class="logo center">
                <h1 id="welcome">Welcome ${admin.getAdminFullName()}</h1>
            </div>
            <div class="logo right">
                <form action="logout" method="post">
                    <input class="btn btn-dark"  type="submit" value="Logout">
                </form>
            </div>
        </div>
        <%
            int roleID = (Integer) session.getAttribute("roleID");
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">
                    <%
                        if (roleID == 1) {

                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="admin?action=pizza">Pizza</a>
                    </li>
                    <%                         }
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="admin?action=currentOrder">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin?action=allOrder">Order History</a>
                    </li>
            </div>

        </nav>
        <%
            String list = (String) session.getAttribute("list");
            if (list.equalsIgnoreCase("pizza")) {


        %>
        <table class="table">
            <h2 style="text-align: center;">Pizza List</h2>
            <button class="btn btn-primary" id="addButton" onclick="window.location.href = 'Add.jsp'">Add Pizza</button>
            <thead>
                <tr class="table-head">
                    <th>Count</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <%                int count = 0;
                List<pizza> pizzaList = (List) session.getAttribute("pizzaList");
                if (list != null) {
                    for (pizza i : pizzaList) {
                        count++;

            %>
            <form action="admin/pizza" method="POST"> 
                <tr class="table-row" style="text-align: center">
                    <td>
                        <%= count%>
                    </td>
                    <td><%= i.getPizzaID()%></td>
                <input type="hidden" name="image" value="<%= i.getImage()%>"</td>
                <input type="hidden" name="id" value="<%= i.getPizzaID()%>">
                <td> <input type="text" name="pizzaName" value="<%= i.getPizzaName()%>"</td>
                <td> <input type="text" name="price" value="<%= i.getPrice()%>"</td>
                <td> <input type="text" name="description" style="width: 100%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" value="<%= i.getDescription()%>"</td>
                <td>
                    <input type="submit" class="btn btn-success" name="action" value="Update">
                </td>
                <td>
                    <input type="submit" class="btn btn-danger" name="action" value="Delete">
                </td>
                </tr>
            </form>

            <%
                    }
                }
            %>
        </table>
        <%
        } else if (list.equalsIgnoreCase("order")) {
            boolean orderAll = (boolean) session.getAttribute("orderAll");

        %>

        <table class="table">
            <h2 style="text-align: center;">Order List</h2>
            <thead>
                <tr class="table-head">
                    <th>Count</th>
                    <th>ID</th>
                    <th>Customer ID</th>
                    <th>Buy Date</th>
                    <th>Total</th>
                        <% if (!orderAll) {
                        %>
                    <th>Done</th>
                    <th>Cancel</th>
                        <%  }
                        %>
                </tr>
            </thead>

            <%
                int count = 0;
                List<order> orderList = (List) session.getAttribute("orderList");
                if (list != null) {
                    for (order i : orderList) {
                        count++;

            %>

            <tr class="table-row" style="text-align: center">

                <td>
                    <%= count%>
                </td>
                <td><%= i.getOrderID()%></td>
                <td><%= i.getCusID()%></td>
                <td><%= i.getBuyDate()%></td>
                <td><%= i.getTotal()%></td>
                <%
                    if (!orderAll) {
                %>

                <td>
                    <form action="admin/order" method="post">
                        <input type="hidden" name="orderID" value="<%= i.getOrderID()%>">
                        <input type="submit" class="btn btn-success" name="action" value="done">
                    </form>
                </td>
                <td>
                    <form action="admin/order" method="post">
                        <input type="hidden" value="<%= i.getOrderID()%>">
                        <input type="submit" class="btn btn-danger" name="action" value="cancel">
                    </form>
                </td>

            </tr>

            <%
                            }
                        }
                    }
                }
            %>
        </table>
    </body>
</html>

