<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="syuusyoku.model.Employment" %>
<%
Employment bean = (Employment) request.getAttribute("Edata");

//セッションスコープを使っている場合はセッションからも試みる
if (bean == null) {
 bean = (Employment) session.getAttribute("Edata");
}

//それでも null の場合は空のオブジェクトを生成して NullPointerException を防止する
if (bean == null) {
 bean = new Employment();
}
    
    String a = bean.getStudentId() == 0 ? "" : String.valueOf(bean.getStudentId());
    String b = bean.getCompanyId() == 0 ? "" : String.valueOf(bean.getCompanyId());
    
    String c = bean.getActivitySituation() == null ? "" : bean.getActivitySituation();
    String d = bean.getIntroduction() == null ? "" : bean.getIntroduction();
    String e = bean.getPrefecture() == null ? "" : bean.getPrefecture();
    String f = bean.getRegion() == null ? "" : bean.getRegion();
    String g = bean.getInformation_date() == null ? "" : bean.getInformation_date();
    String h = bean.getExam_date1() == null ? "" : bean.getExam_date1();
    String i = bean.getExam_date2() == null ? "" : bean.getExam_date2();
    String j = bean.getExam_date3() == null ? "" : bean.getExam_date3();
    String k = bean.getfinel() == null ? "" : bean.getfinel();
    String n = bean.getmemo() == null ? "" : bean.getmemo();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>就職指導管理 更新 - 入力</title>
<link rel="stylesheet" href="css/style.css">
<style>
    .form-table th, .form-table td {
        padding: 8px 15px;
        border: 1px solid #ddd;
    }
</style>

</head>
<body>
<div class="header">Job Hunting Management System - 就職管理</div>
<div class="container">
    <h2>就職管理更新</h2>

    <%
		String emg = (String) request.getAttribute("emg");
        if (emg != null) {
    %>
    <div class="error"><%= emg %></div>
    <% } %>

    <form action="<%= request.getContextPath() %>/EmploymentUpdataServlet" method="post">
    <input type="hidden" name="action" value="insert">
        <table class="form-table">
            <tr><th>学籍番号</th><td><input type="text" name="a" maxlength="6" value="<%= a %>" required></td></tr>
            <tr><th>企業番号</th><td><input type="text" name="b" maxlength="6" value="<%= b %>" required></td></tr>
            <tr><th>就職状態</th><td>
                    <!-- 変数 c の判定に修正 -->
                    <select name="c" required>
                        <option value="---" <%= "---".equals(c) || c.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="内定確定" <%= "内定確定".equals(c) ? "selected" : "" %>>内定確定</option>
                        <option value="内定保留" <%= "内定保留".equals(c) ? "selected" : "" %>>内定保留</option>
                        <option value="継続中" <%= "継続中".equals(c) ? "selected" : "" %>>継続中</option>
                        <option value="落ちた" <%= "落ちた".equals(c) ? "selected" : "" %>>落ちた</option>
                        <option value="内定後不採用" <%= "内定後不採用".equals(c) ? "selected" : "" %>>内定後不採用</option>
                        <option value="内定辞退" <%= "内定辞退".equals(c) ? "selected" : "" %>>内定辞退</option>
                        <option value="終了" <%= "終了".equals(c) ? "selected" : "" %>>終了</option>
                    </select>
                </td></tr>
            <tr><th>紹介区分</th><td><input type="text" name="d" maxlength="4" value="<%= d %>" required></td></tr>
            <tr><th>県内外</th>
                <td>
                    <select name="e" required>
                        <option value="---" <%= "---".equals(e) || e.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="県内" <%= "県内".equals(e) ? "selected" : "" %>>県内</option>
                        <option value="県外" <%= "県外".equals(e) ? "selected" : "" %>>県外</option>
                    </select>
                </td>
            </tr>
            <tr><th>地域</th><td><input type="text" name="f" value="<%= f %>" required></td></tr>
            <tr><th>説明会日</th><td><input type="date" name="g" maxlength="10" value="<%= g %>" ></td></tr>
            <tr><th>一次試験</th><td><input type="date" name="h" maxlength="10" value="<%= h %>" ></td></tr>
            <tr><th>二次試験</th><td><input type="date" name="i" maxlength="10" value="<%= i %>" ></td></tr>
            <tr><th>三次試験</th><td><input type="date" name="j" maxlength="10" value="<%= j %>" ></td></tr>
            <tr><th>最終結果</th><td><input type="date" name="k" maxlength="10" value="<%= k %>" ></td></tr>
             <tr><th>最終結果</th><td>
                    <select name="k" required>
                        <option value="---" <%= "---".equals(c) || c.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="○" <%= "○".equals(k) ? "selected" : "" %>>○</option>
                        <option value="×" <%= "×".equals(k) ? "selected" : "" %>>×</option>
                    </select> </td></tr>
            <tr><th>備考欄</th><td><input type="text" name="n" maxlength="100" value="<%= n %>" ></td></tr>
        </table>
        <button type="submit" class="btn">登録</button>
        <a class="btn btn-gray" href="<%= request.getContextPath() %>/EmploymentListServlet">戻る</a>
    </form>
</div>
</body>
</html>
