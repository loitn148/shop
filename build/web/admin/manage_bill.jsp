<%-- 
    Document   : manage_bill
    Created on : Jun 4, 2018, 10:14:44 AM
    Author     : loitn148
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Bill</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="${root}/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Manage Bill</h3>

                    <div class="informasi">
                        ini adalah notifikasi pertanda informasi
                    </div>

                    <div class="gagal">
                        ini adalah notifikasi pertanda gagal
                    </div>

                    <div class="sukses">
                        ini adalah notifikasi pertanda sukses
                    </div>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">No</th>
                            <th class="data">Nama</th>
                            <th class="data">Email</th>
                            <th class="data">Telepon</th>
                            <th class="data" width="75px">Pilihan</th>
                        </tr>
                        <tr class="data">
                            <td class="data" width="30px">1</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data" width="75px">
                                <center>
                                    <a href="#"><img src="../images/edit.png"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="#"><img src="../images/trash.png"></a>
                                </center>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
