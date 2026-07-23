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
<title>企業管理更新画面</title>
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
    <h2>企業管理更新</h2>
    <!--  
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>
	-->
	<form action="<%= request.getContextPath() %>/CompanyUpdateExecuteServlet" method="post">
        <table class="form-table">
            <tr><th>企業名</th><td><input type="text" name="companyName" maxlength="6" value="<%= c.getCompany_name() %>" required></td></tr>
            <tr><th>別名</th><td><input type="text" name="name" maxlength="6" value="<%= v_name %>" required></td></tr>
            <tr><th>読み仮名</th><td><input type="text" name="kana" maxlength="20" value="<%= v_kana %>" placeholder="平仮名で入力" required></td></tr>
            <tr><th>出席番号</th><td><input type="text" name="attendanceNo" maxlength="4" value="<%= v_attendanceNo %>" required></td></tr>
            <tr><th>性別</th>
                <td>
                    <select name="gender" required>
                        <option value="---" <%= "---".equals(v_gender) || v_gender.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="男性" <%= "男性".equals(v_gender) ? "selected" : "" %>>男性</option>
                        <option value="女性" <%= "女性".equals(v_gender) ? "selected" : "" %>>女性</option>
                    </select>
                </td>
            </tr>
            <tr><th>在籍状況</th>
                <td>
                    <select name="status" required>
                        <option value="---" <%= "---".equals(v_status) || v_status.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="在籍" <%= "在籍".equals(v_status) ? "selected" : "" %>>在籍</option>
                        <option value="休学" <%= "休学".equals(v_status) ? "selected" : "" %>>休学</option>
                        <option value="退学" <%= "退学".equals(v_status) ? "selected" : "" %>>退学</option>
                    </select>
                </td>
            </tr>
            <tr><th>県内外志望</th><td><input type="text" name="prefHope" maxlength="5" value="<%= v_prefHope %>" required></td></tr>
            <tr><th>希望職種１</th><td><input type="text" name="job1" maxlength="10" value="<%= v_job1 %>" required></td></tr>
            <tr><th>希望職種２</th><td><input type="text" name="job2" maxlength="10" value="<%= v_job2 %>" required></td></tr>
            <tr><th>希望職種３</th><td><input type="text" name="job3" maxlength="10" value="<%= v_job3 %>" required></td></tr>
            <tr><th>あっせん辞退</th>
                <td>
                    <select name="mediationDecline" required>
                        <option value="---" <%= "---".equals(v_mediation) || v_mediation.isEmpty() ? "selected" : "" %>>ー</option>
                        <option value="あっせん辞退" <%= "あっせん辞退".equals(v_mediation) ? "selected" : "" %>>あっせん辞退</option>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit" class="btn">登録</button>
        <a class="btn btn-gray" href="GakuseiList">戻る</a>
    </form>




<!-- 
<h1>企業更新入力</h1>
<!-- biknmn
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

<!-- 入力画面に戻る 
<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">戻る</button>
</form>
-->
</body>
</html>