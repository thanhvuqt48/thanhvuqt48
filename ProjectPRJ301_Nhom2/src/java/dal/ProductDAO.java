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

/**
 *
 * @author DELL
 */
public class ProductDAO extends DBContext {

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Product getProductByID(String id){
        String sql = "select * from product where ProductID = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getString("ProductID"), rs.getString("Name"),
                        rs.getBigDecimal("Price"), rs.getString("Describe"),
                        rs.getString("Image"), getCategoryById(rs.getInt("cid")));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByCid(int cid) {
        List<Product> list = new ArrayList<>();

        String sql = "select * from product where 1=1";
        if (cid != 0) {
            sql += " and cid=" + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getString("ProductID"));
                p.setName(rs.getString("Name"));
                p.setPrice(rs.getBigDecimal("Price"));
                p.setDescribe(rs.getString("Describe"));
                p.setImage(rs.getString("Image"));
                p.setCategory(getCategoryById(rs.getInt("cid")));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "select * from Category where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        List<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public List<Product> searchByName(String TXTsearch) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE Name LIKE ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + TXTsearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product( rs.getString(1),
                        rs.getString(2),
                        rs.getBigDecimal(3),
                        rs.getString(4),
                        rs.getString(5),
                        getCategoryById(rs.getInt(6))
                ));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteProduct(String id) {
        String sql = "delete from Product where ProductID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateProduct(Product c) {
        String sql = "update Product set Price=?, Describe=? where ProductID=? ";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setBigDecimal(1, c.getPrice());
            st.setString(2, c.getDescribe());
            st.setString(3, c.getProductId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertProduct(Product c) {
        String sql = "insert into PRODUCT values(?,?,?,?,?,?)";

        // Đường dẫn ảnh
        String image;
        switch (c.getCategory().getId()) {
            case 1 ->
                image = "images/af/" + c.getImage();
            case 2 ->
                image = "images/aj/" + c.getImage();
            case 3 ->
                image = "images/am/" + c.getImage();
            case 4 ->
                image = "images/ap/" + c.getImage();
            default ->
                throw new AssertionError();
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductId());
            st.setString(2, c.getName());
            st.setBigDecimal(3, c.getPrice());
            st.setString(4, c.getDescribe());
            st.setString(5, image); // Sử dụng biến image đã được xử lý
            st.setInt(6, c.getCategory().getId()); // Lấy ID của category

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        List<Product> list = p.getProductByCid(1);
        list.forEach(System.out::println);
    }
}
