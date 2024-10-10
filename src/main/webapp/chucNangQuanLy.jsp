<%@ page import="vn.edu.iuh.fit.demogk_bai7_59.entities.Danhmuc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/10/2024
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chức năng quản lý</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>


<%
    List<Danhmuc> danhSachDanhMuc = (List<Danhmuc>) session.getAttribute("chucNangQuanLy");
%>
<div class="container-dashboard">
    <h1>Danh sách danh mục</h1>
    <table>
        <thead>
        <tr>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <th>Người quản lý</th>
            <th>Ghi chú</th>
        </tr>
        </thead>
        <tbody>
        <% for (Danhmuc danhmuc : danhSachDanhMuc) { %>
        <tr>

            <td><%=danhmuc.getMadm()%>
            </td>
            <td><%=danhmuc.getTendanhmuc()%>
            </td>
            <td><%=danhmuc.getNguoiquanly()%>
            </td>
            <td><%=danhmuc.getGhichu()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>


</body>
</html>
