/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Student;

/**
 *
 * @author DELL
 */
public class StudentDAO extends StudentDB {

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from STUDENT";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student c = new Student(rs.getString("id"), rs.getString("StudentName"), rs.getString("gender"), rs.getString("birthday"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Student getStudentById(String id) {
        String sql = "select * from Student where id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student c = new Student(rs.getString("id"), rs.getString("StudentName"), rs.getString("gender"), rs.getString("birthday"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(Student s) {
        String sql = "insert into STUDENT\n"
                + "values(?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, s.getId());
            st.setString(2, s.getName());
            st.setString(3, s.getGender());
            st.setString(4, s.getBirthday());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Student s) {
        String sql = "update STUDENT set StudentName=?, Gender=?, Birthday=? where id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, s.getName());
            st.setString(2, s.getGender());
            st.setString(3, s.getBirthday());
            st.setString(4, s.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String id) {
        String sql = "delete from STUDENT where id=?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        StudentDAO c = new StudentDAO();
        List<Student> list = c.getAll();
        for (Student st : list) {
            System.out.println(st);
        }
    }
}
