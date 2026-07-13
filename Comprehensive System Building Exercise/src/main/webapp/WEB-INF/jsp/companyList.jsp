<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="model.Company" %>
<%@ <!-- Servletでセットした一覧を受け取る -->
	List<Company>companyList = (List<Company>)request.getAttribute("companyList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業管理画面</title>
</head>
<body>
<h1>企業管理画面</h1>

<!-- 新規登録画面リンクボタン -->
<form action="<%= request.getContexPath() %>/company/insertInput"method="get">
	<button type="submit">新規登録</button>
</form>

<table border="1">
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
        <th>更新</th>
        <th>削除</th>
     </tr>
     
     </%
     	if(companyList != null){
     	    for(Company c : companyList){
     %>
     <tr>
         <td><%= c.getCompanyId() %></td> <!-- 企業番号 -->
         <td><%= c.getCompanyName() %></td><!-- 企業名 -->
         <td><%= c.getAliasName() %></td> <!-- 別名 -->
         <td><%= c.getPostal_code() %></td> <!-- 郵便番号 -->
         <td><%= c.getCompanyAddress() %></td> <!-- 住所 -->
         <td><%= c.getPhone_number() %>  </td> <!-- TEL -->
         <td><%= c.getMail_address() %></td> <!-- メールアドレス -->
         <td><%= c.getPerson_name() %></td> <!-- 担当者名 -->
         <td><%= c.getRecruitementrecord() %></td> <!-- 採用実績 -->
     	<td>
     	
     		<!-- 企業管理更新画面へ -->
     		<form action="<%= request.getContextPath() %>/company/updateInput"method="get" style="display:inline;">
     			<input type="hidden" name="companyId" value="<%= c.getCompanyId() %>">
     			<button type="submit">更新</button>
     		</form>
     		
     		<!-- 企業管理削除確認画面 -->
     		<form action="<%= request.getConetextPath() %>/company/deleteConfirm"method="get" style="display:inline;">
     		    <input type="hidden" name="companyId" value="<%= c.getCompanyId() %>">
     			<button type="submit">削除</button>
     		</form>
     	</td>
     </tr>
     <%
     		}
     	}
     %>      
</table>

</body>
</html>