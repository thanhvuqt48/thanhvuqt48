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

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends DBContext {

    public ArrayList<Account> getAll() {
        ArrayList<Account> account = new ArrayList<>();
        String stm1 = "select * from Account";
        ResultSet re;
        try {
            PreparedStatement p1 = connection.prepareStatement(stm1);

            re = p1.executeQuery();
            while (re.next()) {
                account.add(new Account(re.getInt(1), re.getString(2),
                        re.getString(3), re.getString(4), re.getString(5), re.getString(6), re.getInt(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return account;
    }

    public ArrayList<Account> getAccountStaff() {
        ArrayList<Account> account = new ArrayList<>();
        String stm1 = "select * from Account where role = 2";
        ResultSet re;
        try {
            PreparedStatement p1 = connection.prepareStatement(stm1);

            re = p1.executeQuery();
            while (re.next()) {
                account.add(new Account(re.getInt(1), re.getString(2),
                        re.getString(3), re.getString(4), re.getString(5), re.getString(6), re.getInt(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return account;
    }

    public void deleteStaff(int id) {
        String sql = "delete from Account where uid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account getAccountByUsername(String username) {
        String sql = "select * from Account where username=?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account c = new Account();
                c.setUid(rs.getInt(1));
                c.setUsername(rs.getString(2));
                c.setPhoneNumber(rs.getString(3));
                c.setPassword(rs.getString(4));
                c.setAddress(rs.getString(5));
                c.setName(rs.getString(6));
                c.setRole(rs.getInt(7));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getAccountByUid(int uid) {
        String sql = "select * from Account where uid=?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account c = new Account();
                c.setUid(rs.getInt(1));
                c.setUsername(rs.getString(2));
                c.setPhoneNumber(rs.getString(3));
                c.setPassword(rs.getString(4));
                c.setAddress(rs.getString(5));
                c.setName(rs.getString(6));
                c.setRole(rs.getInt(7));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void newAccount(Account c) {
        String sql = "insert into Account values(?,?,?,?,?,3)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getPhoneNumber());
            st.setString(3, c.getPassword());
            st.setString(4, c.getAddress());
            st.setString(5, c.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePassword(Account c) {
        String sql = "update Account set password=? where uid=? ";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, c.getPassword());
            st.setInt(2, c.getUid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateInformation(Account c) {
        String sql = "update Account set name=?, phonenumber = ?, address = ? where uid=? ";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getPhoneNumber());
            st.setString(3, c.getAddress());
            st.setInt(4, c.getUid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void newAccountStaff(Account c) {
        String sql = "insert into Account values(?,?,?,?,?,2)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getPhoneNumber());
            st.setString(3, c.getPassword());
            st.setString(4, c.getAddress());
            st.setString(5, c.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Account> getListByPage(List<Account> list, int start, int end) {
        List<Account> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void updateAccountStaff(Account s) {
        String sql = "update Account set phoneNumber=?, password=?, name=? where username = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, s.getPhoneNumber());
            st.setString(2, s.getPassword());
            st.setString(3, s.getName());
            st.setString(4, s.getUsername());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AccountDAO list = new AccountDAO();
        Account s = list.getAccountByUsername("staff");
        System.out.println(s);
    }
}
