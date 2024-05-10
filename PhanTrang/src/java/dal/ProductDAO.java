/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author DELL
 */
public class ProductDAO extends DBContext{
    
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id, p.name, p.quantity, p.price, p.releaseDate, p.describe, "
                + " p.image, p.cid cid, c.name cname, c.describe cdescribe from Products p inner join Categories c "
                + " on p.cid = c.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"), 
                        rs.getString("cdescribe"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> searchByName(String key) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id, p.name, p.quantity, p.price, p.releaseDate, p.describe, "
                + " p.image, p.cid cid, c.name cname, c.describe cdescribe from Products p inner join Categories c "
                + " on p.cid = c.id where p.name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"), 
                        rs.getString("cdescribe"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getByCategoryId(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id, p.name, p.quantity, p.price, p.releaseDate, p.describe, "
                + " p.image, p.cid cid, c.name cname, c.describe cdescribe from Products p inner join Categories c "
                + " on p.cid = c.id where cid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"), 
                        rs.getString("cdescribe"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getListByPage(List<Product> list, int start, int end){
        List<Product> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public List<Product> checkPhones(int[] id){
        List<Product> list = new ArrayList<>();
        String sql = "select p.id, p.name, p.quantity, p.price, p.releaseDate, p.describe, "
                + " p.image, p.cid cid, c.name cname, c.describe cdescribe from Products p inner join Categories c "
                + " on p.cid = c.id"
                + " where 1 = 1 ";
        if (id != null){
            sql += " and p.cid in(";
            for (int i = 0; i < id.length; i++){
                sql += id[i] + ",";
            }
            if (sql.endsWith(","))
                sql = sql.substring(0, sql.length() - 1);
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"), 
                        rs.getString("cdescribe"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.getAll();
        list.forEach(System.out::println);
    }
}
