package syuusyoku.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import syuusyoku.classpackage.Option;
import syuusyoku.model.Employment;
import syuusyoku.model.EmploymentCheckLogic;
import syuusyoku.model.EmploymentGetOneNameLogic;
import syuusyoku.model.EmploymentUpdateLogic;

/**
 * Servlet implementation class EmploymentUpdataServlet
 */
@WebServlet("/EmploymentUpdataServlet")
public class EmploymentUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploymentUpdataServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
        HttpSession session = request.getSession();

        // 1. 入力画面から「確認画面へ進む」とき
        if ("insert".equals(action)) {
        	String forward = "";
        	String emg = "";
            int emgcheck = -1;
            Employment formData = new Employment();
            Employment oldData = (Employment) session.getAttribute("olddata");
            String a = Option.zenkakuToHankakuNum(request.getParameter("a"));
            String b = Option.zenkakuToHankakuNum(request.getParameter("b"));
            
            if(a.equals("error")&&b.equals("error")) {
            	emg = "学籍番号、企業番号に数字以外が入力されました";
            	emgcheck = 0;
            }else if(a.equals("error")) {
            	emg = "学籍番号に数字以外が入力されました";
            	formData.setCompanyId(Integer.parseInt(b));
            	emgcheck = 0;
            }else if(b.equals("error")) {
            	emg = "企業番号に数字以外が入力されました";
            	formData.setStudentId(Integer.parseInt(a));
            	emgcheck = 0;
            }else {
            	Employment testdata = new Employment();
            	testdata.setStudentId(Integer.parseInt(a));
            	testdata.setCompanyId(Integer.parseInt(b));
            	int olds = oldData.getStudentId();
            	int oldc = oldData.getCompanyId();
            	EmploymentCheckLogic cdao = new EmploymentCheckLogic();
                boolean check = cdao.execute(testdata);
                if(olds != testdata.getStudentId()||oldc != testdata.getCompanyId()) {
                	if(check == true) {
                		emg = "学籍番号、企業番号共に重複しているデータがあります";
                		emgcheck = 0;
                	}
            	}
            }
            
            if(emgcheck == 0) {//エラー
            	forward = "/WEB-INF/jsp/Employment_update.jsp";
            }else {
            	// 数値変換の安全対策
            	formData.setStudentId(Integer.parseInt(a));
            	formData.setCompanyId(Integer.parseInt(b));
            	
            	forward = "/WEB-INF/jsp/Employment_update_confirm.jsp";
            }
            
            EmploymentGetOneNameLogic Ndao = new EmploymentGetOneNameLogic();
            String Name = Ndao.execute(a);
            formData.setName(Name);
            
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
            
            request.setAttribute("emg", emg);
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
            dispatcher.forward(request, response);

        // 2. 確認画面から「入力画面へ戻る」とき
        } else if ("back".equals(action)) {
            // セッションからデータを取り出してリクエストスコープへ（入力画面で初期値として表示するため）
            Employment formData = (Employment) session.getAttribute("Edata");
            request.setAttribute("Edata", formData);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_update.jsp");
            dispatcher.forward(request, response);

        // 3. 確認画面で最終的な「登録（実行）」が行われたとき
        } else if ("execute".equals(action)) {
            Employment formData = (Employment) session.getAttribute("Edata");
            Employment oldData = (Employment) session.getAttribute("olddata");
            System.out.println("up_e");
            System.out.println(oldData.getStudentId());
            System.out.println("up_e");
            System.out.println(formData.getStudentId());
            System.out.println("up_e");
            if (formData != null) {
                EmploymentUpdateLogic UpdateLogic = new EmploymentUpdateLogic();
                UpdateLogic.execute(formData,oldData);
                
                // 不要になったセッションデータを破棄
                session.removeAttribute("Edata");
            }

            // 二重送信防止のためリダイレクトを行う
            response.sendRedirect(request.getContextPath() + "/EmploymentListServlet");
        }else {//この画面に入るとき
        	Employment formData = new Employment();
        	Employment oldData = new Employment();
        	 try {
                 formData.setStudentId(Integer.parseInt(request.getParameter("a")));
                 formData.setCompanyId(Integer.parseInt(request.getParameter("b")));
                 oldData.setStudentId(Integer.parseInt(request.getParameter("a")));
             	 oldData.setCompanyId(Integer.parseInt(request.getParameter("b")));
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
             session.setAttribute("olddata", oldData);
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Employment_update.jsp");
             dispatcher.forward(request, response);
        }
    }
}