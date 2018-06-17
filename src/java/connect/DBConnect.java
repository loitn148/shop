/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author loitn148
 */
public class DBConnect {
     public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            cons = DriverManager.getConnection(
//                    "jdbc:mysql://fdb1.awardspace.net:3306/2753157_annshop?useUnicode=true&characterEncoding=utf8", "2753157_annshop", "Ngocloi148@123456789");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/annshop?useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return cons;
    }
}
