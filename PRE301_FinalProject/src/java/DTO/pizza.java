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
public class pizza {
    private String pizzaID;
    private String pizzaName;
    private String description;
    private double price;
    private String image;

    public pizza() {
    }

    public pizza(String pizzaID, String pizzaName, String description, double price, String image) {
        this.pizzaID = pizzaID;
        this.pizzaName = pizzaName;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    
    
    public String getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(String pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
