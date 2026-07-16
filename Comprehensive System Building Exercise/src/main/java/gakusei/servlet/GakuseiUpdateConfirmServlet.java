package gakusei.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import gakusei.bean.StudentBean;

/**
 * 画面ID: 学生管理更新画面 →「登録」ボタン押下時の処理。
 * 入力チェックを行い、OKであれば内容をセッションに保持して確認画面へフォワードする。
 */
@WebServlet("/GakuseiUpdateConfirm")
public class GakuseiUpdateConfirmServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentBean bean = new StudentBean();
        bean.setStudentId(request.getParameter("studentId"));
        bean.setName(request.getParameter("name"));
        bean.setKana(request.getParameter("kana"));
        bean.setAttendanceNo(request.getParameter("attendanceNo"));
        bean.setGender(request.getParameter("gender"));
        bean.setStatus(request.getParameter("status"));
        bean.setPrefHope(request.getParameter("prefHope"));
        bean.setJob1(request.getParameter("job1"));
        bean.setJob2(request.getParameter("job2"));
        bean.setJob3(request.getParameter("job3"));
        bean.setMediationDecline(request.getParameter("mediationDecline"));

        String error = validate(bean);
        if (error != null) {
            request.setAttribute("errorMessage", error);
            request.setAttribute("bean", bean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_update_input.jsp");
            dispatcher.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("updateBean", bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gakusei_update_confirm.jsp");
        dispatcher.forward(request, response);
    }

    private String validate(StudentBean bean) {
        if (ValidationUtil.isEmpty(bean.getStudentId()) || !ValidationUtil.isNumeric(bean.getStudentId())) {
            return "学籍番号は半角数字で入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getName())) {
            return "氏名を入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getKana()) || !ValidationUtil.isHiragana(bean.getKana())) {
            return "読み仮名は平仮名で入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getAttendanceNo()) || !ValidationUtil.isNumeric(bean.getAttendanceNo())) {
            return "出席番号は半角数字で入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getGender()) || "---".equals(bean.getGender())) {
            return "性別を選択してください。";
        }
        if (ValidationUtil.isEmpty(bean.getStatus()) || "---".equals(bean.getStatus())) {
            return "在籍状況を選択してください。";
        }
        if (ValidationUtil.isEmpty(bean.getPrefHope())) {
            return "県内外志望を入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getJob1())) {
            return "希望職種１を入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getJob2())) {
            return "希望職種２を入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getJob3())) {
            return "希望職種３を入力してください。";
        }
        if (ValidationUtil.isEmpty(bean.getMediationDecline()) || "---".equals(bean.getMediationDecline())) {
            return "あっせん辞退を選択してください。";
        }
        return null;
    }
}
