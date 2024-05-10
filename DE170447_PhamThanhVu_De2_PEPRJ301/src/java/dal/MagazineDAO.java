/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Magazine;

/**
 *
 * @author DELL
 */
public class MagazineDAO extends DBContext{
    
    public List<Magazine> getAll() {
        List<Magazine> list = new ArrayList<>();
        String sql = "select * from Magazine";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Magazine m = new Magazine(rs.getString("MagazineID"), rs.getString("MagazineName"),
                        rs.getInt("IssueNumber"), rs.getString("Publisher"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Magazine getMagazineById(String id) {
        String sql = "select * from Magazine where MAgazineID = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Magazine m = new Magazine(rs.getString("MagazineID"), rs.getString("MagazineName"),
                        rs.getInt("IssueNumber"), rs.getString("Publisher"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void insert(Magazine m) {
        String sql = "insert into Magazine\n"
                + "values(?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, m.getId());
            st.setString(2, m.getName());
            st.setInt(3, m.getIssueNumber());
            st.setString(4, m.getPublisher());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
