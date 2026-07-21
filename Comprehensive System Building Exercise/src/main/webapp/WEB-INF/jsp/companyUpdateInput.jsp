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
<title>企業更新入力</title>
</head>
<body>
<h1>企業更新入力</h1>

<form action="<%= request.getContextPath() %>/CompanyUpdateExecuteServlet" method="post">
    <input type="hidden" name="company_id" value="<%= c.getCompany_id() %>">
    <label for="companyName">企業名:</label>
    <input type="text" id="companyName" name="company_name" value="<%= c.getCompany_name() %>" required><br><br>

    <label for="aliasName">別名:</label>
    <input type="text" id="aliasName" name="alias_name" value="<%= c.getAlias_name() %>"><br><br>

    <label for="postalCode">郵便番号:</label>
    <input type="text" id="postalCode" name="postal_code" value="<%= c.getPostal_code() %>" required><br><br>

    <label for="companyAddress">住所:</label>
    <input type="text" id="companyAddress" name="company_address" value="<%= c.getCompany_address() %>" required><br><br>

    <label for="phoneNumber">TEL:</label>
    <input type="text" id="phoneNumber" name="phone_number" value="<%= c.getPhone_number() %>"><br><br>

    <label for="mailAddress">メールアドレス:</label>
    <input type="email" id="mailAddress" name="mail_address" value="<%= c.getMail_address() %>"><br><br>

    <label for="personName">担当者名:</label>
    <input type="text" id="personName" name="person_name" value="<%= c.getPerson_name() %>"><br><br>

    <label for="recruitmentRecord">採用実績:</label>
    <input type="text" id="recruitmentRecord" name="recruitmentrecord" value="<%= c.getRecruitmentrecord() %>"><br><br>

    <button type="submit">登録</button>
</form>

<!-- 入力画面に戻る -->
<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">戻る</button>
</form>

</body>
</html>