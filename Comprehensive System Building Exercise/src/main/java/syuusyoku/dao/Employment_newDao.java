package syuusyoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import syuusyoku.model.Employment;

public class Employment_newDao {
	public int setList(Employment EmploymentList){
		int result = -1;
		String sql = "INSERT INTO employment_table (student_id, company_id, activity_situation, introduction, prefecture, region, information_date, exam_date1, exam_date2, exam_date3, finel, memo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
            // 1. JNDIルックアップ
            InitialContext initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/korotok");

            // 2. データベース接続 & ステートメント作成（どちらも自動クローズ）
            try (Connection conn = ds.getConnection();
                 PreparedStatement pStmt = conn.prepareStatement(sql)) {

                pStmt.setInt(1, EmploymentList.getStudentId());
                pStmt.setInt(2, EmploymentList.getCompanyId());
                pStmt.setString(3, nullIfEmpty(EmploymentList.getActivitySituation()));
                pStmt.setString(4, nullIfEmpty(EmploymentList.getIntroduction()));
                pStmt.setString(5, nullIfEmpty(EmploymentList.getPrefecture()));
                pStmt.setString(6, nullIfEmpty(EmploymentList.getRegion()));
                pStmt.setString(7, nullIfEmpty(EmploymentList.getInformation_date()));
                pStmt.setString(8, nullIfEmpty(EmploymentList.getExam_date1()));
                pStmt.setString(9, nullIfEmpty(EmploymentList.getExam_date2()));
                pStmt.setString(10, nullIfEmpty(EmploymentList.getExam_date3()));
                pStmt.setString(11, nullIfEmpty(EmploymentList.getfinel()));
                pStmt.setString(12, nullIfEmpty(EmploymentList.getmemo()));

                System.out.println("DAO処理実行: 学籍番号 " + EmploymentList.getStudentId());

                // SQL実行 (成功すると追加された件数「1」が返る)
                result = pStmt.executeUpdate();
            }

        } catch (NamingException e) {
            System.err.println("JNDIルックアップエラー: データソースが見つかりません。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベース操作エラー: SQLの実行に失敗しました。");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 文字列が null または空文字の場合に null を返すヘルパーメソッド
     */
    private String nullIfEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        return str;
    }
}
