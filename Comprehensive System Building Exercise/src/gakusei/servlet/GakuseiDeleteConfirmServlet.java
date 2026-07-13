package gakusei.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gakusei.bean.StudentBean;
import gakusei.dao.StudentDAO;

/**
 * 画面ID: 学生管理削除確認、実行画面（表示部分）
 * 学生管理画面で選択された学籍番号の情報を読み込み、削除確認画面に表示する。
 */
@WebServlet("/GakuseiDeleteConfirm")
public class GakuseiDeleteConfirmServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        StudentBean bean;
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

        request.setAttribute("bean", bean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_delete_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
