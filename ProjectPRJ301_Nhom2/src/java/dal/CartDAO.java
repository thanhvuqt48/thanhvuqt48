/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class CartDAO extends DBContext {

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
    
    public List<Cart> getCartsByUid(int uid) {
        List<Cart> list = new ArrayList<>();
        String sql = "select * from Cart where uid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart c = new Cart(getProductByID(rs.getString("ProductID")), getAccountById(rs.getInt("uid")),
                        rs.getInt("Quantity"), rs.getInt("Size"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Cart> getCartsByUidAndPid(int uid, String pid) {
        List<Cart> list = new ArrayList<>();
        String sql = "select * from Cart where uid = ? and ProductId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart c = new Cart(getProductByID(rs.getString("ProductID")), getAccountById(rs.getInt("uid")),
                        rs.getInt("Quantity"), rs.getInt("Size"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Cart getCartByUidAndPid(int uid, String pid, int size) {
        String sql = "select * from Cart where uid = ? and ProductId=? and size = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, pid);
            st.setInt(3, size);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart c = new Cart(getProductByID(rs.getString("ProductID")), getAccountById(rs.getInt("uid")),
                        rs.getInt("Quantity"), rs.getInt("Size"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Product getProductByID(String id) {
        String sql = "select * from Product where ProductID = ?";

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

    public Account getAccountById(int id) {
        String sql = "select * from Account where uid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(id, rs.getString("Username"), rs.getString("PhoneNumber"),
                        rs.getString("Password"), rs.getString("Address"), rs.getString("Name"), rs.getInt("Role"));

                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
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

    public void insertCart(Cart c) {
        Cart cart = getCartByUidAndPid(c.getAccount().getUid(), c.getProduct().getProductId(), c.getSize());
        if (cart == null) {
            String sql = "insert into Cart values(?, ?, ?, ?)";
            try {
                PreparedStatement st = connection.prepareCall(sql);
                st.setString(1, c.getProduct().getProductId());
                st.setInt(2, c.getAccount().getUid());
                st.setInt(3, c.getQuantity());
                st.setInt(4, c.getSize());

                st.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            int quantity = c.getQuantity() + cart.getQuantity();
            updateQuantity(c.getProduct().getProductId(), quantity, c.getAccount().getUid(), c.getSize());
        }
    }

    public void deleteCart(String pid, int uid, int size) {
        String sql = "delete from cart where ProductId=? and uid=? and size =?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, pid);
            st.setInt(2, uid);
            st.setInt(3, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateQuantity(String pid, int quantity, int uid, int size) {
        String sql = "update Cart set quantity = ? where uid = ? and ProductId=? and size = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, quantity);
            st.setInt(2, uid);
            st.setString(3, pid);
            st.setInt(4, size);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CartDAO cd = new CartDAO();
        List<Cart> list = cd.getCartsByUidAndPid(1, "af12");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);

    }
}
