/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author loitn148
 */
public class ManageProductServlet extends HttpServlet {
    
    ProductDAO prodDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String product_id = request.getParameter("product_id");
        
        String url = "";
        
        try {
            switch(command){
                case "delete" :
                    prodDAO.delete(Long.parseLong(product_id));
                    url = "/shop/admin/manage_product.jsp";
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
        String prodName = request.getParameter("prodName");
        String prodSlug = request.getParameter("prodSlug");
        String prodPrice = request.getParameter("prodPrice");
        String prodDiscount = request.getParameter("prodDiscount");
        String catId = request.getParameter("catId");
        String prodDescription = request.getParameter("prodDescription");
        String prodImage = request.getParameter("prodImage");
        
        String url = "", error = "";
        if(prodName.equals("") || prodSlug.equals("") || prodPrice.equals("")){
            error = "Please fill Form on Name, Slug & Price!";
            request.setAttribute("error", error);
        }
        
        double price = Double.parseDouble(prodPrice),
                discount = Double.parseDouble(prodDiscount),
                price_sale = price - price*discount/100;
        long category = catId.equals("") ? 0: Long.parseLong(catId);
        
        try {
            if(error.length() == 0) {
                switch(command){
                    case "insert" :
                        prodDAO.insert(new Product(prodName, category, prodSlug, price, discount, prodDescription, prodImage, price_sale));
                        url = "/shop/admin/manage_product.jsp";
                        break;
                    case "update" :
                        prodDAO.update(new Product(prodName, category, prodSlug, price, discount, prodDescription, prodImage, price_sale), Long.parseLong(request.getParameter("product_id")));
                        url = "/shop/admin/manage_product.jsp";
                        break;
                }
            } else {
                url = "/shop/admin/insert_product.jsp";
            }
        } catch (SQLException e) {
        }
        response.sendRedirect(url);
    }

   
}
