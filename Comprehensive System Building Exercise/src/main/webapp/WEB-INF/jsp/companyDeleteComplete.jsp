<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
</head>
<body>
<h1>削除完了しました</h1>

<form action="<%= request.getContextPath() %>/company/list" method="get">
    <button type="submit">戻る</button>
</form>
</body>
</html>