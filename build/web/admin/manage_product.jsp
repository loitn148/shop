<%-- 
    Document   : manage_product
    Created on : Jun 4, 2018, 10:14:44 AM
    Author     : loitn148
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="${root}/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <%
            ProductDAO prodDAO = new ProductDAO();
            ArrayList<Product> listProduct = prodDAO.getListProduct();
            
            NumberFormat nf = NumberFormat.getInstance();
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Manage Product</h3>

                    <a href="${root}/admin/form_product.jsp" class="insert-new"><input type="button" value="Add Product"></a>
                    <div class="clear"></div>
                    
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data" width="80px">Image</th>
                            <th class="data">Name</th>
                            <th class="data">Price</th>
                            <th class="data">Discount</th>
                            <th class="data" width="75px">Action</th>
                        </tr>
                        <% int stt = 1; %>
                        <% for(Product prod : listProduct) { %>
                        <tr class="data">
                            <td class="data" width="30px"><%=stt++%></td>
                            <td class="data">
                                <img src="<%=prod.getProductImage()%>">
                            </td>
                            <td class="data"><%=prod.getProductName()%></td>
                            <td class="data"><%=nf.format(prod.getProductPrice())%></td>
                            <td class="data">
                                <%=nf.format(prod.getProductDiscount()) + 
                                    "% - " + 
                                    nf.format((prod.getProductPrice() - prod.getProductPrice()*prod.getProductDiscount()/100))
                                %>
                            </td>
                            <td class="data" width="75px">
                                <center>
                                    <a href="${root}/admin/form_product.jsp?product=<%=prod.getProductId()%>"><img src="../images/edit.png"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="/shop/ManageProductServlet?command=delete&product_id=<%=prod.getProductId()%>"><img src="../images/trash.png"></a>
                                </center>
                            </td>
                        </tr>
                        <% } %>
                    </table>
                </div>
                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
