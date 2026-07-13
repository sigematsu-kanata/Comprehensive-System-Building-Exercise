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

<form action="<%= request.getContextPath() %>/company/insertConfirm" method="post">
    <label for="companyName">企業名:</label>
    <input type="text" id="companyName" name="companyName" required><br><br>

    <label for="aliasName">別名:</label>
    <input type="text" id="aliasName" name="aliasName"><br><br>

    <label for="postalCode">郵便番号:</label>
    <input type="text" id="postalCode" name="postalCode" required><br><br>

    <label for="companyAddress">住所:</label>
    <input type="text" id="companyAddress" name="companyAddress" required><br><br>

    <label for="phoneNumber">TEL:</label>
    <input type="text" id="phoneNumber" name="phoneNumber"><br><br>

    <label for="mailAddress">メールアドレス:</label>
    <input type="email" id="mailAddress" name="mailAddress"><br><br>

    <label for="personName">担当者名:</label>
    <input type="text" id="personName" name="personName"><br><br>

    <label for="recruitmentRecord">採用実績:</label>
    <input type="text" id="recruitmentRecord" name="recruitmentRecord"><br><br>

    <button type="submit">登録</button>
</form>

<!-- 企業管理画面に戻る -->
<form action="<%= request.getContextPath() %>/company/list" method="get">
    <button type="submit">戻る</button>
</form>



</body>
</html>