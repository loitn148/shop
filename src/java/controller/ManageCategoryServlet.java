/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CategoryDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author loitn148
 */
public class ManageCategoryServlet extends HttpServlet {

    CategoryDAO catDAO = new CategoryDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String cat_id = request.getParameter("category_id");
        
        String url = "";
        
        try {
            switch(command){
                case "delete" :
                    catDAO.delete(Long.parseLong(cat_id));
                    url = "/shop/admin/manage_category.jsp";
                    break;
            }
        } catch (SQLException e) {
        }
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String catName = request.getParameter("catName");
        String catSlug = request.getParameter("catSlug");
        String catParent = request.getParameter("catParent");
        
        
        String url = "", error = "";
        if(catName.equals("") || catSlug.equals("")){
            error = "Please fill Form!";
            request.setAttribute("error", error);
        }
        
        long parent = catParent.equals("")? 0 : Long.parseLong(catParent);
        
        
        try {
            if(error.length() == 0) {
                switch(command){
                    case "insert" :
                        catDAO.insert(new Category(parent, catName, catSlug));
                        
                        url = "/shop/admin/manage_category.jsp";
                        break;
                    case "update" :
                        catDAO.update(new Category(parent, catName, catSlug), Long.parseLong(request.getParameter("category_id")));
                        url = "/shop/admin/manage_category.jsp";
                        break;
                }
            } else {
                url = "/shop/admin/insert_category.jsp";
            }
        } catch (SQLException e) {
        }
        response.sendRedirect(url);
    }
}
