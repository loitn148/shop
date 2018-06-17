<%-- 
    Document   : index
    Created on : May 26, 2018, 3:54:27 PM
    Author     : loitn148
--%>

<%@page import="model.Cart"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProductGalleryDAO"%>
<%@page import="model.ProductGallery"%>
<%@page import="model.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
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
        <link rel="stylesheet" href="../css/etalage.css">
        <script src="../js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {
                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
        <!--initiate accordion-->
        <script type="text/javascript">
            $(function () {
                var menu_ul = $('.menu_drop > li > ul'),
                        menu_a = $('.menu_drop > li > a');

                menu_ul.hide();

                menu_a.click(function (e) {
                    e.preventDefault();
                    if (!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true, true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true, true).slideUp('normal');
                    }
                });

            });
        </script>
    </head>
    <body>
        <%
            String prod_slug = "";
            if (request.getParameter("slug") != null) {
                prod_slug = request.getParameter("slug");
            }
            ProductDAO prodDAO = new ProductDAO();
            Product product = prodDAO.getProduct(prod_slug);
            ArrayList<Product> listRelated = prodDAO.getListProductByCategory(product.getCategoryId());

            ProductGalleryDAO galleryDAO = new ProductGalleryDAO();
            ArrayList<ProductGallery> listGallery = galleryDAO.getListGallery(prod_slug);

            NumberFormat nf = NumberFormat.getInstance();

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
            <div class="container">
                <div class="women_main row">
                    <div class="col-md-9">
                        <div class="single_top">
                            <div class="container" style="width: 100% !important;"> 
                                <div class="single_grid">
                                    <div class="grid images_3_of_2">
                                        <ul id="etalage">
                                            <li>
                                                <a href="">
                                                    <img class="etalage_thumb_image" src="<%=product.getProductImage()%>" class="img-responsive" />
                                                    <img class="etalage_source_image" src="<%=product.getProductImage()%>" class="img-responsive" title="" />
                                                </a>
                                            </li>
                                            <% for (ProductGallery gallery : listGallery) {%>
                                            <li>
                                                <img class="etalage_thumb_image" src="<%=gallery.getImageGallery()%>" class="img-responsive" />
                                                <img class="etalage_source_image" src="<%=gallery.getImageGallery()%>" class="img-responsive" title="" />
                                            </li>
                                            <% }%>
                                        </ul>
                                        <div class="clearfix"></div>		
                                    </div> 
                                    <div class="desc1 span_3_of_2">
                                        <h2><%=product.getProductName()%></h2>
                                        <div class="price_single">
                                                <h3>
                                                    <%
                                                        if (product.getProductDiscount() != 0) {
                                                    %>
                                                    <span class="item_price_original" style="margin-right: 10px;"><%="$" + product.getProductPrice()%></span>
                                                    <span class="amount item_price"><%="$" + product.getProductPriceSale()%></span>
                                                    <% } else {%>
                                                    <span class="amount item_price"><%="$" + product.getProductPrice()%></span>
                                                    <% }%>
                                                </h3>
                                            </div>
                                        
                                        <div class="simpleCart_shelfItem" style="border-top: 1px solid rgb(208, 208, 208); margin-top: 20px;">
                                            <div style="color: #717476; font-weight: 300; line-height: 1.3em; font-size: 1.3em; margin: 1em 0;"><%=product.getProductDescription()%></div>
                                            <!--<div class="single_but"><a href="" class="item_add btn_3" value=""></a></div>-->
                                            
                                        </div>
                                        <div class="flex-row" style="border-top: 1px solid rgb(208, 208, 208); margin-top: 20px; justify-content: left;">
                                            <input type="number" min="1" name="quantity" id="quantity" value="1">
                                            <div class="size_2-right">
                                                <a href="/shop/CartServlet?command=plus&productId=<%=product.getProductId()%>" class="item_add item_add1 btn_5" value="">
                                                    <img src="../images/cart-3.png"  style="margin-right: 5px;"/>
                                                    Add to Cart
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="single_social_top">   
                                    <ul class="single_social">
                                        <li><a href="#"> <i class="s_fb"> </i> <div class="social_desc">Share<br> on facebook</div><div class="clearfix"> </div></a></li>
                                        <li><a href="#"> <i class="s_twt"> </i> <div class="social_desc">Tweet<br> this product</div><div class="clearfix"> </div></a></li>
                                        <li><a href="#"> <i class="s_google"> </i><div class="social_desc">Google+<br> this product</div><div class="clearfix"> </div></a></li>
                                    </ul>
                                </div>
                            </div>
                            <h3 class="m_2">Related Products</h3>
                            <div class="container" style="width: 100% !important;">
                                <div class="box_3">
                                    <% int limit = 0; %>
                                    <% for (Product pRelated : listRelated) { %>
                                    <% if (limit < 4) {%>
                                    <div class="grid1_of_4 simpleCart_shelfItem">
                                        <div class="content_box">
                                            <a href="../product/index.jsp?slug=<%=pRelated.getProductSlug()%>">
                                                <div class="view view-fifth">
                                                    <img src="<%=pRelated.getProductImage()%>" class="img-responsive" alt=""/>
                                                </div>
                                            </a>
                                        </div>
                                        <h5><a class="product-name" href="../product/index.jsp?slug=<%=pRelated.getProductSlug()%>"><%=pRelated.getProductName()%></a></h5>
                                        <div class="size_1">
                                            <%
                                                if (pRelated.getProductDiscount() != 0) {
                                            %>
                                            <span class="item_price_original"><%="$" + pRelated.getProductPrice()%></span>
                                            <span class="item_price"><%="$" + pRelated.getProductPriceSale()%></span>
                                            <% } else {%>
                                            <span class="item_price"><%="$" + pRelated.getProductPrice()%></span>
                                            <% } %>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="size_2">
                                            <input type="number" class="item_quantity quantity_1" value="1" min="1"/>
                                            <input type="button" class="item_add add3" value="" />
                                        </div>
                                    </div>
                                    <% } %>
                                    <% limit++; %>
                                    <% }%>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <jsp:include page="../webmaster/sidebar.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    </body>
</html>
