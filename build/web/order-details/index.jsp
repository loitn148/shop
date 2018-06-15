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
                    <h1>ORDER DETAILS (ID: <%=bill.getBillID()%>)</h1>
                    <div>
                        <div class="col-md-7">
                            <table class="order-information">
                                <tr>
                                    <th colspan="2" style="font-size: 18px; color: #4d90fe">Owner infomation</th>  
                                </tr>
                                <tr>
                                    <th width="20%">Name:</th>  
                                    <td><%=bill.getOwner()%></td>  
                                </tr>
                                <tr>
                                    <th>Phone:</th>  
                                    <td><%=bill.getPhone()%></td>  
                                </tr>
                                <tr>
                                    <th>Email:</th>  
                                    <td><%=bill.getEmail()%></td>  
                                </tr>
                                <tr>
                                    <th>Address:</th>  
                                    <td><%=bill.getAddress()%></td>  
                                </tr>
                                <tr>
                                    <th>Note:</th>  
                                    <td><%=bill.getNote()%></td>  
                                </tr>
                                <tr>
                                    <th colspan="2"  style="font-size: 18px; color: #4d90fe">Payment infomation</th>  
                                </tr>
                                <% if(bill.getPayment().equals("COD") ) { %>
                                <tr>
                                    <th>Payment</th>  
                                    <td>Cash on delivery</td>  
                                </tr>
                                <% } else { %>
                                <tr>
                                    <th>Payment</th>  
                                    <td>Direct bank transfer</td>  
                                </tr>
                                <tr>
                                    <th>Bank:</th>  
                                    <td>BIDV</td>  
                                </tr>
                                <tr>
                                    <th>Branch:</th>  
                                    <td>Sai Gon East, Ho Chi Minh City</td>  
                                </tr>
                                <tr>
                                    <th>Card ID:</th>  
                                    <td>136412842194</td>  
                                </tr>
                                <tr>
                                    <th>Card Number:</th>  
                                    <td>41283513258</td>  
                                </tr>
                                <% } %>
                                
                            </table>
                            <div style="margin-top: 50px;">
                                <a href="/shop/index.jsp">Continue Shopping </a>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="order-summary">
                                <div class="order-header flex-row">
                                    <h4 style="width: 100%; text-align: left;">Order Summary</h4>
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
