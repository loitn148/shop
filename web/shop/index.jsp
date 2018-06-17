<%-- 
    Document   : index
    Created on : May 26, 2018, 12:40:39 PM
    Author     : loitn148
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shop</title>
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
        <script type="text/javascript" src="../js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" id="sourcecode">
            $(function () {
                $('.scroll-pane').jScrollPane();
            });
        </script>
    </head>
    
        <%
            ProductDAO prodDAO = new ProductDAO();
            ArrayList<Product> listProd = prodDAO.getListProduct();
            
            NumberFormat nf = NumberFormat.getInstance();
        %>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
            <div class="container">
                <div class="women_main row">
                    <div class="col-md-9">
                        <div class="w_content">
                            <div class="women">
                                <a href="#"><h4><%=listProd.size()%> products </h4></a>
                                <ul class="w_nav">
                                    <li>Sort : </li>
                                    <li><a class="active" href="#">popular</a></li> |
                                    <li><a href="#">new </a></li> |
                                    <li><a href="#">discount</a></li> |
                                    <li><a href="#">price: Low High </a></li> 
                                    <div class="clear"></div>
                                </ul>
                                <div class="clearfix"></div>	
                            </div>
                            <!-- grids_of_4 -->
                            <div class="row list-product">
                                <% for (Product prod : listProd) { %>
                                
                                <div class="grid1_of_4 simpleCart_shelfItem">
                                    <div class="content_box">
                                        <a href="../product/index.jsp?slug=<%=prod.getProductSlug()%>">
                                            <div class="view view-fifth flex-col">
                                                <img src="<%=prod.getProductImage()%>" class="img-responsive" alt="<%=prod.getProductName()%>"/>
                                            </div>
                                        </a>
                                    </div>
                                    <h5><a class="product-name" href="../product/index.jsp?slug=<%=prod.getProductSlug()%>"><%=prod.getProductName()%></a></h5>
                                    <div class="size_1">
                                        <%
                                            if(prod.getProductDiscount() != 0) {
                                        %>
                                            <span class="item_price_original"><%="$"+prod.getProductPrice()%></span>
                                            <span class="item_price"><%="$"+prod.getProductPriceSale()%></span>
                                        <% } else { %>
                                            <span class="item_price"><%="$"+prod.getProductPrice()%></span>
                                        <% } %>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="size_2">
                                        <a href="/shop/CartServlet?command=plus&productId=<%=prod.getProductId()%>" class="add-to-cart" value="">
                                            <img src="/shop/images/cart.png"/>
                                            Add to Cart
                                        </a>
                                    </div>
                                </div>
                                
                                <% } %>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                    <jsp:include page="../webmaster/sidebar.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    
</html>
