<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="kigyou.bean.CompanyBean" %>

<!-- Servletでセットした一覧を受け取る -->
<%//List<Company>companyList = (List<Company>)request.getAttribute("companyList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業管理画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 企業管理</div>
<div class="container">
	<h2>企業管理画面</h2>
	
	<%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>
    
    <div class="action-links">
        <a class="btn btn-gray" href="/index.jsp" title="このサブシステムの範囲外の画面です">作業選択</a>
        <a class="btn" href="CompanyInsertInputServlet">新規登録</a>
    </div>
    
	<form class="search-box" action="CompanyListServlet" method="get">
        検索（企業番号or企業名・全角）：
        <input type="text" name="keyword" value="<%= request.getAttribute("keyword") == null ? "" : request.getAttribute("keyword") %>">
        <button type="submit" class="btn">検索</button>
    </form>
	<table>
        <tr>
            <th>企業番号</th>
        	<th>企業名</th>
        	<th>別名</th>
        	<th>郵便番号</th>
        	<th>住所</th>
        	<th>TEL</th>
        	<th>メールアドレス</th>
        	<th>担当者名</th>
        	<th>採用実績</th>
            <th>操作</th>
        </tr>
		<%
            @SuppressWarnings("unchecked")
            List<CompanyBean> list = (List<CompanyBean>) request.getAttribute("companyList");
            if (list != null) {
                for (CompanyBean c : list) {
        %>
		<tr>
			<td><%= c.getCompany_id() %></td>
            <td><%= c.getCompany_name()%></td>
            <td><%= c.getAlias_name() %></td>
            <td><%= c.getPostal_code() %></td>
            <td><%= c.getCompany_address() %></td>
            <td><%= c.getPhone_number() %></td>
            <td><%= c.getMail_address() %></td>
            <td><%= c.getPerson_name() %></td>
            <td><%= c.getRecruitment_record() %></td>
            <td>
                <a href="CompanyUpdateInputServlet?companyId=<%= c.getCompany_id() %>">更新</a>
                /
                <a href="CompanyDeleteConfirmServlet?companyId=<%= c.getCompany_id() %>">削除</a>
            
            </td>
        </tr>
		<%
           		}
           }
        %>

	</table> 
</body>
</html>