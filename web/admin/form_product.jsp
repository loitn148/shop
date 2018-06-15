<%-- 
    Document   : form_product
    Created on : Jun 4, 2018, 10:14:44 AM
    Author     : loitn148
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Product</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="${root}/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <%
            CategoryDAO catDAO = new CategoryDAO();
            ArrayList<Category> listCategory = catDAO.getAllListCategory();
            
            ProductDAO prodDAO = new ProductDAO();
            
            String prod_id = request.getParameter("product") != null ? request.getParameter("product") : "";
            
            Product product = prod_id.equals("") ? new Product() : prodDAO.getProduct(Long.parseLong(prod_id));
            
            String error = request.getParameter("error") != null ? request.getParameter("error") : "";
            
            DecimalFormat df = new DecimalFormat("###");
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Add Category</h3>
<!--                    <form method="post" action="UploadIamgesServlet" enctype="multipart/form-data">
                        Select file to upload:
                        <input type="file" name="uploadFile" />
                        <br/><br/>
                        <input type="submit" value="Upload" />
                    </form>-->
                    <form action="/shop/ManageProductServlet" method="post">
                        <table width="95%">
                            <tr><td><b>Image</b></td><td>
                                    <input type="file" name="prodImage" accept="image/*">
                                </td></tr>
                            <tr><td><b>Product Name</b></td><td>
                                    <input type="text" class="panjang" name="prodName" value="<%= product.getProductName() != null ? product.getProductName() : ""%>">
                                </td></tr>
                            <tr><td><b>Slug</b></td><td>
                                    <input type="text" class="panjang" name="prodSlug" value="<%=product.getProductSlug() != null ? product.getProductSlug() : ""%>">
                                </td></tr>
                            <tr><td><b>Price ($)</b></td><td>
                                    <input type="number" class="panjang" name="prodPrice" value="<%=product.getProductPrice() != 0 ? df.format(product.getProductPrice()) : ""%>">
                                </td></tr>
                            <tr><td><b>Discount (%)</b></td><td>
                                    <input type="number" class="panjang" name="prodDiscount" value="<%=product.getProductDiscount() != 0 ? df.format(product.getProductDiscount()) : ""%>">
                                </td></tr>
                            <tr><td><b>Description</b></td><td>
                                    <textarea name="prodDescription"><%=product.getProductDescription() != null ? product.getProductDescription() : ""%></textarea>
                                </td></tr>
                            <tr><td><b>Category</b></td><td>
                                    <select name="catId">
                                        <option value="">-- None --</option>
                                        <% for(Category cat : listCategory) { %>
                                            <option value="<%=cat.getCatId()%>" <%= cat.getCatId() == product.getCategoryId() ? "selected" : null %>><%=cat.getCatName()%></option>
                                        <% } %>
                                    </select>
                                </td></tr>
                            <tr><td></td><td>
                                <%=error%>
                                </td></tr>
                            <tr><td></td><td>
                                    <% if(prod_id.length() == 0) { %>
                                        <input type="hidden" name="command" value="insert">
                                    <% } else { %>
                                        <input type="hidden" name="command" value="update">
                                        <input type="hidden" name="product_id" value="<%=prod_id%>">
                                    <% } %>
                                    
                                    <input type="submit" class="button" value="Submit">
                                    <input type="reset" class="button" value="Reset">
                                </td></tr>
                        </table>
                    </form>
                </div>
                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
