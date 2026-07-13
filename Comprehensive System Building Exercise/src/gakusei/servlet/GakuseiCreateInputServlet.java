package gakusei.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 画面ID: Gakusei_create　学生管理新規登録入力画面
 * 入力フォームを表示する。「戻る」で学生管理画面に戻る際は
 * GakuseiListServlet へ直接リンクするため、本Servletでは扱わない。
 */
@WebServlet("/GakuseiCreateInput")
public class GakuseiCreateInputServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 確認画面から「戻る」で来た場合は、入力していた内容を再表示する
        HttpSession session = request.getSession();
        Object bean = session.getAttribute("createBean");
        if (bean != null) {
            request.setAttribute("bean", bean);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_create_input.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
