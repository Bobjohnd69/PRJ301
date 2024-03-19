/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.customer;
import DTO.admin;
import DTO.order;
import DTO.orderDetail;
import DTO.pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DbLib.DBLib;
import java.sql.Date;

/**
 *
 * @author Tony
 */
public class DAO {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;

    public boolean addCustomer(String cusUserName, String cusName, String password, String address, String phoneNum) {
        String sql = "INSERT INTO Customer (cusUserName, cusFullName, password, address, phoneNum) VALUES (?, ?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusUserName);
            ps.setString(2, cusName);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phoneNum);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean deleteCustomer(String cusID) {
        String sql = "DELETE FROM Customer WHERE cusID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean updateCustomer(String cusID, String cusUserName, String cusName, String password, String address, String phoneNum) {
        String sql = "UPDATE Customer SET cusUserName = ?, cusFullName = ?, password = ?, address = ?, phoneNum = ? WHERE cusID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusUserName);
            ps.setString(2, cusName);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phoneNum);
            ps.setString(6, cusID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public customer getCustomer(String userName, String password) {
        customer cus = null;
        String sql = "SELECT * FROM Customer WHERE cusUserName = ? AND password = ?";
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                cus = new customer(rs.getString("cusID"), rs.getString("cusUserName"), rs.getString("cusFullName"), rs.getString("password"), rs.getString("address"), rs.getString("phoneNum"));
                return cus;
            }
        } catch (Exception ex) {
        }

