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
<title>削除確認画面</title>
</head>
<body>
<h1>削除確認画面</h1>
<!-- btksn -->
<p>以下の企業情報を削除します</p>

<table>
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
</table>
<form action="<%= request.getContextPath() %>/CompanyDeleteExecuteServlet" method="post">
    <input type="hidden" name="company_id" value="<%= c.getCompany_id() %>">
    <button type="submit">削除</button>
</form>

<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">戻る</button>
</body>
</html>