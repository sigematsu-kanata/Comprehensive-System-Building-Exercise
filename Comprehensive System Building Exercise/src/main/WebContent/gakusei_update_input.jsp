<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="gakusei.bean.StudentBean" %>
<%
    StudentBean bean = (StudentBean) request.getAttribute("bean");
    if (bean == null) bean = new StudentBean();

    String v_studentId = bean.getStudentId() == null ? "" : bean.getStudentId();
    String v_name = bean.getName() == null ? "" : bean.getName();
    String v_kana = bean.getKana() == null ? "" : bean.getKana();
    String v_attendanceNo = bean.getAttendanceNo() == null ? "" : bean.getAttendanceNo();
    String v_gender = bean.getGender() == null ? "" : bean.getGender();
    String v_status = bean.getStatus() == null ? "" : bean.getStatus();
    String v_prefHope = bean.getPrefHope() == null ? "" : bean.getPrefHope();
    String v_job1 = bean.getJob1() == null ? "" : bean.getJob1();
    String v_job2 = bean.getJob2() == null ? "" : bean.getJob2();
    String v_job3 = bean.getJob3() == null ? "" : bean.getJob3();
    String v_mediation = bean.getMediationDecline() == null ? "" : bean.getMediationDecline();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>学生管理更新画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 学生管理</div>
<div class="container">
    <h2>学生管理更新</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <form action="GakuseiUpdateConfirm" method="post">
        <table class="form-table">
            <tr><th>学籍番号</th><td><input type="text" name="studentId" maxlength="6" value="<%= v_studentId %>" required></td></tr>
            <tr><th>氏名</th><td><input type="text" name="name" maxlength="6" value="<%= v_name %>" required></td></tr>
            <tr><th>読み仮名</th><td><input type="text" name="kana" maxlength="20" value="<%= v_kana %>" placeholder="平仮名で入力" required></td></tr>
            <tr><th>出席番号</th><td><input type="text" name="attendanceNo" maxlength="4" value="<%= v_attendanceNo %>" required></td></tr>
            <tr><th>性別</th>
                <td>
                    <select name="gender" required>
                        <option value="---" <%= "---".equals(v_gender) || v_gender.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="男性" <%= "男性".equals(v_gender) ? "selected" : "" %>>男性</option>
                        <option value="女性" <%= "女性".equals(v_gender) ? "selected" : "" %>>女性</option>
                    </select>
                </td>
            </tr>
            <tr><th>在籍状況</th>
                <td>
                    <select name="status" required>
                        <option value="---" <%= "---".equals(v_status) || v_status.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="在籍" <%= "在籍".equals(v_status) ? "selected" : "" %>>在籍</option>
                        <option value="休学" <%= "休学".equals(v_status) ? "selected" : "" %>>休学</option>
                        <option value="退学" <%= "退学".equals(v_status) ? "selected" : "" %>>退学</option>
                    </select>
                </td>
            </tr>
            <tr><th>県内外志望</th><td><input type="text" name="prefHope" maxlength="5" value="<%= v_prefHope %>" required></td></tr>
            <tr><th>希望職種１</th><td><input type="text" name="job1" maxlength="10" value="<%= v_job1 %>" required></td></tr>
            <tr><th>希望職種２</th><td><input type="text" name="job2" maxlength="10" value="<%= v_job2 %>" required></td></tr>
            <tr><th>希望職種３</th><td><input type="text" name="job3" maxlength="10" value="<%= v_job3 %>" required></td></tr>
            <tr><th>あっせん辞退</th>
                <td>
                    <select name="mediationDecline" required>
                        <option value="---" <%= "---".equals(v_mediation) || v_mediation.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="あっせん辞退" <%= "あっせん辞退".equals(v_mediation) ? "selected" : "" %>>あっせん辞退</option>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit" class="btn">登録</button>
        <a class="btn btn-gray" href="GakuseiList">戻る</a>
    </form>
</div>
</body>
</html>
