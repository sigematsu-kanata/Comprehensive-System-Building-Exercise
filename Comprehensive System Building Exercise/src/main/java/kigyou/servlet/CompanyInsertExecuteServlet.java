package kigyou.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import kigyou.dao.CompanyDao;
import kigyou.model.Company;

/**
 * Servlet implementation class CompanyInsertExecuteServlet
 */
@WebServlet("/CompanyInsertExecuteServlet")
public class CompanyInsertExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyInsertExecuteServlet() {
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
		Company c = new Company();
		c.setCompany_name(request.getParameter("company_name"));
		c.setalias_name(request.getParameter("alias_name"));
		c.setPostal_code(Integer.parseInt(request.getParameter("postal_code")));
		c.setCompany_address(request.getParameter("company_address"));
		c.setPhone_number(request.getParameter("phone_number"));
		c.setMail_address(request.getParameter("mail_address"));
		c.setPerson_name(request.getParameter("person_name"));
		c.setRecruitmentrecord(request.getParameter("recruitmentrecord"));
		
		CompanyDao dao = new CompanyDao();
		dao.insert(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyInsertComplete.jsp");
		rd.forward(request, response);
		
		
	}

}
