package gakusei.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gakusei.bean.StudentBean;
import gakusei.dao.StudentDAO;

/**
 * 画面ID: Gakusei_read　学生管理画面
 * 一覧表示・氏名による検索を行う。
 */
@WebServlet("/GakuseiList")
public class GakuseiListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        // アクション定義書「検索内容入力欄不正入力」: 全角以外が入力された場合はエラーメッセージ
        if (keyword != null && !keyword.isEmpty() && !ValidationUtil.isZenkaku(keyword)) {
            request.setAttribute("errorMessage", "検索内容は全角で入力してください。");
            keyword = null; // 不正入力時は検索条件なしの一覧を表示
        }

        try {
            StudentDAO dao = new StudentDAO();
            List<StudentBean> list = dao.findByName(keyword);
            request.setAttribute("studentList", list);
            request.setAttribute("keyword", request.getParameter("keyword"));
        } catch (SQLException e) {
            throw new ServletException("学生情報の取得に失敗しました。", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
