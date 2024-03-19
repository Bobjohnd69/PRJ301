/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author minht
 */
public class orderDetail {
    private String orderDetailID;
    private String pizzaID;
    private String orderID;
    private double price;
    private int quantity;
    private double total;

    public orderDetail(String orderDetailID, String pizzaID, String orderID, double price, int quantity, double total) {
        this.orderDetailID = orderDetailID;
        this.pizzaID = pizzaID;
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(String pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
