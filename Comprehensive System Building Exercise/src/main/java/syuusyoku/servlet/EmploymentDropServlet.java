package syuusyoku.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import syuusyoku.model.Employment;
import syuusyoku.model.EmploymentDropListLogic;

/**
 * Servlet implementation class EmploymentDropServlet
 */
@WebServlet("/EmploymentDropServlet")
public class EmploymentDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploymentDropServlet() {
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
		String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if ("execute".equals(action)) {
            Employment formData = (Employment) session.getAttribute("Edata");
            System.out.println(formData.getIntroduction());
            System.out.println("dp_e");
            if (formData != null) {
                EmploymentDropListLogic DropLogic = new EmploymentDropListLogic();
                DropLogic.execute(formData);
                
                // 不要になったセッションデータを破棄
                session.removeAttribute("Edata");
            }

            // 二重送信防止のためリダイレクトを行う
            response.sendRedirect(request.getContextPath() + "/EmploymentListServlet");
        }else {
        	Employment formData = new Employment();
        	 try {
                 formData.setStudentId(Integer.parseInt(request.getParameter("a")));
                 formData.setCompanyId(Integer.parseInt(request.getParameter("b")));
             } catch (NumberFormatException e) {
                 // 数値変換失敗時の例外処理（必要に応じてエラーメッセージを設定）
             }

             formData.setActivitySituation(request.getParameter("c"));
             formData.setIntroduction(request.getParameter("d"));
             formData.setPrefecture(request.getParameter("e"));
             formData.setRegion(request.getParameter("f"));
             formData.setInformation_date(request.getParameter("g"));
             formData.setExam_date1(request.getParameter("h"));
             formData.setExam_date2(request.getParameter("i"));
             formData.setExam_date3(request.getParameter("j"));
             formData.setfinel(request.getParameter("k"));
             formData.setmemo(request.getParameter("n"));
             System.out.println(request.getParameter("a"));
             // セッションスコープに保存（画面を跨いでも保持される）
             session.setAttribute("Edata", formData);

             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_drop_confirm.jsp");
             dispatcher.forward(request, response);
        }
    }

}
