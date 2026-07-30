<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="syuusyokuhyou.model.ReportCount" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>活動報告書</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            font-family: "Helvetica Neue", Arial, "Hiragino Kaku Gothic ProN", "Hiragino Sans", "Meiryo", sans-serif;
            margin: 20px;
            background-color: #f8f9fa;
            color: #333;
        }

        /* 全体レイアウト */
        .container {
            width: 900px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
        }

        /* 画面タイトルヘッダー */
        .header {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            padding: 12px 0;
            border-top: 2px solid #333;
            border-bottom: 2px solid #333;
            margin-bottom: 25px;
            letter-spacing: 2px;
        }

        .action-links {
            margin-bottom: 25px;
        }

        .main-content {
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 20px;
        }

        /* ボタン共通スタイル */
        .btn {
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            text-decoration: none;
            border-radius: 6px;
            transition: all 0.2s ease;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            box-sizing: border-box;
        }

        .btn:hover {
            opacity: 0.9;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.15);
        }

        .btn:active {
            transform: translateY(0);
            box-shadow: 0 1px 2px rgba(0,0,0,0.1);
        }

        /* 個別ボタンカラー・サイズ定義 */
        /* 作業選択ボタン */
        .btn-gray {
            background-color: #6c757d;
            color: #ffffff;
            border: 1px solid #5a6268;
            padding: 8px 20px;
            height: 42px;
        }

        /* クラス検索ボタン */
        .btn-class {
            background-color: #0d6efd;
            color: #ffffff;
            border: 1px solid #0b5ed7;
            width: 130px;
            height: 120px;
            font-size: 16px;
        }

        /* 印刷ボタン */
        .btn-print {
            background-color: #198754;
            color: #ffffff;
            border: 1px solid #157347;
            width: 140px;
            height: 180px;
            font-size: 18px;
        }

        /* テーブルスタイル */
        .report-table {
            border-collapse: collapse;
            text-align: center;
            background-color: #fff;
            flex-grow: 1;
            margin: 0 10px;
        }

        .report-table th, 
        .report-table td {
            border: 1px solid #333;
            padding: 10px 15px;
            font-size: 15px;
            min-width: 80px;
        }

        .report-table th {
            background-color: #000000;
        }

        /* 印刷設定 (印刷時にはボタン類を非表示) */
        @media print {
            body {
                background-color: #fff;
            }
            .container {
                box-shadow: none;
                padding: 0;
            }
            .btn, .action-links {
                display: none !important;
            }
            .header {
                border-top: 2px solid #000;
                border-bottom: 2px solid #000;
            }
        }
    </style>
</head>
<body>
<%
ReportCount rc = (ReportCount)request.getAttribute("reportList");
String from = (String)request.getAttribute("from");
%>
    <div class="header">Job Hunting Management System - 活動状況報告書</div>
    <div class="container">
        <!-- 画面タイトル -->
		

        <!-- 作業選択ボタン -->
        <div class="action-links">
            <a class="btn btn-gray" href="<%= request.getContextPath() %>/index.jsp" title="このサブシステムの範囲外の画面です">作業選択</a>
        </div>

        <!-- メインエリア（クラス検索 / 集計テーブル / 印刷） -->
        <div class="main-content">
            
            <!-- クラス検索ボタン -->
            <div>
                <form action=ReportServlet method="post">
                	<input type="text" name="keyword" placeholder="検索欄" style="width: 120px;">
                    <button type="submit" class="btn btn-class">クラス検索</button>
                </form>
            </div>

            <!-- 集計結果テーブル -->
            <table class="report-table">
                <thead>
                    <tr>
                        <!-- 日付表示エリア -->
                        <%-- <th colspan="4">
                            <c:out value="${reportData.currentDate}" default="日付" />
                        </th> --%>
                    </tr>
                    <tr>
                    	<th><%= from %></th>
                        <!-- クラス名表示エリア -->
                        <th colspan="3">人数:<%= rc.getCount() %>(男性<%= rc.getMcount() %>:女性<%= rc.getWcount() %>)</th>
                    </tr>
                    <tr>
                        <!-- テーブルヘッダー項目 -->
                        <th></th>
                        <th>合計</th>
                        <th>男</th>
                        <th>女</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>受験者数</th>
                        <td><%= rc.getCount5() %></td>
                        <td><%= rc.getMcount5() %></td>
                        <td><%= rc.getWcount5() %></td>
                    </tr>
                    <tr>
                        <th>内定者数</th>
                        <td><%= rc.getCount2() %></td>
                        <td><%= rc.getMcount2() %></td>
                        <td><%= rc.getWcount2() %></td>
                    </tr>
                    <tr>
                        <th>不合格者数</th>
                        <td><%= rc.getCount3() %></td>
                        <td><%= rc.getMcount3() %></td>
                        <td><%= rc.getWcount3() %></td>
                    </tr>
                    <tr>
                        <th>内定率</th>
                        <td><%= rc.getCount4() %></td>
                        <td><%= rc.getMcount4() %></td>
                        <td><%= rc.getWcount4() %></td>
                    </tr>
                </tbody>
            </table>

            <!-- 印刷ボタン -->
            <div>
                <button type="button" class="btn btn-print" onclick="window.print();">印刷</button>
            </div>

        </div>
    </div>

</body>
</html>