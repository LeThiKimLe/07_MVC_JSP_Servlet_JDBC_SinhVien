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
 * Servlet implementation class CreateSinhVienServlet
 */
@WebServlet(urlPatterns = { "/createSinhVien" })
public class CreateSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createSinhVienView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
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
            DBUtils.insertSinhVien(conn, sv);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // L????u th????ng tin v????o request attribute tr???????????c khi forward sang views.
        request.setAttribute("errorString", errorString);
       
        // N??????u c???? l???????i forward sang trang edit.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createSinhVienView.jsp");
            dispatcher.forward(request, response);
        }
        // N??????u m???????i th?????? t???????t ???????????p.
        // Redirect sang trang danh s????ch s??????n ph??????m.
        else {
            response.sendRedirect(request.getContextPath() + "/sinhvienList");
        }
	}

}
