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
import kigyou.dao.CompanyDao;

/**
 * Servlet implementation class CompanyUpdateExecuteServlet
 */
@WebServlet("/CompanyUpdateExecuteServlet")//企業情報更新確認画面


public class CompanyUpdateExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyUpdateExecuteServlet() {
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
		HttpSession session = request.getSession();
		CompanyBean bean = (CompanyBean) request.getAttribute("bean");
	    if (bean == null) bean = (CompanyBean) session.getAttribute("updateBean");
	    bean.setCompany_id(Integer.parseInt(request.getParameter("company_id")));
		bean.setCompany_name(request.getParameter("company_name"));
		bean.setAlias_name(request.getParameter("alias_name"));
		bean.setPostal_code(request.getParameter("postal_code"));
		bean.setCompany_address(request.getParameter("company_address"));
		bean.setPhone_number(request.getParameter("phone_number"));
		bean.setMail_address(request.getParameter("mail_address"));
		bean.setPerson_name(request.getParameter("person_name"));
		bean.setRecruitment_record(request.getParameter("recruitmentrecord"));
		
		CompanyDao dao = new CompanyDao();
		dao.updata(bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyUpdateComplete.jsp");
		rd.forward(request, response);
		
	}

}
