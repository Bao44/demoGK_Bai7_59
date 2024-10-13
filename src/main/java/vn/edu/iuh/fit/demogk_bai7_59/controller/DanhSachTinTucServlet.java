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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/action")
public class DanhSachTinTucServlet extends HttpServlet {
    private TinTucDAO tinTucDAO = new TinTucDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "addTinTuc":
                boolean result = false;
                if (checkAddTinTuc(req, resp)) {
                    Tintuc tintuc = new Tintuc();
                    tintuc.setMatt(req.getParameter("MATT"));
                    tintuc.setTieude(req.getParameter("TIEUDE"));
                    tintuc.setNoidungtt(req.getParameter("NOIDUNGTT"));
                    tintuc.setLienket(req.getParameter("LIENKET"));
                    tintuc.setMadm(new Danhmuc(req.getParameter("MADM")));
                    try {
                        result = tinTucDAO.addTinTuc(tintuc);
                        if (result) {
                            PrintWriter out = resp.getWriter();
                            out.println("<script type=\"text/javascript\"> alert('Successfull!'); location='index.jsp'  </script>");
                        } else {
                            PrintWriter out = resp.getWriter();
                            out.println("<script type=\"text/javascript\"> alert('Error'); location='addTinTuc.jsp' </script>");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
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
                    req.getRequestDispatcher("/danhSachTinTuc.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error: ", e);
                }
                break;
            case "chucNangQuanLy":
                try {
                    List<Danhmuc> danhSachDanhMuc = danhMucDAO.getAll();
                    session.setAttribute("chucNangQuanLy", danhSachDanhMuc);
                    req.getRequestDispatcher("/chucNangQuanLy.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error: ", e);
                }
                break;
            case "deleteTinTuc":
                String matt = req.getParameter("MATT");
                try {
                    boolean result = tinTucDAO.deleteTinTuc(matt);
                    if (result) {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Xoa thanh cong!'); </script>");
                    } else {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Xoa khong thanh cong!'); </script>");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("action?action=danhSachTinTuc");
                break;
        }
    }

    private boolean checkAddTinTuc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tintuc tintuc = new Tintuc();
        String matt = req.getParameter("MATT");
        String tieude = req.getParameter("TIEUDE");
        String noidungtt = req.getParameter("NOIDUNGTT");
        String lienket = req.getParameter("LIENKET");
        String madm = req.getParameter("MADM");

        if (matt == null || matt.equals("")) {
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\"> alert('Ma tin tuc khong duoc de trong'); location='addTinTuc.jsp' </script>");
            return false;
        } else if (tieude == null || tieude.equals("")) {
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\"> alert('Tieu de khong duoc tronh'); location='addTinTuc.jsp' </script>");
            return false;
        } else if (noidungtt == null || noidungtt.equals("")) {
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\"> alert('Noi dung khong duoc trong'); location='addTinTuc.jsp' </script>");
            return false;
        } else if (madm == null || madm.equals("")) {
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\"> alert('Ma danh muc khong duoc trong'); location='addTinTuc.jsp' </script>");
            return false;
        }
        return true;
    }
}
