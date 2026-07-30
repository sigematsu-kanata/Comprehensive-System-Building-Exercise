package syuusyoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import syuusyoku.model.Employment;

public class Employment_upDao {
	public int upList(Employment newEmployment, Employment oldEmployment) {
        int result = -1;

        String sql = "UPDATE employment_table SET student_id=?, company_id=?, activity_situation=?, introduction=?, prefecture=?, region=?, information_date=?, exam_date1=?, exam_date2=?, exam_date3=?, finel=?, memo=? WHERE student_id = ? AND company_id = ?";

        try {
            InitialContext initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/korotok");

            try (Connection conn = ds.getConnection();
                 PreparedStatement pStmt = conn.prepareStatement(sql)) {

                // SET句のパラメータ設定 (1 ~ 12) -> 新しい値をセット
                pStmt.setInt(1, newEmployment.getStudentId());
                pStmt.setInt(2, newEmployment.getCompanyId());
                pStmt.setString(3, newEmployment.getActivitySituation());
                pStmt.setString(4, newEmployment.getIntroduction());
                pStmt.setString(5, newEmployment.getPrefecture());
                pStmt.setString(6, newEmployment.getRegion());
                setDateOrNull(pStmt, 7, newEmployment.getInformation_date());
                setDateOrNull(pStmt, 8, newEmployment.getExam_date1());
                setDateOrNull(pStmt, 9, newEmployment.getExam_date2());
                setDateOrNull(pStmt, 10, newEmployment.getExam_date3());
                setDateOrNull(pStmt, 11, newEmployment.getfinel());
                pStmt.setString(12, newEmployment.getmemo());

                // WHERE句の条件パラメータ設定 (13, 14) -> 元（旧）のキーをセット
                pStmt.setInt(13, oldEmployment.getStudentId());
                pStmt.setInt(14, oldEmployment.getCompanyId());

                // 更新を実行 (成功した行数が返る)
                result = pStmt.executeUpdate();
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void setDateOrNull(PreparedStatement pStmt, int index, String value) throws SQLException {
        if (value == null || value.trim().isEmpty()) {
            pStmt.setNull(index, Types.DATE);
        } else {
            pStmt.setString(index, value);
        }
    }
}