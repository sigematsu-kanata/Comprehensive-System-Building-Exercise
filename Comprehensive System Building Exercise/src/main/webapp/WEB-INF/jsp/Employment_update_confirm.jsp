<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="syuusyoku.model.Employment" %>
<%
//リクエストスコープから取得を試みる
Employment bean = (Employment) request.getAttribute("Edata");

// セッションスコープを使っている場合はセッションからも試みる
if (bean == null) {
    bean = (Employment) session.getAttribute("Edata");
}

// それでも null の場合は空のオブジェクトを生成して NullPointerException を防止する
if (bean == null) {
    bean = new Employment();
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>就職管理更新確認画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 就職管理</div>
<div class="container">
    <h2>就職管理更新確認</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <table class="form-table">
        <tr><th>学籍番号</th><td><%= bean.getStudentId() %></td></tr>
        <tr><th>企業番号</th><td><%= bean.getCompanyId() %></td></tr>
        <tr><th>就職状況</th><td><%= bean.getActivitySituation() %></td></tr>
        <tr><th>紹介区分</th><td><%= bean.getIntroduction() %></td></tr>
        <tr><th>地域</th><td><%= bean.getPrefecture() %></td></tr>
        <tr><th>県内外志望</th><td><%= bean.getRegion() %></td></tr>
        <tr><th>説明会</th><td><%= bean.getInformation_date() %></td></tr>
        <tr><th>1次試験</th><td><%= bean.getExam_date1() %></td></tr>
        <tr><th>2次試験</th><td><%= bean.getExam_date2() %></td></tr>
        <tr><th>最終選考</th><td><%= bean.getExam_date3() %></td></tr>
        <tr><th>最終結果</th><td><%= bean.getfinel() %></td></tr>
        <tr><th>備考</th><td><%= bean.getmemo() %></td></tr>
        
    </table>

    <p>以上の内容で更新いたします。</p>

    <form action="<%= request.getContextPath() %>/EmploymentUpdataServlet" method="post">
        <button type="submit" name="action" value="execute" class="btn">実行</button>
        <button type="submit" name="action" value="back" class="btn btn-gray">戻る</button>
    </form>
</div>
</body>
</html>
