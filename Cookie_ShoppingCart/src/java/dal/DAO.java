package dal;

import model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class DAO extends DBContext {
    
    public Customer getAccount(String username, String password){
        String sql = "select * from customer where username = ? and password = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return new Customer(rs.getInt("ID"), rs.getString("name"),
                        rs.getDouble("amount"), username, password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Product> getProducts(){
        List<Product> list = new ArrayList<>();
        
        String sql = "select * from product";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getInt("quantity"));
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public Product getProductById(int id){
        
        String sql = "select * from product where id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Product p = new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getInt("quantity"));
                
                return p;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
