package vn.edu.iuh.fit.demogk_bai7_59.dao;

import vn.edu.iuh.fit.demogk_bai7_59.connection.ConnectDB;
import vn.edu.iuh.fit.demogk_bai7_59.entities.Danhmuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    public List<Danhmuc> getAll() throws SQLException, ClassNotFoundException {
        List<Danhmuc> list = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM danhmuc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maDM = resultSet.getString("MADM");
            String tenDanhMuc = resultSet.getString("TENDANHMUC");
            String nguoiQuanLy = resultSet.getString("NGUOIQUANLY");
            String ghiChu = resultSet.getString("GHICHU");
            Danhmuc danhmuc = new Danhmuc(maDM, tenDanhMuc, nguoiQuanLy, ghiChu);
            list.add(danhmuc);
        }
        return list;
    }
}
