package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import classpackage.Option;
import model.Employment;
import model.EmploymentSetLogic;

/**
 * Servlet implementation class EmploymentInsertServlet
 */
@WebServlet("/EmploymentInsertServlet")
public class EmploymentInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        // 1. 入力画面から「確認画面へ進む」とき
        if ("insert".equals(action)) {
            Employment formData = new Employment();
            String a = Option.zenkakuToHankakuNum(request.getParameter("a"));
            String b = Option.zenkakuToHankakuNum(request.getParameter("b"));
			/*if(a.equals("数字以外が入力されています")||b.equals("数字以外が入力されています")){
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
			    String emg = "学籍番号または数字以外が入力されています";
			}*/
            // 数値変換の安全対策
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

            // セッションスコープに保存（画面を跨いでも保持される）
            session.setAttribute("Edata", formData);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_register_confirm.jsp");
            dispatcher.forward(request, response);

        // 2. 確認画面から「入力画面へ戻る」とき
        } else if ("back".equals(action)) {
            // セッションからデータを取り出してリクエストスコープへ（入力画面で初期値として表示するため）
            Employment formData = (Employment) session.getAttribute("Edata");
            request.setAttribute("Edata", formData);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_register.jsp");
            dispatcher.forward(request, response);

        // 3. 確認画面で最終的な「登録（実行）」が行われたとき
        } else if ("execute".equals(action)) {
            Employment formData = (Employment) session.getAttribute("Edata");

            if (formData != null) {
                EmploymentSetLogic setNewUserLogic = new EmploymentSetLogic();
                setNewUserLogic.execute(formData);
                
                // 不要になったセッションデータを破棄
                session.removeAttribute("Edata");
            }

            // 二重送信防止のためリダイレクトを行う
            response.sendRedirect(request.getContextPath() + "/EmploymentListServlet");
        }
    }
}