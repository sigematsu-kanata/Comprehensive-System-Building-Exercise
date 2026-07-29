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
 * Servlet implementation class CompanyInsertExecuteServlet
 */
@WebServlet("/CompanyInsertExecuteServlet")
public class CompanyInsertExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompanyInsertExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CompanyBean bean = (CompanyBean) session.getAttribute("bean");
		bean.setCompany_name(request.getParameter("company_name"));
		bean.setAlias_name(request.getParameter("alias_name"));
		bean.setPostal_code(request.getParameter("postal_code"));
		bean.setCompany_address(request.getParameter("company_address"));
		bean.setPhone_number(request.getParameter("phone_number"));
		bean.setMail_address(request.getParameter("mail_address"));
		bean.setPerson_name(request.getParameter("person_name"));
		bean.setRecruitment_record(request.getParameter("recruitment_record"));
		try {
		CompanyDao dao = new CompanyDao();
		dao.insert(bean);
        } catch (SQLException e) {
            throw new ServletException("企業情報の登録に失敗しました。", e);
        }
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyInsertComplete.jsp");
		rd.forward(request, response);
		
		
	}

}
