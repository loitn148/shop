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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author loitn148
 */
public class UsersDAO { 
    public boolean checkEmail(String email){
        String sql = "SELECT * FROM users WHERE email = '" + email + "'";
        try {
            ResultSet rs = this.getResultSet(sql);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkPassword(String password){
        return password.length() > 6 && password.length() < 30;
    }
    
    public boolean checkRePassword(String password, String re_password){
        return password.equals(re_password);
    }
    
    public boolean insert(Users user){
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO users(email, password, fullname) VALUE(?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getToken());
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean update(long id, String password){
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE users SET password = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setLong(1, id);
            ps.setString(2, password);
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
     public boolean delete(long id){
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            
            ps.setLong(1, id);
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ResultSet getResultSet(String sql) throws SQLException {
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
}
