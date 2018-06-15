<%-- 
    Document   : header
    Created on : May 13, 2018, 12:52:16 PM
    Author     : loitn148
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <% 
            CategoryDAO catDAO = new CategoryDAO();
            
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <div class="header_top">
            <div class="container">
                <div class="cssmenu">
                    <ul>
                        <li class="active"><a href="login.html">My Account</a></li> 
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="wrap-box"></div>
        
        <div class="header_bottom">
	    <div class="container">
                <div class="col-xs-8 header-bottom-left">
                    <div class="col-xs-3 logo">
                        <h1><a href="../index.jsp"><span>Ann</span>Cosmetics</a></h1>
                    </div>
                    <div class="col-xs-5 menu">
                        <ul class="megamenu skyblue">
                            <li class="showhide" style="display: none;">
                                <span class="title">MENU</span>
                                <span class="icon1"></span>
                                <span class="icon2"></span>
                            </li>
                            <% for(Category list : catDAO.getListCategory()) { %>
                                <li class="active grid" style="display: inline;">
                                    <a class="color-main-hover item-megamenu" href="/shop/category/index.jsp?slug=<%=list.getSlug()%>"><%=list.getCatName()%></a>
                                    <% 
                                        ArrayList<Category> listChild = catDAO.getChildListCategory(list.getCatId());
                                        if(!listChild.isEmpty()) { 
                                    %>
                                    <div class="megapanel">
                                        <div class="row">
                                            <div class="h_nav">
                                                <ul>
                                                    <% for(Category list_child : listChild) { %>
                                                        <li><a href="/shop/category/index.jsp?slug=<%=list_child.getSlug()%>"><%=list_child.getCatName()%></a></li>
                                                    <% } %>
                                                </ul>	
                                            </div>
                                        </div>
                                    </div>
                                    <% } %>
                                </li>
                            <% } %>
                            <li class="active grid" style="display: inline;">
                                <a class="color-main-hover item-megamenu" href="/shop/shop/index.jsp">SHOP</a>
                            </li>
                        </ul> 
                    </div>
		</div>
                <div class="col-xs-4 header-bottom-right">
                    <div class="search flex-row">	  
                        <input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
                        <input type="submit" value="Subscribe" id="submit" name="submit">
                        <div id="response"> </div>
                    </div>
                    <div class="box_1-cart flex-row">
                        <div class="box_11">
                            <a href="/shop/cart/index.jsp">
                                <h4>
                                    <p>Cart: <span class="simpleCart_total"><%= "$"+cart.totalCart()%></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"><%=cart.countItem()%></span> items)</p>
                                    <img src="/shop/images/bag.png" alt="">
                                    <div class="clearfix"> </div>
                                </h4>
                            </a>
                        </div>
<!--                        <p class="empty"><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
                        <div class="clearfix"> </div>-->
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>    
    </body>
</html>
