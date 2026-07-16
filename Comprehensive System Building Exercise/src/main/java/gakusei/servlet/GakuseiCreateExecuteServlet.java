package gakusei.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import gakusei.bean.StudentBean;
import gakusei.dao.StudentDAO;

/**
 * 画面ID: 学生管理新規登録確認、実行画面
 * 「実行」ボタン：DBへ登録し学生管理画面へ遷移する。
 * 「戻る」ボタン：学生管理新規登録入力画面へ遷移する。
 * アクション定義書「重複エラー」：学籍番号が既に存在する場合はエラーメッセージを表示する。
 */
@WebServlet("/GakuseiCreateExecute")
public class GakuseiCreateExecuteServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        StudentBean bean = (StudentBean) session.getAttribute("createBean");
        if (bean == null) {
            response.sendRedirect("GakuseiList");
            return;
        }

        String action = request.getParameter("action"); // "execute" or "back"

        if ("back".equals(action)) {
            response.sendRedirect("GakuseiCreateInput");
            return;
        }

        try {
            StudentDAO dao = new StudentDAO();
            if (dao.existsById(bean.getStudentId())) {
                request.setAttribute("errorMessage", "学籍番号「" + bean.getStudentId() + "」は既に登録されています。");
                request.setAttribute("bean", bean);
                RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_create_confirm.jsp");
                dispatcher.forward(request, response);
                return;
            }
            dao.insert(bean);
        } catch (SQLException e) {
            throw new ServletException("学生情報の登録に失敗しました。", e);
        }

        session.removeAttribute("createBean");
        response.sendRedirect("GakuseiList");
    }
}
