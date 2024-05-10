/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Magazine {

    private String id;
    private String name;
    private int issueNumber;
    private String publisher;

    public Magazine() {
    }

    public Magazine(String id, String name, int issueNumber, String publisher) {
        this.id = id;
        this.name = name;
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Magazine{" + "id=" + id + ", name=" + name + ", issueNumber=" + issueNumber + ", publisher=" + publisher + '}';
    }

}
