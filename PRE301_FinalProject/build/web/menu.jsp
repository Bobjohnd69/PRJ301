<%-- 
   Document   : menu
   Created on : 23-Feb-2024, 10:24:24
   Author     : minht
--%>

<%@page import="DTO.orderDetail"%>
<%@page import="DAO.DAO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Menu</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-reboot.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css">
        <link rel="stylesheet" href="css/style_menu.css">
        <script src="https://code.jquery.com/jquery-2.1.3.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
        <div class="logo-container">
            <div class="logo left">
                <a href="landPage.jsp"> <img id="logo" src="images/logo.png"></a>
            </div>
            <div class="logo center">
                <h1 class="logo-name">Bob's Pizzaria</h1>
            </div>
            <div class="logo right">
                <%
                    if (session == null || session.getAttribute("acc") == null) {
                        // User is not logged in
                %>
                <form action="mainController" method="post">
                    <input class="submit" type="button" value="Login" onclick="window.location.href = 'login.jsp'" />
                    <input class="submit"  type="button" value="Register" onclick="window.location.href = 'register.jsp'">
                </form>
                <%
                } else {
                %>
                <div class="dropdown">
                    <button onclick="showDropdown()" class="dropbtn">${acc.getCusUserName()}</button>
                    <form method="post" action="profile" id="profileDropdown" class="dropdown-content">
                        <a href="profile?action=profile">Profile</a>
                        <a href="profile?action=updateProfile">Update Profile</a>
                        <a href="profile?action=orderHistory">Order History</a>
                        <a href="<%= request.getContextPath()%>/logout">Logout</a>
                    </form>
                </div>


                <%
                    }
                %>
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="landPage.jsp#slideshow">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="menu.jsp">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="landPage.jsp#about-us">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="landPage.jsp#hours">Hours</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="landPage.jsp#contact">Contact</a>
                    </li>
            </div>
        </nav>
        <div class="menu-container">
            <div class="left-menu-container">
                <div class="container-fluid">
                    <div class="row">
                        <%
                            int count = 0;
                            DAO dao = new DAO();
                            List<pizza> list = dao.getPizzaOnLoad();
                            if (list != null) {
                                for (pizza i : list) {
                                    count++;

                        %>
                        <div class="col-lg-4 col-md-6 col-sm-12" >
                            <img src="<%=i.getImage()%>" alt="pizza-image" class="pizza">
                            <br>
                            <%=i.getPizzaName()%> <%=i.getPrice()%>$ 
                            <form action="order" method="post">
                                <input type="hidden" name="pizzaID" value="<%=i.getPizzaID()%>">
                                <input type="hidden" name="price" value="<%=i.getPrice()%>">
                                <input type="hidden" name="userID" value="${acc.getCusID()}">
                                <input type="number" class="quantityInput" name="quantity" value="0" min="0" required>
                                <input type="submit" name="action" class="quantityInput" value="buy">
                            </form>
                            <br>
                            <%=i.getDescription()%>
                        </div>
                        <%
                                }
                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="right-menu-container">
                <%
                    String orderID = (String) session.getAttribute("orderID");
                    if (orderID != null) {
                %>    
                <table>
                    <thead>
                        <tr>
                            <th>num</th>
                            <th>pizzaID</th>
                            <th>orderID</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>total</th>
                        </tr>
                    </thead>

                    <tbody>

                        <%
                            int countOrder = 0;
                            List<orderDetail> listDetail = dao.getOrdeDetailOnLoad(orderID);
                            if (list != null) {
                                for (orderDetail x : listDetail) {
                                    countOrder++;
                        %>
                        <tr>
                            <td><%= countOrder%></td>
                            <td><%= x.getPizzaID()%></td>
                            <td><%= x.getOrderID()%></td>
                            <td><%= x.getPrice()%></td>
                            <td><%= x.getQuantity()%></td>
                            <td><%= x.getTotal()%></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                        Total: ${total}
                    </tbody>

                </table>
                <form action="order" method="post">
                    <input class="submit" type="submit" name="action" value="Cancel">
                    <input class="submit" type="submit" name="action" value="Confirm">
                </form>
                <%
                    }
                %>
            </div>
        </div>
            
              <script>
        function showDropdown() {
            document.getElementById("profileDropdown").classList.toggle("show");
            ;
        }

        window.onclick = function (event) {
            if (!event.target.matches('.dropbtn')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }
    </script>
    </body>
</html>
