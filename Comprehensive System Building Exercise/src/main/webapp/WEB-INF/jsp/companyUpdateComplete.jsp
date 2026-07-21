<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了画面</title>
</head>
<body>
<h1>更新完了しました</h1>

<form action="<%= request.getContextPath() %>/CompanyListServlet" method="get">
    <button type="submit">企業管理画面に戻る</button>
</body>
</html>