package kigyou.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import kigyou.bean.CompanyBean;
import kigyou.dao.CompanyDao;

/**
 * Servlet implementation class CompanyUpdateExecuteServlet
 */
@WebServlet("/CompanyUpdateExecuteServlet")//企業情報更新確認画面


public class CompanyUpdateExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CompanyBean bean = (CompanyBean) session.getAttribute("updateBean");
		
        if (bean == null) {
            response.sendRedirect("/WEB-INF/jsp/companyUpdateComplete.jsp");
            return;
        }

        String action = request.getParameter("action"); // "execute" or "back"

        if ("back".equals(action)) {
            response.sendRedirect("GakuseiUpdateInput");
            return;
        }

        try {
        	CompanyDao dao = new CompanyDao();
        	CompanyBean original = dao.findById(bean.getCompany_id());
            if (original == null) {
                request.setAttribute("errorMessage", "更新対象の企業情報が見つかりません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("GakuseiList");
                dispatcher.forward(request, response);
                return;
            }
            int num = dao.updata(bean);
            System.out.println(num);
        } catch (SQLException e) {
            throw new ServletException("企業情報の更新に失敗しました。", e);
        }

        session.removeAttribute("updateBean");
        response.sendRedirect("CompanyListServlet");
	}

}
