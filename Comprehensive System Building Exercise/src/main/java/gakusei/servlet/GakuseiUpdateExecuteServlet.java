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
 * 画面ID: 学生管理更新確認、実行画面
 * 「実行」ボタン：DBを更新し学生管理画面へ遷移する。
 * 「戻る」ボタン：学生管理更新画面へ遷移する。
 * アクション定義書「重複エラー」：更新先の学籍番号が自分以外の学生と重複する場合はエラー。
 */
@WebServlet("/GakuseiUpdateExecute")
public class GakuseiUpdateExecuteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        StudentBean bean = (StudentBean) session.getAttribute("updateBean");
        if (bean == null) {
            response.sendRedirect("GakuseiList");
            return;
        }

        String action = request.getParameter("action"); // "execute" or "back"

        if ("back".equals(action)) {
            response.sendRedirect("GakuseiUpdateInput");
            return;
        }

        try {
            StudentDAO dao = new StudentDAO();
            StudentBean original = dao.findById(bean.getStudentId());
            if (original == null) {
                request.setAttribute("errorMessage", "更新対象の学生情報が見つかりません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("GakuseiList");
                dispatcher.forward(request, response);
                return;
            }
            dao.update(bean);
        } catch (SQLException e) {
            throw new ServletException("学生情報の更新に失敗しました。", e);
        }

        session.removeAttribute("updateBean");
        response.sendRedirect("GakuseiList");
    }
}
