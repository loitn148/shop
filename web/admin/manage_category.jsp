<%-- 
    Document   : manage_category
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
        <title>Manage Category</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="${root}/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <%
            CategoryDAO catDAO = new CategoryDAO();
            ArrayList<Category> listCategory = catDAO.getAllListCategory();
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Manage Category</h3>

                    <a href="${root}/admin/form_category.jsp" class="insert-new"><input type="button" value="Add Category"></a>
                    <div class="clear"></div>
                    
                    <table class="data">    
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Category ID</th>
                            <th class="data">Name</th>
                            <th class="data">Slug</th>
                            <th class="data">Parent ID</th>
                            <th class="data">Action</th>
                        </tr>
                        <% int stt = 1; %>
                        <% for(Category cat : listCategory) { %>
                        <tr class="data">
                            <td class="data" width="30px"><%=stt++%></td>
                            <td class="data"><%=cat.getCatId()%></td>
                            <td class="data"><%=cat.getCatName()%></td>
                            <td class="data"><%=cat.getSlug()%></td>
                            <td class="data"><%= cat.getCatParentId() != 0 ? cat.getCatParentId() : "" %></td>
                            <td class="data" width="75px">
                                <center>
                                    <a href="${root}/admin/form_category.jsp?category=<%=cat.getCatId()%>"><img src="../images/edit.png"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="/shop/ManageCategoryServlet?command=delete&category_id=<%=cat.getCatId()%>"><img src="../images/trash.png"></a>
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
