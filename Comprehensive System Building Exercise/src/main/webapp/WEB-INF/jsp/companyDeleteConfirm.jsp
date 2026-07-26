<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Company" %>   
<%
    CompanyBean bean = (CompanyBean) request.getAttribute("bean");
    if (bean == null) bean = new CompanyBean();

    String Company_name = bean.getPerson_name() == null ? "null" : bean.getPerson_name();
    String Alias_name = bean.getAlias_name() == null ? "null" : bean.getAlias_name();
    String Postal_code = bean.getPostal_code() == null ? "null" : bean.getPostal_code();
    String Company_address = bean.getCompany_address() == null ? "null" : bean.getCompany_address();
    String Phone_number = bean.getPhone_number() == null ? "null" : bean.getPhone_number();
    String Mail_address = bean.getMail_address() == null ? "null" : bean.getMail_address();
    String Person_name = bean.getPerson_name() == null ? "null" : bean.getPerson_name();
    String Recruitment_record = bean.getRecruitment_record() == null ? "" : bean.getRecruitment_record();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
    <h2>企業管理削除</h2>
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
</div>
<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">戻る</button>
</body>
</html>