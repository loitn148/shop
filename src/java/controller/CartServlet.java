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
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author loitn148
 */
public class CartServlet extends HttpServlet {

    private final ProductDAO productDAO = new ProductDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String productId = request.getParameter("productId");
        String quantityUpdate = request.getParameter("quantity");

        Cart cart = (Cart) session.getAttribute("cart");

        try {
            Long id = Long.parseLong(productId);
            Product product = productDAO.getProduct(id);

            switch(command) {
                case "plus":
                    if(cart.getCartItem().containsKey(id)) {
                        int quantity = cart.getCartItem().get(id).getQuantity();
                        cart.addToCart(id, new Item(product, quantity));
                    } else {
                        cart.addToCart(id, new Item(product, 1));
                    }
                    break;
                case "update":
                    cart.updateCart(id, new Item(product, Integer.parseInt(quantityUpdate)));
                    break;
                case "delete":
                    cart.removeToCart(id);
                    break;
            }
        } catch (NumberFormatException | SQLException e) {
        }
        
        response.sendRedirect("/shop/cart/index.jsp");
    }
}