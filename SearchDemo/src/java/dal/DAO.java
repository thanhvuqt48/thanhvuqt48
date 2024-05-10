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
import model.Category;
import model.Product;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class DAO extends DBContext{
    
    // Đọc tất cả các bản ghi từ table categoríes
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    // tim 1 category khi co id
    public Category getCategoryById(int id) {
        String sql = "select * from Categories where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    // Đọc từ bảng Products theo cid
    public List<Product> getProductsByCid(int cid){
        List<Product> list = new ArrayList<>();
            String sql = "select * from products where 1=1";
            if(cid!=0){
                sql += " and cid=" + cid;
            }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("id"), rs.getString("name"), rs.getInt("quantity")
                        , rs.getDouble("price"), rs.getDate("releaseDate"), rs.getString("describe")
                        , rs.getString("image"), getCategoryById(rs.getInt("cid")));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> search(String key, Date from, Date to, Double price1, Double price2, int cid){
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1";
        if(key != null && !key.equals("")){
            sql += " and name like '%" + key + "%' or describe like '%" + key + "%'"; 
        } 
        if(from != null){
            sql += " and releaseDate >= '" + from + "'";
        }
        if(to != null){
            sql += " and releaseDate <= '" + to + "'";
        }
        if(price1 != null){
            sql += " and price >= '" + price1 + "'";
        }
        if(price2 != null){
            sql += " and price <= '" + price2 + "'";
        }
        if (cid != 0){
            sql += " and cid = " + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("id"), rs.getString("name"), rs.getInt("quantity")
                        , rs.getDouble("price"), rs.getDate("releaseDate"), rs.getString("describe")
                        , rs.getString("image"), getCategoryById(rs.getInt("cid")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    
    
}
