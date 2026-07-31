<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>作業選択画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 作業選択</div>
<div class="container">
    <h2>作業選択画面</h2>
    <form action="GakuseiList" method="post">
    	<button type="submit" class="btn">学生</button><br><br>
    </form>
    <form action="CompanyListServlet" method="post">
    	<button type="submit" class="btn">企業</button><br><br>
    </form>
    <form action="EmploymentListServlet" method="post">
    	<button type="submit" class="btn">就職</button><br><br>
    </form>
    <form action="ReportServlet" method="post">
    	<button type="submit" class="btn">活動報告書</button><br><br>
    </form>
</div>
</body>
</html>
