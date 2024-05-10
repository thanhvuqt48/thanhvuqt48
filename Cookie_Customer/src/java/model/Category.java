/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Category {

    private String customerID, name;
    int NumberOfPuscharses;

    public Category() {
    }

    public Category(String customerID, String name, int NumberOfPuscharses) {
        this.customerID = customerID;
        this.name = name;
        this.NumberOfPuscharses = NumberOfPuscharses;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPuscharses() {
        return NumberOfPuscharses;
    }

    public void setNumberOfPuscharses(int NumberOfPuscharses) {
        this.NumberOfPuscharses = NumberOfPuscharses;
    }

    @Override
    public String toString() {
        return "Category{" + "customerID=" + customerID + ", name=" + name + ", NumberOfPuscharses=" + NumberOfPuscharses + '}';
    }

}
