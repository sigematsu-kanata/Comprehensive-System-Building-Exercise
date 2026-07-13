<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>
<h1>削除確認画面</h1>

<p>以下の企業情報を削除します</p>

<tr>
    <td>企業名:</td>
    <td><%= c.getCompanyName() %></td>
    <td>別名:</td>
    <td><%= c.getAliasName() %></td>
    <td>郵便番号:</td>
    <td><%= c.getPostal_code() %></td>
    <td>住所:</td>
    <td><%= c.getCompanyAddress() %></td>
    <td>TEL:</td>
    <td><%= c.getPhone_number() %></td>
    <td>メールアドレス:</td>
    <td><%= c.getMail_address() %></td>
    <td>担当者名:</td>
    <td><%= c.getPerson_name() %></td>
    <td>採用実績:</td>
    <td><%= c.getRecruitementrecord() %></td>
</tr>

<form action="<%= request.getContextPath() %>/company/deleteExecute" method="post">
    <input type="hidden" name="companyId" value="<%= c.getCompanyId() %>">
    <button type="submit">削除</button>
</form>

<form action="<%= request.getContextPath() %>/company/list" method="get">
    <button type="submit">戻る</button>
</body>
</html>