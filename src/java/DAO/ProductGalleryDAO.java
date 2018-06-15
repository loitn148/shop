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
import model.ProductGallery;

/**
 *
 * @author loitn148
 */
public class ProductGalleryDAO {
    
    public ArrayList<ProductGallery> getListGallery (String prod_slug) throws SQLException{
        String sql = "SELECT * FROM p_gallery g, product p WHERE p.product_id = g.product_id AND p.product_slug = '" + prod_slug + "'" ;
        ResultSet rs = this.getResultSet(sql);
        ArrayList<ProductGallery> list = new ArrayList<>();
        while (rs.next()){
            ProductGallery prodGallery = new ProductGallery();
            prodGallery.setId(rs.getInt("id"));
            prodGallery.setImageGallery(rs.getString("image_gallery"));
            prodGallery.setProductId(rs.getInt("product_id"));
            list.add(prodGallery);
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
