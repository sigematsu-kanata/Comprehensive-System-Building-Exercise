package gakusei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gakusei.bean.StudentBean;

/**
 * 学生情報テーブル(student)に対するCRUD処理を行うDAO。
 *
 * テーブル・列名は「シス構DB.txt」の定義に準拠（綴りも原文どおり）。
 *   student            : 学生情報テーブル
 *   class_info         : クラステーブル
 *
 * 列名対応（DB → 画面入出力項目一覧の項目名）
 *   student_id          学籍番号
 *   student_nunber      出席番号
 *   student_name        氏名
 *   yomigana            読み仮名
 *   jender              性別
 *   enrollment_status   在籍状況
 *   Prefecture_choice   県内外志望
 *   job_type1/2/3       希望職種1/2/3
 *   placement_status    あっせん状況（あっせん辞退ドロップダウンの値を保持）
 */
public class StudentDAO {

    private static final String BASE_SELECT =
            "SELECT s.student_id, s.student_nunber, s.student_name, s.yomigana, s.jender, " +
            "       s.enrollment_status, s.Prefecture_choice, s.job_type1, s.job_type2, s.job_type3, " +
            "       s.placement_status, c.student_class " +
            "FROM student s LEFT JOIN class_info c ON s.student_nunber = c.student_nunber ";

    /** 全件取得（クラス名も結合して取得） */
    public List<StudentBean> findAll() throws SQLException {
        return findByName(null);
    }

    /**
     * 氏名の部分一致検索。keywordがnullまたは空文字の場合は全件取得。
     * 学籍番号の昇順で返す。
     */
    public List<StudentBean> findByName(String keyword) throws SQLException {
    	System.out.println("findByName1");
        String sql = BASE_SELECT;
        boolean hasKeyword = keyword != null && !keyword.isEmpty();
        if (hasKeyword) {
            sql += "WHERE s.student_name LIKE ? ";
        }
        sql += "ORDER BY s.student_id";

        List<StudentBean> list = new ArrayList<>();
        System.out.println("findByName2");
        try (Connection con = DBManager.getConnection();	
             PreparedStatement ps = con.prepareStatement(sql)) {
        	System.out.println("try");
            if (hasKeyword) {
                ps.setString(1, "%" + keyword + "%");
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        }
        System.out.println("re");
        System.out.println(list);
        return list;
    }

    /** 学籍番号で1件取得。存在しない場合はnull。 */
    public StudentBean findById(String studentId) throws SQLException {
        String sql = BASE_SELECT + "WHERE s.student_id = ?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(studentId));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        }
        return null;
    }

    /** 学籍番号がすでに登録済みかどうか（新規登録時の重複チェック用） */
    public boolean existsById(String studentId) throws SQLException {
        String sql = "SELECT 1 FROM student WHERE student_id = ?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(studentId));
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    /** 新規登録 */
    public void insert(StudentBean bean) throws SQLException {
        String sql = "INSERT INTO student " +
                "(student_id, student_nunber, student_name, yomigana, jender, enrollment_status, " +
                " Prefecture_choice, job_type1, job_type2, job_type3, placement_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            bindParams(ps, bean);
            ps.executeUpdate();
        }
    }

    /** 更新（学籍番号をキーに更新） */
    public void update(StudentBean bean) throws SQLException {
        String sql = "UPDATE student SET student_nunber=?, student_name=?, yomigana=?, jender=?, " +
                "enrollment_status=?, Prefecture_choice=?, job_type1=?, job_type2=?, job_type3=?, " +
                "placement_status=? WHERE student_id=?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(bean.getAttendanceNo()));
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getKana());
            ps.setString(4, bean.getGender());
            ps.setString(5, bean.getStatus());
            ps.setString(6, bean.getPrefHope());
            ps.setString(7, bean.getJob1());
            ps.setString(8, bean.getJob2());
            ps.setString(9, bean.getJob3());
            ps.setString(10, bean.getMediationDecline());
            ps.setInt(11, Integer.parseInt(bean.getStudentId()));
            ps.executeUpdate();
        }
    }

    /** 削除 */
    public void delete(String studentId) throws SQLException {
        String sql = "DELETE FROM student WHERE student_id = ?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(studentId));
            ps.executeUpdate();
        }
    }

    // ------------------------------------------------------------
    private void bindParams(PreparedStatement ps, StudentBean bean) throws SQLException {
        ps.setInt(1, Integer.parseInt(bean.getStudentId()));
        ps.setInt(2, Integer.parseInt(bean.getAttendanceNo()));
        ps.setString(3, bean.getName());
        ps.setString(4, bean.getKana());
        ps.setString(5, bean.getGender());
        ps.setString(6, bean.getStatus());
        ps.setString(7, bean.getPrefHope());
        ps.setString(8, bean.getJob1());
        ps.setString(9, bean.getJob2());
        ps.setString(10, bean.getJob3());
        ps.setString(11, bean.getMediationDecline());
    }

    private StudentBean mapRow(ResultSet rs) throws SQLException {
        StudentBean bean = new StudentBean();
        bean.setStudentId(String.valueOf(rs.getInt("student_id")));
        bean.setAttendanceNo(String.valueOf(rs.getInt("student_nunber")));
        bean.setName(rs.getString("student_name"));
        bean.setKana(rs.getString("yomigana"));
        bean.setGender(rs.getString("jender"));
        bean.setStatus(rs.getString("enrollment_status"));
        bean.setPrefHope(rs.getString("Prefecture_choice"));
        bean.setJob1(rs.getString("job_type1"));
        bean.setJob2(rs.getString("job_type2"));
        bean.setJob3(rs.getString("job_type3"));
        bean.setMediationDecline(rs.getString("placement_status"));
        bean.setClassName(rs.getString("student_class"));
        return bean;
    }
}
