/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsersDAO;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loitn148
 */
public class CheckEmailServlet extends HttpServlet {

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
        String command = request.getParameter("command");
        switch (command) {
            case "email":
                String email = request.getParameter("email");
                if(email.equals("")) {
                    response.getWriter().write("Email can't not be empty.");
                } else if(!validate(email)) {
                    response.getWriter().write("Email format is incorrect.");
                } else if (usersDAO.checkExistEmail(email)) {
                    response.getWriter().write("Email already used.");
                }
                break;
            case "password":
                if(request.getParameter("password").equals("")) {
                    response.getWriter().write("Password can't not be empty.");
                } else if(!usersDAO.checkPassword(request.getParameter("password"))){
                    response.getWriter().write("Password length is incorrect."); 
                }
                break;
            case "repassword":
                if(request.getParameter("repassword").equals("")) {
                    response.getWriter().write("Confirm-Password can't not be empty.");
                } else if(!usersDAO.checkRePassword(request.getParameter("password"), request.getParameter("repassword"))) {
                    response.getWriter().write("Confirm-password is incorrect.");
                }
                break;
            case "name":
                if(request.getParameter("name").equals("")){
                    response.getWriter().write("Name can't not be empty.");
                }
                break;
        }

    }

}
