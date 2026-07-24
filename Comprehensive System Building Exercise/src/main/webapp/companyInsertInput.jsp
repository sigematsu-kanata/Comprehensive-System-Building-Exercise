<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業管理新規登録画面</title>
</head>
<body>
<h1>企業管理新規登録</h1>

<form action="<%= request.getContextPath() %>/CompanyInsertConfirmServlet" method="post">
    <label for="companyName">企業名:</label>
    <input type="text" id="companyName" name="company_name" required><br><br>

    <label for="aliasName">別名:</label>
    <input type="text" id="aliasName" name="alias_name"><br><br>

    <label for="postalCode">郵便番号:</label>
    <input type="text" id="postalCode" name="postal_code" required><br><br>

    <label for="companyAddress">住所:</label>
    <input type="text" id="companyAddress" name="company_address" required><br><br>

    <label for="phoneNumber">TEL:</label>
    <input type="text" id="phoneNumber" name="phone_number"><br><br>

    <label for="mailAddress">メールアドレス:</label>
    <input type="email" id="mailAddress" name="mail_address"><br><br>

    <label for="personName">担当者名:</label>
    <input type="text" id="personName" name="person_name"><br><br>

    <label for="recruitmentRecord">採用実績:</label>
    <input type="text" id="recruitmentRecord" name="recruitmentrecord"><br><br>

    <button type="submit">登録</button>
</form>

<!-- 企業管理画面に戻る -->
<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">戻る</button>
</form>



</body>
</html>