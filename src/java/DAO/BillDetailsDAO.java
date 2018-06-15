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
import model.BillDetails;

/**
 *
 * @author loitn148
 */
public class BillDetailsDAO {
    public boolean insert(BillDetails billDetails) {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO bill_details(bill_id, product_id, price, quantity) "
                + "VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setLong(1, billDetails.getBillID());
            ps.setLong(2, billDetails.getProductID());
            ps.setDouble(3, billDetails.getPrice());
            ps.setInt(4, billDetails.getQuantity());
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ArrayList<BillDetails> getBillDetails(long bill_id) throws SQLException{
        String sql = "SELECT * FROM bill_details WHERE bill_id = '" + bill_id + "'";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<BillDetails> list = new ArrayList<>();
        while (rs.next()) {
            BillDetails billDetails = new BillDetails();
            
            billDetails.setBillDetailsID(rs.getInt("id"));
            billDetails.setBillID(rs.getLong("bill_id"));
            billDetails.setProductID(rs.getInt("product_id"));
            billDetails.setPrice(rs.getDouble("price"));
            billDetails.setQuantity(rs.getInt("quantity"));
            
            list.add(billDetails);
        }
        return list;
    }
    
    public ResultSet getResultSet(String sql) throws SQLException {
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        return rs;
    }
}
