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
 * 画面ID: 学生管理更新画面
 * 学生管理画面で選択された学籍番号の情報を読み込み、更新フォームに表示する。
 */
@WebServlet("/GakuseiUpdateInput")
public class GakuseiUpdateInputServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // 確認画面から「戻る」で来た場合は、修正途中の内容を再表示する
        StudentBean bean = (StudentBean) session.getAttribute("updateBean");

        if (bean == null) {
            String studentId = request.getParameter("studentId");
            try {
                StudentDAO dao = new StudentDAO();
                bean = dao.findById(studentId);
            } catch (SQLException e) {
                throw new ServletException("学生情報の取得に失敗しました。", e);
            }
            if (bean == null) {
                request.setAttribute("errorMessage", "指定された学生情報が見つかりません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("GakuseiList");
                dispatcher.forward(request, response);
                return;
            }
        }

        request.setAttribute("bean", bean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_update_input.jsp");
        dispatcher.forward(request, response);
    }
}
