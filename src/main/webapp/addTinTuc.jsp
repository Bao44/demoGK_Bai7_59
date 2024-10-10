<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/10/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm tin tức</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<div class="form">
    <h1>Nhập thông tin tin tức mới</h1>
    <form action="action?action=addTinTuc" method="post">
        <label>Mã tin tức:</label>
        <input type="text" name="MATT" placeholder="Nhập mã tin tức"/><br>
        <label>Tiêu đề:</label>
        <input type="text" name="TIEUDE" placeholder="Nhập tiêu đề"/><br>
        <label>Nội dung:</label>
        <input type="text" name="NOIDUNGTT" placeholder="Nhập nội dung tin tức"/><br>
        <label>Liên kết:</label>
        <input type="text" name="LIENKET" placeholder="Nhập liên kết"/><br>
        <label>Mã danh mục:</label>
        <input type="text" name="MADM" placeholder="Nhập mã danh mục"/><br>
        <button type="submit" class="addBtn"> Thêm tin tức </button>
    </form>
</div>
</body>
</html>
