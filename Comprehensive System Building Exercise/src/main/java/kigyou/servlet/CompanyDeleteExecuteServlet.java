package kigyou.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import kigyou.dao.CompanyDao;

/**
 * Servlet implementation class CompanyDeleteExecuteServlet
 */
@WebServlet("/CompanyDeleteExecuteServlet")//企業情報削除確認画面
public class CompanyDeleteExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyDeleteExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("companyId"));
		
		try {
			CompanyDao dao = new CompanyDao();
			dao.delete(id);
	        } catch (SQLException e) {
	            throw new ServletException("企業情報の登録に失敗しました。", e);
	        }
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyDeleteComplete.jsp");
		rd.forward(request, response);
		
	}

}
