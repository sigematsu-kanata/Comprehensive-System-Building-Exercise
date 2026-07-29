<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kigyou.bean.CompanyBean" %>
<%
	CompanyBean bean = (CompanyBean) session.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録確認画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
    <h2>新規登録確認画面</h2>
    <table class="form-table">
        <tr><th>企業名</th><td><%= bean.getCompany_name() %></td></tr>
        <tr><th>別名</th><td><%= bean.getAlias_name() %></td></tr>
        <tr><th>郵便番号</th><td><%= bean.getPostal_code() %></td></tr>
        <tr><th>住所</th><td><%= bean.getCompany_address() %></td></tr>
        <tr><th>TEL</th><td><%= bean.getPhone_number() %></td></tr>
        <tr><th>メールアドレス</th><td><%= bean.getMail_address() %></td></tr>
        <tr><th>担当者名</th><td><%= bean.getPerson_name() %></td></tr>
        <tr><th>採用実績</th><td><%= bean.getRecruitment_record() %></td></tr>
    </table>
	<form action="<%= request.getContextPath() %>/CompanyInsertExecuteServlet" method="post">
	    <input type="hidden" name="company_name" value="<%= bean.getCompany_name() %>">
	    <input type="hidden" name="alias_name" value="<%= bean.getAlias_name() %>">
	    <input type="hidden" name="postal_code" value="<%= bean.getPostal_code() %>">
	    <input type="hidden" name="company_address" value="<%= bean.getCompany_address() %>">
	    <input type="hidden" name="phone_number" value="<%= bean.getPhone_number() %>">
	    <input type="hidden" name="mail_address" value="<%= bean.getMail_address() %>">
	    <input type="hidden" name="person_name" value="<%= bean.getPerson_name() %>">
	    <input type="hidden" name="recruitment_record" value="<%= bean.getRecruitment_record() %>">
	    <button type="submit" class="btn btn-danger">登録</button>
	    <a class="btn btn-gray" href="/CompanyInsertConfirmServlet" method="post">戻る</a>
	</form>
</div>
</body>
</html>