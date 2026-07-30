package syuusyokuhyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import syuusyokuhyou.model.CSClass;
import syuusyokuhyou.model.Report;
public class ReportDao {
	
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
		
	public List<Report> findAll() {
		String sql = "SELECT s.student_id, s.student_nunber, s.jender, s.enrollment_status, e.activity_situation FROM student_table AS s LEFT JOIN employment_table AS e ON s.student_id = e.student_id WHERE s.enrollment_status = '在籍' ORDER BY s.student_id DESC, FIELD(e.activity_situation, '内定確定', '内定保留', '落ちた', '内定後不採用');";
        
        List<Report> reportList = new ArrayList<>();
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Report r = new Report();
                
                r.setStudent_id(rs.getInt("student_id"));
                r.setStudent_nunber(rs.getInt("student_nunber"));
                r.setJender(rs.getString("jender"));
                r.setEnrollment_status(rs.getString("enrollment_status"));
                r.setActivity_situation(rs.getString("activity_situation"));   
                
                reportList.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return reportList;
    }
    
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/korotok?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo",
                "root",
                "kcsf"
        );
    }
    public List<Report> find(String a) {
		String sql = "SELECT s.student_id, s.student_nunber, s.jender, s.enrollment_status, e.activity_situation FROM student_table AS s LEFT JOIN employment_table AS e ON s.student_id = e.student_id WHERE s.enrollment_status = '在籍' AND s.student_nunber LIKE ? ORDER BY s.student_id DESC, FIELD(e.activity_situation, '内定確定', '内定保留', '落ちた', '内定後不採用');";
        
        List<Report> reportList = new ArrayList<>();
        
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
               
               // 2. パラメータをセット（tryのブロック内で行う）
               ps.setString(1, a + "%");
               
               // 3. 実行して ResultSet を取得
               try (ResultSet rs = ps.executeQuery()) {
                   while (rs.next()) {
                       Report r = new Report();
                       
                       r.setStudent_id(rs.getInt("student_id"));
                       r.setStudent_nunber(rs.getInt("student_nunber"));
                       r.setJender(rs.getString("jender"));
                       r.setEnrollment_status(rs.getString("enrollment_status"));
                       r.setActivity_situation(rs.getString("activity_situation"));   
                       
                       reportList.add(r);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           return reportList;
       }
}