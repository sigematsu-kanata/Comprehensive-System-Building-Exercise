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
        bean.setCompany_name(request.getParameter(""));
        bean.setAlias_name(request.getParameter(""));
        //bean.setCompany_id(Integer.parseInt(request.getParameter("")));
        bean.setPostal_code(request.getParameter(""));
        bean.setCompany_address(request.getParameter(""));
        bean.setPhone_number(request.getParameter(""));
        bean.setMail_address(request.getParameter(""));
        bean.setPerson_name(request.getParameter(""));
        bean.setRecruitment_record(request.getParameter(""));

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
