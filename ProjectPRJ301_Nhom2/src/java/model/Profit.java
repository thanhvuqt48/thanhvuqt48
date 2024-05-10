/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author ACER
 */
public class Profit {

    private int orderID;
    private Product product;
    private int quantity;
    private BigDecimal profit;
    private int orderStatus;

    public Profit() {
    }

    public Profit(int orderID, Product product, int quantity, BigDecimal profit, int orderStatus) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
        this.profit = profit;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Profit{" + "orderID=" + orderID + ", product=" + product + ", quantity=" + quantity + ", profit=" + profit + ", orderStatus=" + orderStatus + '}';
    }

}
