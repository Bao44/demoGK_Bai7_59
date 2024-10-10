package vn.edu.iuh.fit.demogk_bai7_59.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.demogk_bai7_59.dao.DanhMucDAO;
import vn.edu.iuh.fit.demogk_bai7_59.dao.TinTucDAO;
import vn.edu.iuh.fit.demogk_bai7_59.entities.Danhmuc;
import vn.edu.iuh.fit.demogk_bai7_59.entities.Tintuc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/action")
public class DanhSachTinTucServlet extends HttpServlet {
    private TinTucDAO tinTucDAO = new TinTucDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "danhSachTinTuc":
                try {
                    List<Tintuc> danhSachTinTuc = tinTucDAO.getAll();
                    session.setAttribute("danhSachTinTuc", danhSachTinTuc);
                    req.getRequestDispatcher("danhSachTinTuc.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error: ", e);
                }
                break;
            case "chucNangQuanLy":
                try {
                    List<Danhmuc> danhSachDanhMuc = danhMucDAO.getAll();
                    session.setAttribute("chucNangQuanLy", danhSachDanhMuc);
                    req.getRequestDispatcher("chucNangQuanLy.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error: ", e);
                }
                break;
        }
    }
}
