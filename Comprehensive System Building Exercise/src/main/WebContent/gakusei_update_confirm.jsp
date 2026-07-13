<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="gakusei.bean.StudentBean" %>
<%
    StudentBean bean = (StudentBean) request.getAttribute("bean");
    if (bean == null) bean = (StudentBean) session.getAttribute("updateBean");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>学生管理更新確認画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 学生管理</div>
<div class="container">
    <h2>学生管理更新確認</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <table class="form-table">
        <tr><th>学籍番号</th><td><%= bean.getStudentId() %></td></tr>
        <tr><th>出席番号</th><td><%= bean.getAttendanceNo() %></td></tr>
        <tr><th>氏名</th><td><%= bean.getName() %></td></tr>
        <tr><th>読み仮名</th><td><%= bean.getKana() %></td></tr>
        <tr><th>性別</th><td><%= bean.getGender() %></td></tr>
        <tr><th>在籍状況</th><td><%= bean.getStatus() %></td></tr>
        <tr><th>県内外志望</th><td><%= bean.getPrefHope() %></td></tr>
        <tr><th>希望職種１</th><td><%= bean.getJob1() %></td></tr>
        <tr><th>希望職種２</th><td><%= bean.getJob2() %></td></tr>
        <tr><th>希望職種３</th><td><%= bean.getJob3() %></td></tr>
        <tr><th>あっせん辞退</th><td><%= bean.getMediationDecline() %></td></tr>
    </table>

    <p>以上の内容で更新いたします。</p>

    <form action="GakuseiUpdateExecute" method="post">
        <button type="submit" name="action" value="execute" class="btn">実行</button>
        <button type="submit" name="action" value="back" class="btn btn-gray">戻る</button>
    </form>
</div>
</body>
</html>
