/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dataStructure.CustomerList;

/**
 *
 * @author huyngo
 */
public class Order implements Comparable<Order> {

    //ATTRIBUTES
    private String orderID;
    private String customerID;
    private String productID;
    private int orderQuantity;
    private String orderDate;
    private boolean status;
    private static CustomerList customerList;

    //CONSTRUCTORS
    public Order() {
    }

    public Order(String orderID) {
        this.orderID = orderID;
    }

    public Order(String orderID, String customerID, String productID, int orderQuantity, String orderDate, boolean status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    //GETTERS AND SETTERS

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static void setCustomerList(CustomerList list) {
        customerList = list;
    }

    //OVERRIDE METHODS
    @Override
    public String toString() {
        return String.format("%-9s%-12s%-12s%-10d%-15s%-10b", orderID, customerID, productID, orderQuantity, orderDate, status);
    }

    @Override
    public int compareTo(Order o) {
        int pos1 = customerList.indexOf(new Customer(this.customerID));
        int pos2 = customerList.indexOf(new Customer(o.customerID));
        if (pos1 < 0 || pos2 < 0) {
            return 0;
        }
        String name1 = customerList.get(pos1).getCustomerName();
        String name2 = customerList.get(pos2).getCustomerName();
        return name1.compareTo(name2);
    }

    @Override
    public boolean equals(Object obj) {
        Order other = (Order) obj;
        return this.orderID.equalsIgnoreCase(other.orderID);
    }
    
}
