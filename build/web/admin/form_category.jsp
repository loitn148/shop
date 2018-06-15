<%-- 
    Document   : form_category
    Created on : Jun 4, 2018, 10:14:44 AM
    Author     : loitn148
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Category</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="${root}/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <%
            CategoryDAO catDAO = new CategoryDAO();
            ArrayList<Category> listCategory = catDAO.getAllListCategory();
            
            String cat_id = request.getParameter("category") != null ? request.getParameter("category") : "";
            
            Category category = cat_id.equals("") ? new Category() : catDAO.getCategory(Long.parseLong(cat_id));
            
            String error = request.getParameter("error") != null ? request.getParameter("error") : "";
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Add Category</h3>
                    <form action="/shop/ManageCategoryServlet" method="post">
                        <table width="95%">
                            <tr><td><b>Category Name</b></td><td>
                                    <input type="text" class="panjang" name="catName" value="<%=category.getCatName() != null ? category.getCatName() : "" %>">
                                </td></tr>
                            <tr><td><b>Slug</b></td><td>
                                    <input type="text" class="panjang" name="catSlug" value="<%=category.getSlug() != null ? category.getSlug() : "" %>">
                                </td></tr>
                            <tr><td><b>Parent</b></td><td>
                                    <select name="catParent">
                                        <option value="">-- None --</option>
                                        <% for(Category cat : listCategory) { %>
                                            <option value="<%=cat.getCatId()%>" <%= cat.getCatId() == category.getCatParentId() ? "selected" : null %>><%=cat.getCatName()%></option>
                                        <% } %>
                                    </select>
                                </td></tr>
                            <tr><td></td><td>
                                <%=error%>
                                </td></tr>
                            <tr><td></td><td>
                                    <% if(cat_id.length() == 0) { %>
                                        <input type="hidden" name="command" value="insert">
                                    <% } else { %>
                                        <input type="hidden" name="command" value="update">
                                        <input type="hidden" name="category_id" value="<%=cat_id%>">
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
