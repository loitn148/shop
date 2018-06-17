<%-- 
    Document   : index
    Created on : May 26, 2018, 4:13:16 PM
    Author     : loitn148
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="model.Product"%>
<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Custom Theme files -->
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <!--<script src="../js/simpleCart.min.js"></script>-->
        <!-- Custom Theme files -->
        <!--webfont-->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <!-- start menu -->
        <link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="../js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
    </head>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            NumberFormat nf = NumberFormat.getInstance();
        %>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
            <div class="container">
                <div class="check row">	 
                <% if (cart.getCartItem().size() == 0) { %>
                <h1 style="font-size: 1.5em; margin-bottom: 2em;">Shopping Cart (0)</h1>
                <div class="content flex-col">
                    <img src="../images/empty-cart.png">
                    <a href="/shop/shop/index.jsp" class="continue-shopping">
                        Go Shop Now
                    </a>
                </div>
                <% } else {%>
                <h1>Shopping Cart (<%=cart.countItem()%>)</h1>
                <div class="col-md-9 cart-items">

                    <table class="table cart-table">
                        <thead>
                        <th width="5%"></th>
                        <th width="20%">Image</th>
                        <th width="25%">Product</th>
                        <th width="15%">Item Price</th>
                        <th width="20%">Quantity</th>
                        <th width="15%">Price</th>
                        </thead>
                        <tbody>
                            <% for (Map.Entry<Long, Item> list : cart.getCartItem().entrySet()) { %>
                            <% Product product = list.getValue().getProduct();%>
                            <tr>
                                <td>
                                    <a href="/shop/CartServlet?command=delete&productId=<%=product.getProductId()%>">
                                        <div class="close"> </div>
                                    </a>
                                </td>
                                <td>
                                    <a href="/shop/product/index.jsp?slug=<%=product.getProductSlug()%>">
                                        <img src="<%=product.getProductImage()%>" class="img-responsive" alt=""/>
                                    </a>
                                </td>
                                <td>
                                    <h4><a href="/shop/product/index.jsp?slug=<%=product.getProductSlug()%>"><%=product.getProductName()%></a></h4>
                                </td>
                                <td>
                                    <%="$"+product.getProductPriceSale()%>
                                </td>
                                <td>
                                    <form action="/shop/CartServlet?command=update&productId=<%=product.getProductId()%>" method="post">
                                        <input type="number" value="<%=list.getValue().getQuantity()%>" min="1" class="choose-qty" name="quantity">
                                        <input type="submit" class="btn-update-qty" value="Update">
                                    </form>
                                </td>
                                <td>
                                    <%= "$"+ product.getProductPriceSale() * list.getValue().getQuantity()%>
                                </td>
                            </tr>
                            <% }%>	
                        </tbody>
                    </table>
                    <div style="margin-top: 50px;">
                        <a href="/shop/index.jsp">Continue Shopping </a>
                    </div>
                </div>
                <div class="col-md-3 cart-total flex-col">
                    <div class="price-details">
                        <h3 style="font-weight: 600">
                            Order Summary: <span style="color: #f56e4d"><%="  $"+cart.totalCart()%></span>
                        </h3>
                    </div>
                    <a class="order" href="/shop/checkout/index.jsp">Proceed to Checkout</a>
                </div>
                <% }%>
            </div>
        </div>
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    </body>
</html>
