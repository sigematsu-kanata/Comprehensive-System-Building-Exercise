<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<h1>登録完了しました</h1>

<form action="<%= request.getContextPath() %>/company/list" method="get">
    <button type="submit">企業管理画面に戻る</button>
</form>

</body>
</html>