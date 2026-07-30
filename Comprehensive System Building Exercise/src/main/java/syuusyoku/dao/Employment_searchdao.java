package syuusyoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import syuusyoku.model.Employment;

public class Employment_searchdao {

	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/korotok?useSSL=false&serverTimezone=Asia/Tokyo",
				"root",
				"kcsf"
		);
	}
	public List<Employment> findBy(String From ,String keyword) {
		List<Employment> list = new ArrayList<>();
		String from = From;
		String key = keyword;
		String sql = "";
		if(from.equals("s_id")) {
			sql = "SELECT * FROM employment_table WHERE student_id=? ORDER BY student_id";
		}else if(from.equals("c_id")) {
			sql = "SELECT * FROM employment_table WHERE company_id=? ";
		}else if(from.equals("date")) {
			sql = "SELECT * FROM employment_table WHERE information_date=? or exam_date1=? or exam_date2=? or exam_date3=? ORDER BY student_id";
		}else if(from.equals("name")) {
			//sql = "information_date=? or exam_date1=? or exam_date2=? or exam_date3=? or finel=?";
		}
		try (Connection con = getConnection();
			     PreparedStatement ps = con.prepareStatement(sql)) {

			    // パラメータの設定やクエリの実行は try のブロック内に記述します
			    ps.setString(1, key);
			    try (ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				Employment e = new Employment();
				e.setStudentId(rs.getInt("student_id"));
				e.setCompanyId(rs.getInt("company_id"));
				e.setActivitySituation(rs.getString("activity_situation"));
				e.setIntroduction(rs.getString("introduction"));	
				e.setPrefecture(rs.getString("prefecture"));
				e.setRegion(rs.getString("region"));
				e.setInformation_date(rs.getString("information_date"));
				e.setExam_date1(rs.getString("exam_date1"));
				e.setExam_date2(rs.getString("exam_date2"));
				e.setExam_date3(rs.getString("exam_date3"));
				e.setfinel(rs.getString("finel"));
				e.setmemo(rs.getString("memo"));
				
				list.add(e);
			}
			    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
