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
import model.Product;

/**
 *
 * @author loitn148
 */
public class ProductDAO {
    public ArrayList<Product> getListProduct() throws SQLException{
        String sql = "SELECT * FROM product";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("cat_id"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductSlug(rs.getString("product_slug"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDiscount(rs.getInt("product_discount"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductPriceSale(rs.getDouble("product_price_sale"));
            list.add(product);
        }
        return list;
    }
    
    public ArrayList<Product> getListProductByCategory(long cat_id) throws SQLException{
        String sql = "SELECT * FROM product WHERE cat_id = '" + cat_id + "'";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("cat_id"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductSlug(rs.getString("product_slug"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDiscount(rs.getInt("product_discount"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductPriceSale(rs.getDouble("product_price_sale"));
            list.add(product);
        }
        return list;
    }
    
    public ArrayList<Product> getListProductByCategory(String cat_slug) throws SQLException{
        String sql = "SELECT * FROM product p, category c WHERE p.cat_id = c.cat_id AND slug = '" + cat_slug + "'" ;
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("cat_id"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductSlug(rs.getString("product_slug"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDiscount(rs.getInt("product_discount"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductPriceSale(rs.getDouble("product_price_sale"));
            list.add(product);
        }
        return list;
    }
    
    public Product getProduct(String prod_slug) throws SQLException{
        String sql = "SELECT * FROM product WHERE product_slug = '" + prod_slug + "'";
        ResultSet rs = this.getResultSet(sql);
        Product product = new Product();
        while(rs.next()){
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("cat_id"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDiscount(rs.getInt("product_discount"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductSlug(rs.getString("product_slug"));
            product.setProductPriceSale(rs.getDouble("product_price_sale"));
        }
        
        return product;
    }
    
    public Product getProduct(long prod_id) throws SQLException{
        String sql = "SELECT * FROM product WHERE product_id = '" + prod_id + "'";
        ResultSet rs = this.getResultSet(sql);
        Product product = new Product();
        while(rs.next()){
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("cat_id"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDiscount(rs.getInt("product_discount"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductSlug(rs.getString("product_slug"));
            product.setProductPriceSale(rs.getDouble("product_price_sale"));
        }
        
        return product;
    }
    
    public boolean insert(Product p) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO product(product_name, cat_id, product_slug, product_price, product_discount, product_description, product_image, product_price_sale) VALUE(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, p.getProductName());
            ps.setLong(2, p.getCategoryId());
            ps.setString(3, p.getProductSlug());
            ps.setDouble(4, p.getProductPrice());
            ps.setDouble(5, p.getProductDiscount());
            ps.setString(6, p.getProductSlug());
            ps.setString(7, p.getProductImage());
            ps.setDouble(8, p.getProductPriceSale());
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Product p, long prod_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE product SET product_name = ?, cat_id = ?, product_slug = ?,"
                    + " product_price = ?, product_discount = ?, product_description = ?,"
                    + " product_image = ?, product_price_sale = ? WHERE product_id = ?";    
            
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, p.getProductName());
            ps.setLong(2, p.getCategoryId());
            ps.setString(3, p.getProductSlug());
            ps.setDouble(4, p.getProductPrice());
            ps.setDouble(5, p.getProductDiscount());
            ps.setString(6, p.getProductDescription());
            ps.setString(7, p.getProductImage());
            ps.setDouble(8, p.getProductPriceSale());
            ps.setLong(9, prod_id);
            
            
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(long prod_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "DELETE FROM product WHERE product_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, prod_id);
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
