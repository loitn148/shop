/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsersDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;
import tools.md5;

/**
 *
 * @author loitn148
 */
public class UsersServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String command = request.getParameter("command");
            
            switch(command) {
                case "insert":
                    String email = request.getParameter("email");
                    String name = request.getParameter("fullname");
                    String password = request.getParameter("password");
                    String confirm_password = request.getParameter("confirm-password");
                    
                    if(email.equals("") || name.equals("") || password.equals("") || confirm_password.equals("")
                            || !validate(email) || !password.equals(confirm_password) || password.length() < 6 || password.length() > 30) {
                        response.sendRedirect("/shop/account/register.jsp");
                    } else {
                        String md5_pass = md5.encryption(password);
                        String token = "a";
                        Users user = new Users(email, md5_pass, name, token);
                        usersDAO.insert(user);
                        
                        session.setAttribute("user", user);
                        
                        response.sendRedirect("/shop/index.jsp");
                    }
                    break;
                case "update":
                    break;
                case "login":
                    String log_email = request.getParameter("email");
                    String log_password = md5.encryption(request.getParameter("password"));
                    Users log_user = usersDAO.login(log_email, log_password);
                    if(log_user.getId() == 0) {
                        response.sendRedirect("/shop/account/login.jsp?error=invalid");
                    } else {
                        session.setAttribute("user", log_user);
                        response.sendRedirect("/shop/index.jsp");
                    }
                    break;
                case "logout":
                    session.invalidate();
                    response.sendRedirect("/shop/index.jsp");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
