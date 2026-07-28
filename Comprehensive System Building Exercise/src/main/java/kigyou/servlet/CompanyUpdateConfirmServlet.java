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
 * Servlet implementation class CompanyUpdateConfirmServlet
 */
@WebServlet("/CompanyUpdateConfirmServlet")
public class CompanyUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CompanyBean bean = new CompanyBean();
        bean.setCompany_name(request.getParameter("company_name"));
        bean.setAlias_name(request.getParameter("alias_name"));
        bean.setCompany_id(Integer.parseInt(request.getParameter("company_id")));
        bean.setPostal_code(request.getParameter("postal_code"));
        bean.setCompany_address(request.getParameter("company_address"));
        bean.setPhone_number(request.getParameter("phone_number"));
        bean.setMail_address(request.getParameter("mail_address"));
        bean.setPerson_name(request.getParameter("person_name"));
        bean.setRecruitment_record(request.getParameter("recruitment_record"));

        String error = validate(bean);
        if (error != null) {
            request.setAttribute("errorMessage", error);
            request.setAttribute("bean", bean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/companyUpdateInput.jsp");
            dispatcher.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("updateBean", bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/companyUpdateComplete.jsp");
        dispatcher.forward(request, response);
    }

    private String validate(CompanyBean bean) {
        
        return null;
    }
}