        return cus;
    }

    public boolean addAdmin( int roleID, String adminName, String password, String address, String phoneNum, String userName) {
        String sql = "INSERT INTO Admin (adminUserName, adminFullName, roleID, password, address, phoneNum) VALUES (?, ?, ?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, adminName);
            ps.setInt(3, roleID);
            ps.setString(4, password);
            ps.setString(5, address);
            ps.setString(6, phoneNum);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean deleteAdmin(String adminID) {
        String sql = "DELETE FROM Admin WHERE adminID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, adminID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean updateAdmin(String adminID, int roleID, String adminName, String password, String address, String phoneNum) {
        String sql = "UPDATE Admin roleID = ?, SET password = ?, adminName = ?, address = ?, phoneNum = ? WHERE adminID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roleID);
            ps.setString(2, password);
            ps.setString(3, adminName);
            ps.setString(4, address);
            ps.setString(5, phoneNum);
            ps.setString(6, adminID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public admin getAdmin(String adminUserName, String password) {
        admin admin = null;
        String sql = "SELECT * FROM Admin WHERE adminUserName = ? AND password = ?";
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, adminUserName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                admin = new admin(rs.getString("adminID"),rs.getString("adminUserName"), rs.getString("adminFullName"), rs.getInt("roleID"), rs.getString("password"), rs.getString("address"), rs.getString("phoneNum"));
                return admin;
            }
        } catch (Exception ex) {
        }

        return admin;
    }

     public boolean addPizza(String pizzaName, String description, double price, String image) {
        String sql = "INSERT INTO Pizza (pizzaName, description, price, image) VALUES (?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, pizzaName);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setString(4, image);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }
    
    public List<pizza> getPizzaSearch(String search) {
        List<pizza> pizzaList = new ArrayList<>();
        pizza Piz;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            if (search == null || search.isEmpty()) {
                sql = "SELECT * FROM Pizza";
                ps = connection.prepareStatement(sql);
            } else {
                sql = "SELECT * FROM Pizza WHERE pizzaName LIKE ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, search);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Piz = new pizza(
                        rs.getString("pizzaID"),
                        rs.getString("pizzaName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                );
                pizzaList.add(Piz);
            }
        } catch (Exception ex) {
        }

        return pizzaList;
    }

    public List<pizza> getPizzaOnLoad() {
        List<pizza> pizzaList = new ArrayList<>();
        pizza Piz;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT * FROM Pizza";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Piz = new pizza(
                        rs.getString("pizzaID"),
                        rs.getString("pizzaName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                );
                pizzaList.add(Piz);
            }
        } catch (Exception ex) {
        }

        return pizzaList;
    }

    public boolean updatePizza(String pizzaID, String pizzaName, String description, double price, String image) {
        String sql = "UPDATE Pizza SET pizzaName = ?, description = ?, price = ?, image = ? WHERE pizzaID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, pizzaName);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setString(5, pizzaID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean deletePizza(String pizzaID) {
        String sql = "DELETE FROM Pizza WHERE pizzaID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, pizzaID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean addOrder(String cusID, Date buyDate, int status) {
        String sql = "INSERT INTO Orders (cusID, buyDate, status, total) VALUES (?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusID);
            ps.setDate(2, buyDate);
            ps.setInt(3, status);
            ps.setInt(4, 0);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }
    
    public boolean updateOrderStatus(int status, String orderID) {
        String sql = "UPDATE orders SET status = ? WHERE orderID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setString(2, orderID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean deleteOrder(String orderID) {
        String sql = "DELETE FROM Orders WHERE orderID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, orderID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public order getNewOrder(String cusID) {
        order order = null;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT  TOP 1 *  FROM Orders where cusID = ? order by orderID desc";
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusID);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new order(
                        rs.getString("orderID"),
                        rs.getString("cusID"),
                        rs.getDate("buyDate"),
                        rs.getDouble("total"),
                        rs.getInt("status")
                );
                return order;
            }
        } catch (Exception ex) {
        }
        return order;
    }

    public List<order> getOrderOnLoad() {
        List<order> orderList = new ArrayList<>();
        order order;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT * FROM Orders";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                order = new order(
                        rs.getString("orderID"),
                        rs.getString("cusID"),
                        rs.getDate("buyDate"),
                        rs.getDouble("total"),
                        rs.getInt("status")
                );
                orderList.add(order);
            }
        } catch (Exception ex) {
        }

        return orderList;
    }
    
    
    public List<order> getOrderActive(int status) {
        List<order> orderList = new ArrayList<>();
        order order;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT * FROM Orders where status = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new order(
                        rs.getString("orderID"),
                        rs.getString("cusID"),
                        rs.getDate("buyDate"),
                        rs.getDouble("total"),
                        rs.getInt("status")
                );
                orderList.add(order);
            }
        } catch (Exception ex) {
        }

        return orderList;
    }
    
     public List<order> getOrderHistory(String cusID) {
        List<order> orderList = new ArrayList();
         order order;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT *  FROM Orders where cusID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, cusID);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new order(
                        rs.getString("orderID"),
                        rs.getString("cusID"),
                        rs.getDate("buyDate"),
                        rs.getDouble("total"),
                        rs.getInt("status")
                );
                orderList.add(order);
            }
        } catch (Exception ex) {
        }
        return orderList;
    }

    public boolean addOrderDetail(String pizzaID, String orderID, double price, int quantity) {
        String sql = "INSERT INTO OrderDetail (pizzaID, orderID, price, quantity, total) VALUES (?, ?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, pizzaID);
            ps.setString(2, orderID);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setDouble(5, 0);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public boolean deleteOrderDetail(String orderID) {
        String sql = "DELETE FROM OrderDetail WHERE orderID = ?;";
        boolean response = true;
        try {
            connection = DBLib.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, orderID);
            response = ps.executeUpdate() > 0;
        } catch (Exception ex) {
        }
        return response;
    }

    public List<orderDetail> getOrdeDetailOnLoad(String orderID) {
        List<orderDetail> orderDetailList = new ArrayList<>();
        orderDetail order;
        try {
            connection = DBLib.getConnection();
            String sql = "";
            sql = "SELECT * FROM OrderDetail where orderID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, orderID);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new orderDetail(
                        rs.getString("orderDetailID"),
                        rs.getString("pizzaID"),
                        rs.getString("orderID"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDouble("total")
                );
                orderDetailList.add(order);
            }
        } catch (Exception ex) {
        }

        return orderDetailList;
    }
}
