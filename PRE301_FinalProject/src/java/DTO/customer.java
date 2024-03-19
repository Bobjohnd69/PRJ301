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
public class customer {
    private String cusID;
    private String cusUserName;
    private String cusName;
    private String password;
    private String address;
    private String phoneNum;

    public customer(String cusID, String cusUserName, String cusName, String password, String address, String phoneNum) {
        this.cusID = cusID;
        this.cusUserName = cusUserName;
        this.cusName = cusName;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
  
    public String getCusUserName() {
        return cusUserName;
    }

    public void setCusUserName(String cusUserName) {
        this.cusUserName = cusUserName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}
