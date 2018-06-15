/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author loitn148
 */
public class BillDAO {
    public boolean insert(Bill bill){
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO bill(id, user_id, owner, address, phone, total, payment, date, note, email) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setLong(1, bill.getBillID());
            ps.setLong(2, bill.getUserID());
            ps.setString(3, bill.getOwner());
            ps.setString(4, bill.getAddress());
            ps.setString(5, bill.getPhone());
            ps.setDouble(6, bill.getTotal());
            ps.setString(7, bill.getPayment());
            ps.setTimestamp(8, bill.getDate());
            ps.setString(9, bill.getNote());
            ps.setString(10, bill.getEmail());
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean update(long id, int status, int checkout){ 
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE bill SET status = ?, checkout = ? WHERE = ?";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setInt(1, status);
            ps.setInt(2, checkout);
            ps.setLong(3, id);
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ArrayList<Bill> getListBill() throws SQLException{
        String sql = "SELECT * FROM bill";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Bill> list = new ArrayList<>();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setBillID(rs.getInt("id"));
            bill.setUserID(rs.getInt("user_id"));
            bill.setOwner(rs.getString("owner"));
            bill.setAddress(rs.getString("address"));
            bill.setPhone(rs.getString("phone"));
            bill.setPayment(rs.getString("payment"));
            bill.setTotal(rs.getDouble("total"));
            bill.setDate(rs.getTimestamp("date"));
            bill.setNote(rs.getString("note"));
            bill.setEmail(rs.getString("email"));
            bill.setStatus(rs.getInt("status"));
            bill.setCheckout(rs.getInt("checkout"));
            list.add(bill);
        }
        return list;
    }
    
    public ArrayList<Bill> getListBill(long user_id) throws SQLException{
        String sql = "SELECT * FROM bill WHERE user_id = '" + user_id + "'";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Bill> list = new ArrayList<>();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setBillID(rs.getInt("id"));
            bill.setUserID(rs.getInt("user_id"));
            bill.setOwner(rs.getString("owner"));
            bill.setAddress(rs.getString("address"));
            bill.setPhone(rs.getString("phone"));
            bill.setPayment(rs.getString("payment"));
            bill.setTotal(rs.getDouble("total"));
            bill.setDate(rs.getTimestamp("date"));
            bill.setNote(rs.getString("note"));
            bill.setEmail(rs.getString("email"));
            bill.setStatus(rs.getInt("status"));
            bill.setCheckout(rs.getInt("checkout"));
            list.add(bill);
        }
        return list;
    }
    
    public Bill getBill(long id) throws SQLException{
        String sql = "SELECT * FROM bill WHERE id = '" + id + "'";
        ResultSet rs = this.getResultSet(sql);
        Bill bill = new Bill();
        while (rs.next()) {
            
            bill.setBillID(rs.getLong("id"));
            bill.setUserID(rs.getInt("user_id"));
            bill.setOwner(rs.getString("owner"));
            bill.setAddress(rs.getString("address"));
            bill.setPhone(rs.getString("phone"));
            bill.setPayment(rs.getString("payment"));
            bill.setTotal(rs.getDouble("total"));
            bill.setDate(rs.getTimestamp("date"));
            bill.setNote(rs.getString("note"));
            bill.setEmail(rs.getString("email"));
            bill.setStatus(rs.getInt("status"));
            bill.setCheckout(rs.getInt("checkout"));
        }
        return bill;
    }
    
    public ResultSet getResultSet(String sql) throws SQLException {
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        return rs;
    }
}
