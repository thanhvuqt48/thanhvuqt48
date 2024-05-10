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
import model.Book;

/**
 *
 * @author DELL
 */
public class BookDAO extends DBContext {
    
    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from Book";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book p = new Book();
                p.setBookId(rs.getString("BookID").trim());
                p.setTitle(rs.getString("Title").trim());
                p.setAuthor(rs.getString("Author").trim());
                p.setDescription(rs.getString("Description").trim());
                p.setPublishYear(rs.getInt("PublishYear"));
                p.setCategory(rs.getString("Category"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Book> getListByPage(List<Book> list, int start, int end) {
        List<Book> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public static void main(String[] args) {
        BookDAO bd = new BookDAO();
        List<Book> list = bd.getAll();
        list.forEach(System.out::println);
    }
}
