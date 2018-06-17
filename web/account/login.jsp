<%-- 
    Document   : login
    Created on : May 26, 2018, 12:21:17 PM
    Author     : loitn148
--%>

<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Custom Theme files -->
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <!--<script src="../js/simpleCart.min.js"> </script>-->
        <!-- Custom Theme files -->
        <!--webfont-->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <!-- start menu -->
        <link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="../js/megamenu.js"></script>
        <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
    </head>
    <body>
        <%
            Users user = (Users) session.getAttribute("user");
            if(user != null) {
                response.sendRedirect("../index.jsp");
            }
            
            String error = "";
            if(request.getParameter("error") != null) {
                error = request.getParameter("error");
            }
        %>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
        <div class="single_top">
            <div class="container"> 
                <div class="register flex-col">
                        <div class="register-content flex-col">
                            <h4>LOGIN <span style="font-size: 16px;">&</span> START SHOPPING</h4>
                            
                            <% if(error.equals("invalid")) { %>
                                <span class="error-notify">Invalid email or password.</span>
                            <% } %>
                            <form action="/shop/UsersServlet" method="post" class="form-register flex-col">
                                <input type="text" name="email" class="form-input" placeholder="Email Address"> 

                                <input type="password" name="password" class="form-input" placeholder="Password"> 
                                
                                <!--<span class="password-tip"> <a>Forgot your password?</a></span>-->    
                                
                                <input type="hidden" value="login" name="command">
                                <input type="submit" value="Login Now" name="submit-register" class="form-input btn-register">
                                
                                <span class="switch-to-login">Don't have an account? <a href="register.jsp"> Register Now </a></span> 
                            </form>
                        </div>
                    </div>
            </div>
        </div>      
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    </body>
</html>
