<%-- 
    Document   : content
    Created on : May 13, 2018, 3:09:17 PM
    Author     : loitn148
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Product> listBestSell = productDAO.getListProductOrderBy("bestsale");
            ArrayList<Product> listNew = productDAO.getListProductOrderBy("new");
        %>
        <div class="">
            <div class="content_top">
                <h3 class="m_1">New Products</h3>
                <div class="container">
                    <div class="box_1">
                        <div class="col-md-7">
                            <div class="section group">
                                <% for (Product p_new : listNew) {%>
                                <div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
                                    <div class="shop-holder">
                                        <div class="product-img flex-col">
                                            <a href="/shop/product/index.jsp?slug=<%=p_new.getProductSlug()%>">
                                                <img src="<%=p_new.getProductImage()%>" class="img-responsive"  alt="<%=p_new.getProductName()%>">
                                            </a>
                                            <a href="/shop/CartServlet?command=plus&productId=<%=p_new.getProductId()%>" class="button item_add"></a>
                                        </div>
                                    </div>
                                    <div class="shop-content" style="height: 80px; margin-top: 20px;">
                                        <h3>
                                            <a href="/shop/product/index.jsp?slug=<%=p_new.getProductSlug()%>"><%=p_new.getProductName()%></a>
                                        </h3>
                                        <%
                                            if (p_new.getProductDiscount() != 0) {
                                        %>
                                        <span class="amount item_price_original"><%="$" + p_new.getProductPrice()%></span>
                                        <span class="amount item_price"><%="$" + p_new.getProductPriceSale()%></span>
                                        <% } else {%>
                                        <span class="amount item_price"><%="$" + p_new.getProductPrice()%></span>
                                        <% } %>
                                    </div>
                                </div>
                                <% } %>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="col-md-5 row_3">
                            <div class="about-block-content">
                                <div class="border-add"></div>
                                <h4>About Us</h4>
                                <p>AnnCosmetics provide products of cosmetics such as skin care, lipstick, fragrance, ...</p>
                                <p>We believe that beauty is the desire of many people and the selection of a good, appropriate cosmetics is also a difficult thing for a lot of people. Our mission is to help you make the best choice for pocket money and quality products.</p>
                                <p></p>
                            </div>
                            <img src="/shop/images/under_aboutus.jpg" class="img-responsive" alt=""/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            <div class="banner-middle">
                <img src="/shop/images/sub_banner.jpg" class="sub_banner">
                <div class="container">
                    <div class="banner_desc">
                        <h3 style="color: #55a8e1; font-size: 60px; font-weight: 300;">Neutrogena </h3>
                        <h3 style="color: #55a8e1; font-size: 50px; font-weight: 300;">Hydro Boost</h3>
                        <h3 style="color: #ccc; font-weight: 300;">Get visibly younger skin in just one week.</h3>
                        <div class="button">
                            <a href="/shop/product/index.jsp?slug=neutrogena-hydro-boost-hyaluronic-acid-hydrating-face-moisturizer-gel-cream-to-hydrate-and-smooth-extra-dry-skin-1-7-oz"
                               class="view-product">View Product</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content_bottom" style="background: #f5f5f5">
                <h2 class="m_3">Best Sell Products</h2>
                <div class="container">
                    <% for (Product p_bestsell : listBestSell) {%>
                    <div class="col_1_of_4 span_1_of_4 simpleCart_shelfItem">
                        <div class="shop-holder">
                            <div class="product-img flex-col">
                                <a href="/shop/product/index.jsp?slug=<%=p_bestsell.getProductSlug()%>">
                                    <img src="<%=p_bestsell.getProductImage()%>" class="img-responsive"  alt="<%=p_bestsell.getProductName()%>">
                                </a>
                                <a href="/shop/CartServlet?command=plus&productId=<%=p_bestsell.getProductId()%>" class="button item_add"></a>
                            </div>
                        </div>
                        <div class="shop-content" style="height: 80px; margin-top: 20px;">
                            <h3>
                                <a href="/shop/product/index.jsp?slug=<%=p_bestsell.getProductSlug()%>"><%=p_bestsell.getProductName()%></a>
                            </h3>
                            <%
                                if (p_bestsell.getProductDiscount() != 0) {
                            %>
                            <span class="amount item_price_original"><%="$" + p_bestsell.getProductPrice()%></span>
                            <span class="amount item_price"><%="$" + p_bestsell.getProductPriceSale()%></span>
                            <% } else {%>
                            <span class="amount item_price"><%="$" + p_bestsell.getProductPrice()%></span>
                            <% } %>
                        </div>
                    </div>
                    <% }%>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </body>
</html>
