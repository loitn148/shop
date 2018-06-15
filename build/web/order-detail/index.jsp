<%-- 
    Document   : index.jsp
    Created on : Jun 11, 2018, 3:19:39 PM
    Author     : loitn148
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BillDetails"%>
<%@page import="model.Bill"%>
<%@page import="DAO.BillDetailsDAO"%>
<%@page import="DAO.BillDAO"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Details</title>
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
    </head>
    <body>
        <%
            BillDAO billDAO = new BillDAO();
            BillDetailsDAO billDetailsDAO = new BillDetailsDAO();
            ProductDAO productDAO = new ProductDAO();
            
            String id = request.getParameter("id");
            
            Bill bill = billDAO.getBill(Long.parseLong(id));
            
            ArrayList<BillDetails> billDetails = billDetailsDAO.getBillDetails(Long.parseLong(id));

        %>
        <jsp:include page="../webmaster/header.jsp"></jsp:include>
            <div class="container"> 
                <div class="check row">
                    <h1>Checkout</h1>
                    <div>
                        <div class="col-md-7">
                            <form action="/shop/CheckoutServlet" method="post" class="form-order"> 
                                <label for="owner">Full Name</label>
                                <input type="text" name="owner" value="" class="order-input">

                                <label for="phone">Phone Number</label>
                                <input type="text" name="phone" value="" class="order-input">
                                
                                <label for="email">Email</label>
                                <input type="text" name="email" value="" class="order-input">

                                <label for="address">Address</label>
                                <input type="text" name="address" value="" class="order-input">

                                <label for="payment">Payment</label>
                                <select name="payment" class="order-input">
                                    <option value="cod">Cash on delivery</option>
                                    <option value="basc">Direct bank transfer</option>
                                </select>
                                <label for="note">Note</label>
                                <textarea name="note" class="order-input" rows="5"></textarea>
                                
                                <input type="submit" name="submit-bill" class="btn-submit-bill" value="Place Order">
                            </form>
                        </div>

                        <div class="col-md-5">
                            <div class="order-summary">
                                <div class="order-header flex-row">
                                    <h4 style="width: 60%; text-align: left;">Order Summary</h4>
                                    <a href="/shop/cart/index.jsp" style="width: 40%; text-align: right;"> Edit Cart </a>
                                </div>
                                <div class="order-details">
                                    <table >
                                        <% for (BillDetails item : billDetails) { %>
                                        <% Product product = productDAO.getProduct(item.getProductID());%>

                                        <tr style="padding: 10px 0">
                                            <td width="30%" style="text-align: center">
                                                <img src="<%=product.getProductImage()%>" class="img-responsive" alt=""/>
                                            </td>
                                            <td style="padding-right: 10px;">
                                                <h4><%=item.getQuantity() + " x " + product.getProductName()%></h4>
                                            </td>
                                            <td>
                                                <h4><%= "$"+ item.getPrice() * item.getQuantity()%></h4>
                                            </td>
                                        </tr>
                                        <% }%>	
                                    </table>
                                </div>
                                <div class="order-total flex-row">
                                    <h4 style="width: 40%; text-align: left;">Total (USD)</h4>
                                    <h2 style="width: 60%; text-align: right; font-weight: 600"><%="$"+bill.getTotal()%></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="../webmaster/footer.jsp"></jsp:include>
    </body>
</html>
