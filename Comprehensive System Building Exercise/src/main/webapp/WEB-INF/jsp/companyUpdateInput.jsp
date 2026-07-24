<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kigyou.bean.CompanyBean" %>
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
<title>企業管理更新画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
    <h2>企業管理更新</h2>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>
	
	
	<form action="<%= request.getContextPath() %>/CompanyUpdateExecuteServlet" method="post">
        <table class="form-table">
        	<tr><th>企業名</th> <td><input type="text" name="companyName"  value="<%= Company_name %>" required></td></tr>
            <tr><th>別名</th> <td><input type="text" id="aliasName" name="alias_name"  value="<%= Alias_name %>" required></td></tr>
            
            <tr><th>郵便番号</th> <td><input type="text" id="Postal_code" name="Postal_code" value="<%= Postal_code %>" required></td></tr>
            <tr><th>住所</th> <td><input type="text" id="companyAddress" name="company_address" value="<%= Company_address %>" required></td></tr>
            <tr><th>TEL</th> <td><input type="text" id="phoneNumber" name="phone_number" value="<%= Phone_number %>" required></td></tr>
            <tr><th>メールアドレス</th> <td><input type="email" id="mailAddress" name="mail_address" value="<%= Mail_address %>" required></td></tr>
            <tr><th>担当者名</th> <td><input type="text" id="personName" name="person_name" value="<%= Person_name %>" required></td></tr>
            <tr><th>採用実績</th>
                <td>
                    <select name="recruitmentrecord" required>
                        <option value="〇" <%= "〇".equals(Recruitment_record) || Recruitment_record.isEmpty() ? "selected" : "" %>>〇</option>
                        <option value="×" <%= "×".equals(Recruitment_record) ? "selected" : "" %>>×</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>