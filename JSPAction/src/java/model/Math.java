/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Math implements Serializable {

    private String num1="", num2="", op="";

    public Math() {
    }
 
    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public double sum() {
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        return a + b;
    }

    public String getResult() {
        String rs = "";
        try {
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            switch (op) {
                case "+" -> {
                    rs = "Tổng: " + (a + b);
                }
                case "-" -> {
                    rs = "Hiệu: " + (a - b);
                }
                case "*" -> {
                    rs = "Tích: " + (a * b);
                }
                case "/" -> {
                    if (b == 0) {
                        rs = "b phải khác 0";
                    } else {
                        rs = "Thương: " + (a / b);
                    }
                }
            }
        } catch (NumberFormatException e) {
            rs = "Nhập vào số !!!";
            System.out.println(e);
        }
        return rs;
    }

}
