<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="syuusyoku.model.Employment" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>就職管理システム - 指導画面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="header">就職管理管理</div>

<div class="container">
    <h2>就職管理画面</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="error"><%= errorMessage %></div>
    <% } %>

    <div class="action-links">
    	<form action="<%= request.getContextPath() %>/EmploymentInsertServlet" method="get">
        <a class="btn btn-gray" href="<%= request.getContextPath() %>/index.jsp" title="このサブシステムの範囲外の画面です">作業選択</a>
        <button type="submit" class="btn">新規登録</button>
        </form>
    </div>

	<form class="search-box" action="EmploymentListServlet" method="get">
		<input type="hidden" name="search" value="name">
        検索（氏名・クラス・学籍番号）：
        <input type="text" name="keyword" value="<%= request.getAttribute("keyword") == null ? "" : request.getAttribute("keyword") %>">
        <button type="submit" class="btn">検索</button>
    </form>
    
    <form class="search-box" action="EmploymentListServlet" method="get">
    	<input type="hidden" name="search" value="date">
        検索（日付）：
        <input type="date" name="keyword" value="<%= request.getAttribute("keyword") == null ? "" : request.getAttribute("keyword") %>">
        <button type="submit" class="btn">検索</button>
    </form>
    
    <table>
        <tr>
                    <th class="sticky-left col-class">学籍番号</th>
                    <th>企業番号</th>
                    <th>就職状況</th>
                    <th>紹介区分</th>
                    <th>地域</th>
                    <th>県内外志望</th>
                    <th>説明会</th>
                    <th>1次試験</th>
                    <th>2次試験</th>
                    <th>最終選考</th>
                    <th>結果判明日</th>
                    <th>備考</th>
                    <th class="sticky-right col-update">更新</th>
                    <th class="sticky-right col-delete">削除</th>
                </tr>
                
            	<%
            	int count = 0;
            	@SuppressWarnings("unchecked")
                List<Employment> list = (List<Employment>) request.getAttribute("Employment");
                if (list != null) {
                    for (Employment e : list) {
            	%>
            	<tr>
                    <td><%= e.getStudentId() %></td>
                    <td><%= e.getCompanyId() %></td>
                    <td><%= e.getActivitySituation() %></td>
                    <td><%= e.getIntroduction() %></td>
                    <td><%= e.getPrefecture() %></td>
                    <td><%= e.getRegion() %></td>
                    <td><%= e.getInformation_date() == null ? "" : e.getInformation_date() %></td>
                    <td><%= e.getExam_date1() == null ? "" : e.getExam_date1() %></td>
                    <td><%= e.getExam_date2() == null ? "" : e.getExam_date2() %></td>
                    <td><%= e.getExam_date3() == null ? "" : e.getExam_date3() %></td>
                    <td><%= e.getfinel() == null ? "" : e.getfinel() %></td>
                    <td><%= e.getmemo() == null ? "" : e.getmemo() %></td>
                
            	<form action="<%= request.getContextPath() %>/EmploymentUpdataServlet" method="post">
                	<input type="hidden" name="count" value=<%= count %>>
                    <input type="hidden" name="a" value=<%= e.getStudentId() %>>
                    <input type="hidden" name="b" value=<%= e.getCompanyId() %>>
                    <input type="hidden" name="c" value=<%= e.getActivitySituation() %>>
                    <input type="hidden" name="d" value=<%= e.getIntroduction() %>>
                    <input type="hidden" name="e" value=<%= e.getPrefecture() %>>
                    <input type="hidden" name="f" value=<%= e.getRegion() %>>
                    <input type="hidden" name="g" value=<%= e.getInformation_date() %>>
                    <input type="hidden" name="h" value=<%= e.getExam_date1() %>>
                    <input type="hidden" name="i" value=<%= e.getExam_date2() %>>
                    <input type="hidden" name="j" value=<%= e.getExam_date3() %>>
                    <input type="hidden" name="k" value=<%= e.getfinel() %>>
                    <input type="hidden" name="n" value=<%= e.getmemo() %>>
                    <td><button type="submit" class="action-btn">更新</button></td>
                </form>
                    
                    
                    <form action="<%= request.getContextPath() %>/EmploymentDropServlet" method="post">
                   <input type="hidden" name="count" value=<%= count %>>
                    <input type="hidden" name="a" value=<%= e.getStudentId() %>>
                    <input type="hidden" name="b" value=<%= e.getCompanyId() %>>
                    <input type="hidden" name="c" value=<%= e.getActivitySituation() %>>
                    <input type="hidden" name="d" value=<%= e.getIntroduction() %>>
                    <input type="hidden" name="e" value=<%= e.getPrefecture() %>>
                    <input type="hidden" name="f" value=<%= e.getRegion() %>>
                    <input type="hidden" name="g" value=<%= e.getInformation_date() %>>
                    <input type="hidden" name="h" value=<%= e.getExam_date1() %>>
                    <input type="hidden" name="i" value=<%= e.getExam_date2() %>>
                    <input type="hidden" name="j" value=<%= e.getExam_date3() %>>
                    <input type="hidden" name="k" value=<%= e.getfinel() %>>
                    <input type="hidden" name="n" value=<%= e.getmemo() %>>
                    <td><button type="submit" class="action-btn">削除</button></td>
                    </form>
                    </tr>
                <%
                	count++;
                	}
             	}
                %>
               
        </table>
    </div>

</body>
</html>