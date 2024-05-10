package dal;

import java.util.List;
import model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author DELL
 */
public class OrderDAO extends DBContext {

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
    
    public List<Order> getOrdersByStatus(int status) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from ProductOrder where OrderStatus=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("OrderID"), getAccountById(rs.getInt("uid")),
                        getProductByID(rs.getString("ProductId")),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("Size"),
                        rs.getInt("Quantity"),
                        rs.getString("OrderTime"),
                        rs.getInt("OrderStatus"));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Order> getOrdersByUid(int uid) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from ProductOrder where uid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
//            st.setInt(2, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("OrderID"), getAccountById(rs.getInt("uid")),
                        getProductByID(rs.getString("ProductId")),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("Size"),
                        rs.getInt("Quantity"),
                        rs.getString("OrderTime"),
                        rs.getInt("OrderStatus"));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Order getOrderByUidPidAndStatus(int uid, String pid, int status) {
        String sql = "select * from ProductOrder where uid = ? and ProductId = ? and OrderStatus=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, pid);
            st.setInt(3, status);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order o = new Order(rs.getInt("OrderID"), getAccountById(rs.getInt("uid")),
                        getProductByID(rs.getString("ProductId")),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("Size"),
                        rs.getInt("Quantity"),
                        rs.getString("OrderTime"),
                        rs.getInt("OrderStatus"));
                return o;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Cart getCartByUidAndPid(int uid, String pid) {
        String sql = "select * from Cart where uid = ? and ProductId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, pid);
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

    public int getStatusByUid(int uid) {
        String sql = "select * from ProductOrder where uid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int status = rs.getInt("OrderStatus");
                return status;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void insertOrder(Order o) {
        String sql = "insert into ProductOrder\n"
                + "values(?, ?, ?, ?, ?, ?, GETDATE(), ?)";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, o.getAccount().getUid());
            st.setString(2, o.getProduct().getProductId());
            st.setString(3, o.getAddress());
            st.setString(4, o.getPhoneNumber());
            st.setInt(5, o.getSize());
            st.setInt(6, o.getQuantity());
            st.setInt(7, o.getOrderStatus());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void done(Order o, int status) {
        String sql = "update ProductOrder set OrderStatus = ? where uid = ? and ProductId=? and OrderStatus = 0";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, status);
            st.setInt(2, o.getAccount().getUid());
            st.setString(3, o.getProduct().getProductId());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();

//        Date date = new Date(System.currentTimeMillis());
//        Order o = new Order(0, od.getAccountById(1), od.getProductByID("af11"), od.getCartByUidAndPid(1, "af11"),date, 0);
//       od.insertOrder(o);
        List<Order> list = od.getOrdersByStatus(0);
        list.forEach(System.out::println);
        Order o = new Order(0, od.getAccountById(3), od.getProductByID("af5"),
                "Dong Ha", "0917238964", 44, 2, 0);
        od.insertOrder(o);
        System.out.println("finish");

    }

}
