package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SinhVien;
import conn.DBConnection;
import utils.DBUtils;


/**
 * Servlet implementation class EditSinhVienServlet
 */
@WebServlet(urlPatterns = { "/editSinhVien" })
public class EditSinhVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	 
	    public EditSinhVienServlet() {
	        super();
	    }
	 
	    // Hiá»ƒn thá»‹ trang sá»­a .
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	Connection conn = null;
			try {
				conn = DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 
	        String idStr = (String) request.getParameter("id");
	        int id = 0;
	        try {
	            id = Integer.parseInt(idStr);
	        } catch (Exception e) {
	        }
	        SinhVien sv = null;
	 
	        String errorString = null;
	 
	        try {
	            sv = DBUtils.findSinhVien(conn, id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	        // KhÃ´ng cÃ³ lá»—i.
	        // Sinh Vien khÃ´ng tá»“n táº¡i Ä‘á»ƒ edit.
	        // Redirect sang trang danh sÃ¡ch.
	        if (errorString != null && sv == null) {
	            response.sendRedirect(request.getServletPath() + "/sinhvienList");
	            return;
	        }
	 
	        // LÆ°u thÃ´ng tin vÃ o request attribute trÆ°á»›c khi forward sang views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("sinhvien", sv);
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/editSinhVienView.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    // Sau khi ngÆ°á»�i dÃ¹ng sá»­a Ä‘á»•i thÃ´ng tin sáº£n pháº©m, vÃ  nháº¥n Submit.
	    // PhÆ°Æ¡ng thá»©c nÃ y sáº½ Ä‘Æ°á»£c thá»±c thi.
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	Connection conn = null;
			try {
				conn = DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 
	        String idStr= (String)request.getParameter("id");
	        String hoten = new String(request.getParameter("hoten").getBytes("ISO-8859-1"), "UTF-8");
	        String diachi = new String(request.getParameter("diachi").getBytes("ISO-8859-1"), "UTF-8");
	        
	        int id = 0;
	        try {
	            id = Integer.parseInt(idStr);
	        } catch (Exception e) {
	        }
	        SinhVien sv = new SinhVien(id, hoten, diachi);
	 
	        String errorString = null;
	 
	        try {
	            DBUtils.updateSinhVien(conn, sv);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // LÆ°u thÃ´ng tin vÃ o request attribute trÆ°á»›c khi forward sang views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("sinhvien", sv);
	 
	        // Náº¿u cÃ³ lá»—i forward sang trang edit.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/editSinhVienView.jsp");
	            dispatcher.forward(request, response);
	        }
	        // Náº¿u má»�i thá»© tá»‘t Ä‘áº¹p.
	        // Redirect sang trang danh sÃ¡ch sáº£n pháº©m.
	        else {
	            response.sendRedirect(request.getContextPath() + "/sinhvienList");
	        }
	    }	 
	}
