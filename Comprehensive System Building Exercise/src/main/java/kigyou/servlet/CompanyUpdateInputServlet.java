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
 * 画面ID: 企業管理更新画面
 * 企業管理画面で選択された企業番号の情報を読み込み、更新フォームに表示する。
 */
@WebServlet("/CompanyUpdateInputServlet")//企業情報更新入力画面
public class CompanyUpdateInputServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		 // 確認画面から「戻る」で来た場合は、修正途中の内容を再表示する
		CompanyBean bean = (CompanyBean) session.getAttribute("bean");

        if (bean == null) {
            String companyId = request.getParameter("companyId");
            System.out.println(companyId);
            try {
            	CompanyDao dao = new CompanyDao();
                bean = dao.findById(Integer.parseInt(companyId));
            } catch (SQLException e) {
                throw new ServletException("企業情報の取得に失敗しました。", e);
            }
            if (bean == null) {
                request.setAttribute("errorMessage", "指定された企業情報が見つかりません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/companyUpdateComplete.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/companyUpdateInput.jsp");
		rd.forward(request, response);
		
	}


}
