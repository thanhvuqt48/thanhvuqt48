/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class CategoryDAO extends DBContext {

    public List<Category> getALL() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from YouID";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCustomerID(rs.getString("customerID"));
                c.setName(rs.getString("name"));
                c.setNumberOfPuscharses(rs.getInt("NumberOfPurchases"));
                list.add(c);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void deleteCategoryById(String id) {
        String sql = "DELETE FROM YouID WHERE customerID = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        }
    }

    public Category getClassById(String id) {
        String sql = "select * from YouID where customerID = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getString("customerID"), rs.getString("name"), rs.getInt("NumberOfPurchases"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void update(Category s) {
        String sql = "update YouID set name=?, NumberOfPurchases=? where customerID = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, s.getName());
            st.setInt(2, s.getNumberOfPuscharses());
            st.setString(3, s.getCustomerID());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Category getCategoryByID(String id) {
        String sql = "select * from YouID where customerID = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getString("customerID"), rs.getString("name"), rs.getInt("NumberOfPurchases"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        CategoryDAO cD = new CategoryDAO();
        List<Category> l = cD.getALL();
        System.out.println(l.get(0));
        Category c = cD.getCategoryByID("C002");
        System.out.println(c);

    }

}
