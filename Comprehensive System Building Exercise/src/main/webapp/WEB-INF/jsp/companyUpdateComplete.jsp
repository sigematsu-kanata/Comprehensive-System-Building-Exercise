<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kigyou.bean.CompanyBean" %>
<%
	CompanyBean bean = (CompanyBean) request.getAttribute("bean");
    if (bean == null) bean = (CompanyBean) session.getAttribute("updateBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業管理更新確認画面</title>
</head>
<body>
<div class="header">Job Hunting Management System - 学生管理</div>
<div class="container">
    <h2>企業管理更新確認</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <table class="form-table">
        <tr><th>企業番号</th><td><%= bean.getCompany_id() %></td></tr>
        <tr><th>企業名</th><td><%= bean.getCompany_name() %></td></tr>
        <tr><th>別名</th><td><%= bean.getAlias_name() %></td></tr>
        <tr><th>郵便番号</th><td><%= bean.getPostal_code() %></td></tr>
        <tr><th>住所</th><td><%= bean.getCompany_address() %></td></tr>
        <tr><th>TEL</th><td><%= bean.getPhone_number() %></td></tr>
        <tr><th>メールアドレス</th><td><%= bean.getMail_address() %></td></tr>
        <tr><th>担当者名</th><td><%= bean.getPerson_name() %></td></tr>
        <tr><th>採用実績</th><td><%= bean.getRecruitment_record() %></td></tr>
    </table>

    <p>以上の内容で更新いたします。</p>


<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">企業管理画面に戻る</button>
</body>
</html>