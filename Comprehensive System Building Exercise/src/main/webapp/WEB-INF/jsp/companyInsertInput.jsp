<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業管理新規登録画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
    <h2>新規登録入力画面</h2>
    
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>
	<form action="CompanyInsertConfirmServlet" method="post">
	    <table class="form-table">
	    	<tr><th>企業名</th> <td><input type="text" name="company_name" required></td></tr>
	        <tr><th>別名</th> <td><input type="text" id="aliasName" name="alias_name" required></td></tr>
	        <tr><th>郵便番号</th> <td><input type="text" id="Postal_code" name="postal_code" required></td></tr>
	        <tr><th>住所</th> <td><input type="text" id="companyAddress" name="company_address" required></td></tr>
	        <tr><th>TEL</th> <td><input type="text" id="phoneNumber" name="phone_number" required></td></tr>
	        <tr><th>メールアドレス</th> <td><input type="email" id="mailAddress" name="mail_address" required></td></tr>
	        <tr><th>担当者名</th> <td><input type="text" id="personName" name="person_name" required></td></tr>
	        <tr><th>採用実績</th>
	            <td>
	                <select name="recruitment_record" required>
	                    <option value="〇" >〇</option>
	                    <option value="×" >×</option>
	                </select>
	            </td>
	        </tr>
	    </table>
	    <button type="submit" class="btn btn-danger">登録</button>
        <a class="btn btn-gray" href="CompanyListServlet">戻る</a>
    </form>
    

	<!--<form action="<%= request.getContextPath() %>/CompanyInsertConfirmServlet" method="post">
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
	    <input type="text" id="recruitmentRecord" name="recruitment_record"><br><br>  -->
	    
	</form>
</div>
</body>
</html>