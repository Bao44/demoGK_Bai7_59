package vn.edu.iuh.fit.demogk_bai7_59.dao;

import vn.edu.iuh.fit.demogk_bai7_59.connection.ConnectDB;
import vn.edu.iuh.fit.demogk_bai7_59.entities.Danhmuc;
import vn.edu.iuh.fit.demogk_bai7_59.entities.Tintuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TinTucDAO {
    public List<Tintuc> getAll() throws SQLException, ClassNotFoundException {
        List<Tintuc> list = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM tintuc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maTin = resultSet.getString("MATT");
            String tieuDe = resultSet.getString("TIEUDE");
            String noiDung = resultSet.getString("NOIDUNGTT");
            String lienKet = resultSet.getString("LIENKET");
            String maDM = resultSet.getString("MADM");
            Tintuc tintuc = new Tintuc(maTin, tieuDe, noiDung, lienKet, new Danhmuc(maDM));
            list.add(tintuc);
        }
        return list;
    }

    public Tintuc findById(String maTin) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM tintuc WHERE MATT = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, maTin);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String maTin1 = resultSet.getString("MATT");
            String tieuDe = resultSet.getString("TIEUDE");
            String noiDung = resultSet.getString("NOIDUNGTT");
            String lienKet = resultSet.getString("LIENKET");
            String maDM = resultSet.getString("MADM");
            Tintuc tintuc = new Tintuc(maTin1, tieuDe, noiDung, lienKet, new Danhmuc(maDM));
            return tintuc;
        }
        return null;
    }

    public boolean addTinTuc(Tintuc tintuc) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "INSERT INTO tintuc(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tintuc.getMatt());
        preparedStatement.setString(2, tintuc.getTieude());
        preparedStatement.setString(3, tintuc.getNoidungtt());
        preparedStatement.setString(4, tintuc.getLienket());
        preparedStatement.setString(5, tintuc.getMadm().getMadm());
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTinTuc(String maTin) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "DELETE FROM tintuc WHERE MATT = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, maTin);
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
