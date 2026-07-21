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
 *   student_table            : 学生情報テーブル
 *   class_table         : クラステーブル
 *
 * 列名対応（DB → 画面入出力項目一覧の項目名）
 *   student_nunber      出席番号
 *   student_class		クラス
 */
public class ClassDAO {
	
	private static final String BASE_SELECT =
            "SELECT student_class " +
            "FROM  class_table ";
	
	public List<StudentBean> findClass(int AttendanceNo) throws SQLException {
			String sql = BASE_SELECT;
			 boolean hasAttendanceNo = AttendanceNo != 0;
			 
			 System.out.println("stert");
			if (hasAttendanceNo) {
				
				System.out.println("if stert");
				sql += "WHERE student_nunber  LIKE ? ";
	        }
			
			System.out.println("in end");
			List<StudentBean> student_class = new ArrayList<>();
			try (Connection con = DBManager.getConnection();	
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            if (hasAttendanceNo) {
	            	
	            	System.out.println("try if stert");
	                ps.setString(1, "%" + AttendanceNo + "%");
	                System.out.println(sql);
	                System.out.println(ps);
	            }
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	
	                	System.out.println("try while stert");
	                	student_class.add(mapRow(rs));
	                }
	            }
	        }
			System.out.println("end");
		return student_class;
		
	}
	private StudentBean mapRow(ResultSet rs) throws SQLException {
        StudentBean bean = new StudentBean();
        bean.setClassName(rs.getString("student_class"));
        return bean;
    }


}
