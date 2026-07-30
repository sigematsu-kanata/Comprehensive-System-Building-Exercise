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
		String sql = "SELECT * FROM employment_table ORDER BY student_id";
		
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public List<Employment> findByClass(String from, String keyword) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public List<Employment> findById(String from, String keyword) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public List<Employment> findByDate(String from, String keyword) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
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
}
