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
import model.Profit;

/**
 *
 * @author ACER
 */
public class ProfitDAO extends DBContext {

    public List<Profit> getProfit() {
        List<Profit> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    po.OrderID,\n"
                + "    po.ProductID, \n"
                + "    SUM(po.Quantity) AS Quantity, \n"
                + "    SUM(po.Quantity * p.Price) AS Profit,\n"
                + "	2 as OrderStatus\n"
                + "FROM \n"
                + "    ProductOrder po\n"
                + "JOIN \n"
                + "    Product p ON po.ProductID = p.ProductID\n"
                + "WHERE \n"
                + "    po.OrderStatus = 1\n"
                + "GROUP BY \n"
                + "    po.OrderID, po.ProductID;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Profit(rs.getInt(1),
                        getProductByID(rs.getString(2)),
                        rs.getInt(3),
                        rs.getBigDecimal(4),
                        rs.getInt(5)
                ));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductByID(String id) {
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

    public static void main(String[] args) {
        ProfitDAO cd = new ProfitDAO();
        List<Profit> l = cd.getProfit();
        l.forEach(System.out::println);
    }
    
   
}
