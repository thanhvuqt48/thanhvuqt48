/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class ClassManagement {

    private String id;
    private String name;
    private int numberOfStudent;

    public ClassManagement() {
    }

    public ClassManagement(String id, String name, int numberOfStudent) {
        this.id = id;
        this.name = name;
        this.numberOfStudent = numberOfStudent;
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

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", name=" + name + ", numberOfStudent=" + numberOfStudent + '}';
    }

}
