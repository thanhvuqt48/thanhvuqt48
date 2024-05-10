/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Account {

    private int uid;
    private String username;
    private String phoneNumber;
    private String password;
    private String address;
    private String name;
    private int role;

    public Account() {
    }

    public Account(int uid, String username, String phoneNumber, String password, String address, String name, int role) {
        this.uid = uid;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.name = name;
        this.role = role;
    }

    public Account(String username, String phoneNumber, String password, String address, String name) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.name = name;
    }

    public Account(int uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "uid=" + uid + ", username=" + username + ", phoneNumber=" + phoneNumber + ", password=" + password + ", address=" + address + ", name=" + name + ", role=" + role + '}';
    }

}
