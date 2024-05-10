/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClassManagement;

/**
 *
 * @author DELL
 */
public class ClassDAO extends ClassDB {

    public List<ClassManagement> getAll() {
        List<ClassManagement> list = new ArrayList<>();
        String sql = "select * from DE170447";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassManagement c = new ClassManagement(rs.getString("ClassId"), rs.getString("Name"), rs.getInt("NumberOfStudent"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void delete(String id) {
        String sql = "delete from DE170447 where ClassId=?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ClassManagement getClassById(String id) {
        String sql = "select * from DE170447 where ClassId = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ClassManagement c = new ClassManagement(rs.getString("ClassId"), rs.getString("Name"), rs.getInt("NumberOfStudent"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void update(ClassManagement s) {
        String sql = "update DE170447 set Name=?, NumberOfStudent=? where ClassId = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, s.getName());
            st.setInt(2, s.getNumberOfStudent());
            st.setString(3, s.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
