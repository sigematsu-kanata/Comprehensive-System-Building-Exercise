package kigyou.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import kigyou.bean.CompanyBean;

/**
 * Servlet implementation class CompanyInsertConfirmServlet
 */
@WebServlet("/CompanyInsertConfirmServlet")
public class CompanyInsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompanyInsertConfirmServlet() {
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
		CompanyBean bean = new CompanyBean();
		bean.setCompany_name(request.getParameter("company_name"));
		bean.setAlias_name(request.getParameter("alias_name"));
		bean.setPostal_code(request.getParameter("postal_code"));
		bean.setCompany_address(request.getParameter("company_address"));
		bean.setPhone_number(request.getParameter("phone_number"));
		bean.setMail_address(request.getParameter("mail_address"));
		bean.setPerson_name(request.getParameter("person_name"));
		bean.setRecruitment_record(request.getParameter("recruitment_record"));
		session.setAttribute("bean", bean);
		request.setAttribute("bean", bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyInsertConfirm.jsp");
		rd.forward(request, response);
	}
}
