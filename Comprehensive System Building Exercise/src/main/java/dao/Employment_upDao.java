package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Employment;

public class Employment_upDao {
	public int upList(Employment EmploymentList){
		int resurt = -1;
		Employment Employment = EmploymentList;
			String sql = "UPDATE employment_table SET student_id=?, company_id=?, activity_situation=?, introduction=?, prefecture=?, region=?, information_date=?, exam_date1=?, exam_date2=?, exam_date3=?, finel=?, memo=? WHERE student_id = ? AND company_id = ?";
			// JNDI参照とDB接続・ステートメント発行をひとつの try-with-resources にまとめる
	        try {
	            InitialContext initCtx = new InitialContext();
	            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/korotok");

	            try (Connection conn = ds.getConnection();
	                 PreparedStatement pStmt = conn.prepareStatement(sql)) {

	                // SET句のパラメータ設定 (1 ~ 10)
	            	pStmt.setInt(1, Employment.getStudentId());
	                pStmt.setInt(2, Employment.getCompanyId());
	                pStmt.setString(3, Employment.getActivitySituation());
	                pStmt.setString(4, Employment.getIntroduction());
	                pStmt.setString(5, Employment.getPrefecture());
	                pStmt.setString(6, Employment.getRegion());
	                setDateOrNull(pStmt, 7, Employment.getInformation_date());
	                setDateOrNull(pStmt, 8, Employment.getExam_date1());
	                setDateOrNull(pStmt, 9, Employment.getExam_date2());
	                setDateOrNull(pStmt, 10, Employment.getExam_date3());
	                setDateOrNull(pStmt, 11, Employment.getfinel());
	                pStmt.setString(12, Employment.getmemo());

	                // WHERE句の条件パラメータ設定 (11, 12)
	                pStmt.setInt(13, Employment.getStudentId());
	                pStmt.setInt(14, Employment.getCompanyId());

	                // 更新を実行 (成功した行数が返る)
	                resurt = pStmt.executeUpdate();
	            }

	        } catch (NamingException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return resurt;
	    }
	private void setDateOrNull(PreparedStatement pStmt, int index, String value) throws SQLException {
        if (value == null || value.trim().isEmpty()) {
            pStmt.setNull(index, Types.DATE);
        } else {
            pStmt.setString(index, value);
        }
    }
}