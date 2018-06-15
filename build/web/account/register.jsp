<%-- 
    Document   : register
    Created on : May 26, 2018, 12:21:30 PM
    Author     : loitn148
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <!--<script src="../js/simpleCart.min.js"></script>-->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <!-- start menu -->
        <link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="../js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#email").keyup(function (e) {
                    clearTimeout(x_timer);
                    var email = $(this).val();
                    x_timer = setTimeout(function () {
                        check_email_ajax(email);
                    }, 1000);
                });

                function check_email_ajax(email) {
                    $("#email-result").html('<img src="../images/ajax-loader.gif" />');
                    $.post('/shop/CheckEmailServlet', {'email': email}, function (data) {
                        $("#email-result").html(data);
                    });
                }
            });
        </script>
    </head>
    <body>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
            <div class="single_top">
                <div class="container"> 
                    <div class="register flex-col">
                        <div class="register-content flex-col">
                            <h4>REGISTER ACCOUNT</h4>
                            <form action="/shop/UsersServlet" method="post" class="form-register flex-col">
                                <div>
                                    <input type="text" name="fullname" id="fullname" class="form-input" placeholder="Full Name"> 
                                    <span class="name-notify"></span>
                                </div> 

                                <div style="position: relative;">
                                    <input type="text" name="email" id="email" class="form-input" placeholder="Email Address"> 
                                    <span id="email-result" class="validate"></span>
                                </div>

                                <div>
                                    <input type="password" name="password" id="password" class="form-input" placeholder="Password"> 
                                    <span id="password-result" class="validate"></span>
                                </div>

                                <div>
                                    <input type="password" name="confirm-password" id="confirm-password" class="form-input" placeholder="Confirm Password">
                                    <span id="password-result" class="validate"></span>
                                </div>


                                <span class="password-tip">Password should be more than 6 and less than 30 characters</span>    
                                
                                <input type="hidden" value="insert" name="command">
                                <input type="submit" value="Register" name="submit-register" class="form-input btn-register">
                                

                                <span class="switch-to-login">Already have an account? <a href="login.jsp"> Login </a></span> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>      
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    </body>
</html>
