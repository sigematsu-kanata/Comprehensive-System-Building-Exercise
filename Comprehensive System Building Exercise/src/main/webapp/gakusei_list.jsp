<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="gakusei.bean.StudentBean" %>
<%@	page import="gakusei.bean.ClassBeen" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>学生管理画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">Job Hunting Management System - 学生管理</div>
<div class="container">
    <h2>学生管理画面</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <div class="action-links">
        <a class="btn btn-gray" href="/index.jsp" title="このサブシステムの範囲外の画面です">作業選択</a>
        <a class="btn" href="GakuseiCreateInput">新規登録</a>
    </div>

    <form class="search-box" action="GakuseiList" method="get">
        検索（氏名・全角）：
        <input type="text" name="keyword" value="<%= request.getAttribute("keyword") == null ? "" : request.getAttribute("keyword") %>">
        <button type="submit" class="btn">検索</button>
    </form>

    <table>
        <tr>
            <th>クラス</th>
            <th>出席番号</th>
            <th>学籍番号</th>
            <th>氏名</th>
            <th>読み仮名</th>
            <th>性別</th>
            <th>在籍状況</th>
            <th>県内外志望</th>
            <th>希望職種1</th>
            <th>希望職種2</th>
            <th>希望職種3</th>
            <th>あっせん辞退</th>
            <th>操作</th>
        </tr>
        <%
            @SuppressWarnings("unchecked")
            List<StudentBean> list = (List<StudentBean>) request.getAttribute("studentList");
        	List<ClassBeen> student_class = (List<ClassBeen>) request.getAttribute("class");
            if (list != null) {
                for (StudentBean s : list) {
                	for (ClassBeen c : student_class) {
        %>
        <tr>
            <td><%= c.getClassName() == null ? "" : c.getClassName() %></td>
            <td><%= s.getAttendanceNo() %></td>
            <td><%= s.getStudentId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getKana() %></td>
            <td><%= s.getGender() %></td>
            <td><%= s.getStatus() %></td>
            <td><%= s.getPrefHope() %></td>
            <td><%= s.getJob1() %></td>
            <td><%= s.getJob2() %></td>
            <td><%= s.getJob3() %></td>
            <td><%= s.getMediationDecline() %></td>
            <td>
                <a href="GakuseiUpdateInput?studentId=<%= s.getStudentId() %>">更新</a>
                /
                <a href="GakuseiDeleteConfirm?studentId=<%= s.getStudentId() %>">削除</a>
            </td>
        </tr>
        <%
                	}
                }
            }
        %>
    </table>
</div>
</body>
</html>
