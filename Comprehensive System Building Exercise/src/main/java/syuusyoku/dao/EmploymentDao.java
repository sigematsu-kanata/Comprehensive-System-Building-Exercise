package syuusyoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import syuusyoku.model.CSClass;
import syuusyoku.model.Employment;

public class EmploymentDao {
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/korotok?useSSL=false&serverTimezone=Asia/Tokyo",
				"root",
				"kcsf"
		);
	}
	public List<Employment> findall(){
		List<Employment> list = new ArrayList<>();
		String sql = "SELECT s.student_id AS s_student_id, s.student_name, e.* FROM employment_table e LEFT JOIN student_table s ON e.student_id = s.student_id ORDER BY e.student_id";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
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
				e.setName(rs.getString("student_name"));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean checkall(Employment e) {
	    String sql = "SELECT 1 FROM employment_table WHERE student_id = ? AND company_id = ?";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, e.getStudentId());
	        ps.setInt(2, e.getCompanyId());

	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next(); 
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return false;
	}
	
	public List<Employment> findByName(String from, String keyword) {
		List<Employment> list = new ArrayList<>();
		String sql = "SELECT s.student_id AS s_student_id, s.student_name, e.* FROM employment_table e LEFT JOIN student_table s ON e.student_id = s.student_id WHERE s.student_name=? ORDER BY e.student_id";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, keyword);

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
				e.setName(rs.getString("student_name"));
				list.add(e);
	        	}
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return list;
	}
	public List<Employment> findByClass(String from, String keyword) {
		List<Employment> list = new ArrayList<>();
		String sql = "SELECT s.student_id AS s_student_id, s.student_name, e.* FROM employment_table e LEFT JOIN student_table s ON e.student_id = s.student_id WHERE e.student_id LIKE ? ORDER BY e.student_id";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, keyword+"%");

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
					e.setName(rs.getString("student_name"));
					list.add(e);
		        	}
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return list;
	}
	public List<Employment> findById(String from, String keyword) {
		List<Employment> list = new ArrayList<>();
		String sql = "SELECT s.student_id AS s_student_id, s.student_name, e.* FROM employment_table e LEFT JOIN student_table s ON e.student_id = s.student_id WHERE e.student_id=? ORDER BY e.student_id";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, keyword);

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
					e.setName(rs.getString("student_name"));
					list.add(e);
		        	}
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return list;
	}
	public List<Employment> findByDate(String from, String keyword) {
		List<Employment> list = new ArrayList<>();
		String sql = "SELECT s.student_id AS s_student_id, s.student_name, e.* FROM employment_table e LEFT JOIN student_table s ON e.student_id = s.student_id WHERE e.information_date=? OR e.exam_date1=? OR e.exam_date2=? OR e.exam_date3=? ORDER BY e.student_id";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, keyword);
	        ps.setString(2, keyword);
	        ps.setString(3, keyword);
	        ps.setString(4, keyword);
	        
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
					e.setName(rs.getString("student_name"));
					list.add(e);
		        	}
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return list;
	}
	
	public List<CSClass> getCSClass(){
		String sql = "SELECT * FROM class_table;";
		
		List<CSClass> classlist = new ArrayList<>();
		try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	            	CSClass c = new CSClass();
	                
	                c.setCl(rs.getString("student_class"));
	                c.setSN(rs.getString("student_nunber"));
	                
	                classlist.add(c);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		return classlist;
		}
	public String findByOneName(String keyword) {
		String Name = "";
		String sql = "SELECT student_id , student_name FROM student_table WHERE student_id=?";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, keyword);

	        try (ResultSet rs = ps.executeQuery()) {
	        	if(rs.next()) {
	        		Name = rs.getString("student_name");
	        	}
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    
	    return Name;
	}
}
