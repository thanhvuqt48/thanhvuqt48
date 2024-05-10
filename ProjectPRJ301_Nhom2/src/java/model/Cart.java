/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart {

    private Product product;
    private Account account;
    private int quantity;
    private int size;

    public Cart() {
    }

    public Cart(Product product, Account account, int quantity, int size) {
        this.product = product;
        this.account = account;
        this.quantity = quantity;
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cart{" + "product=" + product + ", account=" + account + ", quantity=" + quantity + ", size=" + size + '}';
    }
    
    public BigDecimal getTotalMoney(List<Cart> list){
        BigDecimal totalMoney = BigDecimal.ZERO;
        for(Cart c : list){
            totalMoney = BigDecimal.valueOf(c.getQuantity()).multiply(c.getProduct().getPrice());
        }
        return totalMoney;
    }

    

}
