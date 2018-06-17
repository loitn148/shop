/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BillDAO;
import DAO.BillDetailsDAO;
import DAO.ProductDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetails;
import model.Cart;
import model.Item;

/**
 *
 * @author loitn148
 */
public class CheckoutServlet extends HttpServlet {
    
    private final BillDAO billDAO = new BillDAO();
    private final BillDetailsDAO billDetailsDAO = new BillDetailsDAO();
    private final ProductDAO productDAO = new ProductDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String owner = request.getParameter("owner");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String payment = request.getParameter("payment");
        String note = request.getParameter("note");
        
        Cart cart = (Cart) session.getAttribute("cart");
        
        Double cartTotal = cart.totalCart();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long id = System.currentTimeMillis();
        try {
            Bill bill = new Bill(id, 1, owner, address, phone, cartTotal, payment, timestamp, note, email);
            
            for(Map.Entry<Long, Item> list: cart.getCartItem().entrySet()){
                BillDetails billDetails = new BillDetails(id, list.getValue().getProduct().getProductId(),
                                                            list.getValue().getProduct().getProductPriceSale(),
                                                            list.getValue().getQuantity());
                
                billDetailsDAO.insert(billDetails);
                productDAO.countSale(list.getValue().getProduct(), list.getValue().getQuantity());
            }
            
            billDAO.insert(bill);
            cart = new Cart();
            session.setAttribute("cart", cart);
        } catch (Exception e) {
        }
        
        response.sendRedirect("/shop/order-details/index.jsp?id=" + id);
        
    }
}
