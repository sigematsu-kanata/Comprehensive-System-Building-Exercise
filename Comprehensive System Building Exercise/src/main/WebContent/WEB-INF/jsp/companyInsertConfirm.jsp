<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<form action="<%= request.getContextPath() %>/company/insert" method="post">
    <input type="hidden" name="companyName" value="<%= c.getCompanyName() %>">
    <input type="hidden" name="aliasName" value="<%= c.getAliasName() %>">
    <input type="hidden" name="postalCode" value="<%= c.getPostal_code() %>">
    <input type="hidden" name="companyAddress" value="<%= c.getCompanyAddress() %>">
    <input type="hidden" name="phoneNumber" value="<%= c.getPhone_number() %>">
    <input type="hidden" name="mailAddress" value="<%= c.getMail_address() %>">
    <input type="hidden" name="personName" value="<%= c.getPerson_name() %>">
    <input type="hidden" name="recruitmentRecord" value="<%= c.getRecruitementrecord() %>">
    <button type="submit">登録</button>
</form>

<form action="<%= request.getContextPath() %>/company/insertInput" method="get">
    <button type="submit">戻る</button>
</form>

    

</body>
</html>