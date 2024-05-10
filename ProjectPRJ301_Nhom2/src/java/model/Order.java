/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Order {

    private int orderId;
    private Account account;
    private Product product;
    private String address;
    private String phoneNumber;
    private int size;
    private int quantity;
    private String orderTime;
    private int orderStatus;

    public Order() {
    }

    public Order(int orderId, Account account, Product product, String address, String phoneNumber, int size, int quantity, String orderTime, int orderStatus) {
        this.orderId = orderId;
        this.account = account;
        this.product = product;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public Order(int orderId, Account account, Product product, String address, String phoneNumber, int size, int quantity, int orderStatus) {
        this.orderId = orderId;
        this.account = account;
        this.product = product;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
    }
    
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", account=" + account + ", product=" + product + ", address=" + address + ", phoneNumber=" + phoneNumber + ", size=" + size + ", quantity=" + quantity + ", orderTime=" + orderTime + ", orderStatus=" + orderStatus + '}';
    }

}
