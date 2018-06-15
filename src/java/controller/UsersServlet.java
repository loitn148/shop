/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsersDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;
import tools.md5;

/**
 *
 * @author loitn148
 */
public class UsersServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "";
        
        switch(command) {
            case "insert":
                String email = request.getParameter("email");
                String name = request.getParameter("fullname");
                String password = request.getParameter("password");
                String md5_pass = md5.encryption(password);
                String confirm_password = request.getParameter("confirm-password");
                String token = "a";
                
                usersDAO.insert(new Users(email, md5_pass, name, token));
                
        }
        
    }

}
