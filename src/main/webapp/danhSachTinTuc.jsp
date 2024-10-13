<%@ page import="vn.edu.iuh.fit.demogk_bai7_59.entities.Tintuc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/10/2024
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tin tức</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>

<%
    List<Tintuc> danhSachTinTuc = (List<Tintuc>) session.getAttribute("danhSachTinTuc");
%>
<div class="container-dashboard">
    <h1>Danh sách tin tức</h1>
    <table>
        <thead>
        <tr>
            <th>Mã tin tức</th>
            <th>Tiêu đề</th>
            <th>Nội dung tin tức</th>
            <th>Liên kết</th>
            <th>Mã danh mục</th>
        </tr>
        </thead>
        <tbody>
        <% for (Tintuc tintuc : danhSachTinTuc) { %>
        <tr>

            <td><%=tintuc.getMatt()%>
            </td>
            <td><%=tintuc.getTieude()%>
            </td>
            <td><%=tintuc.getNoidungtt()%>
            </td>
            <td><%=tintuc.getLienket()%>
            </td>
            <td><%=tintuc.getMadm().getMadm()%>
            </td>
            <td><a href="action?action=deleteTinTuc&MATT=<%=tintuc.getMatt()%>">Delete</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>

</body>
</html>
