package gakusei.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gakusei.dao.StudentDAO;

/**
 * 画面ID: 学生管理削除確認、実行画面（実行部分）
 * 「実行」ボタン：DBから削除し学生管理画面へ遷移する。
 * 「戻る」ボタン：学生管理画面へ遷移する。
 */
@WebServlet("/GakuseiDeleteExecute")
public class GakuseiDeleteExecuteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action"); // "execute" or "back"
        String studentId = request.getParameter("studentId");

        if ("execute".equals(action)) {
            try {
                StudentDAO dao = new StudentDAO();
                dao.delete(studentId);
            } catch (SQLException e) {
                throw new ServletException("学生情報の削除に失敗しました。", e);
            }
        }

        response.sendRedirect("GakuseiList");
    }
}
