<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Company" %>
    
<%
	Company c = (Company)request.getAttribute("company");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録確認画面</title>
</head>
<body>
<h1>新規登録確認画面</h1>

<tr>
    <td>企業名:</td>
    <td><%= c.getCompany_name() %></td>
    <td>別名:</td>
    <td><%= c.getAlias_name() %></td>
    <td>郵便番号:</td>
    <td><%= c.getPostal_code() %></td>
    <td>住所:</td>
    <td><%= c.getCompany_address() %></td>
    <td>TEL:</td>
    <td><%= c.getPhone_number() %></td>
    <td>メールアドレス:</td>
    <td><%= c.getMail_address() %></td>
    <td>担当者名:</td>
    <td><%= c.getPerson_name() %></td>
    <td>採用実績:</td>
    <td><%= c.getRecruitmentrecord() %></td>
</tr>

<form action="<%= request.getContextPath() %>/CompanyInsertExecuteServlet" method="post">
    <input type="hidden" name="company_name" value="<%= c.getCompany_name() %>">
    <input type="hidden" name="alias_name" value="<%= c.getAlias_name() %>">
    <input type="hidden" name="postal_code" value="<%= c.getPostal_code() %>">
    <input type="hidden" name="company_address" value="<%= c.getCompany_address() %>">
    <input type="hidden" name="phone_number" value="<%= c.getPhone_number() %>">
    <input type="hidden" name="mail_address" value="<%= c.getMail_address() %>">
    <input type="hidden" name="person_name" value="<%= c.getPerson_name() %>">
    <input type="hidden" name="recruitmentrecord" value="<%= c.getRecruitmentrecord() %>">
    <button type="submit">登録</button>
</form>

<form action="<%= request.getContextPath() %>/CompanyInsertInputServlet" method="get">
    <button type="submit">戻る</button>
</form>

    

</body>
</html>