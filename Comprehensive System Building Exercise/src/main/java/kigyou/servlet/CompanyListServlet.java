package kigyou.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import gakusei.servlet.ValidationUtil;
import kigyou.bean.CompanyBean;
import kigyou.dao.CompanyDao;

/**
 * Servlet implementation class CompanyListServlet
 */
@WebServlet("/CompanyListServlet") //企業一覧画面
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");
		// アクション定義書「検索内容入力欄不正入力」: 全角以外が入力された場合はエラーメッセージ
        if (keyword != null && !keyword.isEmpty() && !ValidationUtil.isZenkaku(keyword)) {
            request.setAttribute("errorMessage", "検索内容は全角で入力してください。");
            keyword = null; // 不正入力時は検索条件なしの一覧を表示
        }
        try {
            CompanyDao dao = new CompanyDao();
            List<CompanyBean> list = dao.findByName(keyword);
            
            request.setAttribute("studentList", list);
            request.setAttribute("keyword", request.getParameter("keyword"));
            
        } catch (SQLException e) {
            throw new ServletException("企業情報の取得に失敗しました。", e);
        }
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("companyList.jsp");
        dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
	//DAOを使って全件取得
		/*
		CompanyDao dao = new CompanyDao();
		List<Company> list = dao.findAll();
		
		//JSPに渡すため、リクエスト属性にセット
		request.setAttribute("companyList", list);
		
		//一覧JSPへフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyList.jsp");
		rd.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
