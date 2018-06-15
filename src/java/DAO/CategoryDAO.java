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
import model.Category;

/**
 *
 * @author loitn148
 */
public class CategoryDAO {

    //get list category
    public ArrayList<Category> getListCategory() throws SQLException {
        String sql = "SELECT * FROM category WHERE cat_parent_id = 0";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Category> list = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setCatId(rs.getInt("cat_id"));
            category.setCatName(rs.getString("cat_name"));
            category.setSlug(rs.getString("slug"));
            category.setCatParentId(rs.getInt("cat_parent_id"));
            list.add(category);
        }
        return list;
    }
    
    //get list category
    public ArrayList<Category> getAllListCategory() throws SQLException {
        String sql = "SELECT * FROM category";
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Category> list = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setCatId(rs.getInt("cat_id"));
            category.setCatName(rs.getString("cat_name"));
            category.setSlug(rs.getString("slug"));
            category.setCatParentId(rs.getInt("cat_parent_id"));
            list.add(category);
        }
        return list;
    }

    //get child list category
    public ArrayList<Category> getChildListCategory(long parent_id) throws SQLException {
        String sql = "SELECT * FROM category WHERE cat_parent_id = " + parent_id;
        ResultSet rs = this.getResultSet(sql);
        ArrayList<Category> list_child = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setCatId(rs.getInt("cat_id"));
            category.setCatName(rs.getString("cat_name"));
            category.setSlug(rs.getString("slug"));
            category.setCatParentId(rs.getInt("cat_parent_id"));
            list_child.add(category);
        }
        return list_child;
    }
    
    //get child list category
    public Category getCategory(long id) throws SQLException {
        String sql = "SELECT * FROM category WHERE cat_id = '" + id + "'";
        ResultSet rs = this.getResultSet(sql);
        Category category = new Category();
        while (rs.next()) {
            category.setCatId(rs.getInt("cat_id"));
            category.setCatName(rs.getString("cat_name"));
            category.setSlug(rs.getString("slug"));
            category.setCatParentId(rs.getInt("cat_parent_id"));
        }
        return category;
    }

    public boolean insert(Category c) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT INTO category(cat_name, cat_parent_id, slug) VALUE(?,?,?)";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, c.getCatName());
            ps.setLong(2, c.getCatParentId());
            ps.setString(3, c.getSlug());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Category c, long cat_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "UPDATE category SET cat_name = ?, cat_parent_id = ?, slug = ? WHERE cat_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, c.getCatName());
            ps.setLong(2, c.getCatParentId());
            ps.setString(3, c.getSlug());
            ps.setLong(4, cat_id);
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(long cat_id) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "DELETE FROM category WHERE cat_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, cat_id);
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
