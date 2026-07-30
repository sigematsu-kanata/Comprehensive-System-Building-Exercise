package syuusyoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import syuusyoku.model.Employment;

public class Employment_dropDao {
	public int dropList(Employment EmploymentList){
		Employment employment = EmploymentList;
		int resurt = -1;
		InitialContext initCtx;
		DataSource ds = null;
		
		try {
			initCtx = new InitialContext();
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/korotok");
		}catch(NamingException e){
			e.printStackTrace();
		}
		
		try(Connection conn = ds.getConnection()){
			int student_id = employment.getStudentId();
			int company_id = employment.getCompanyId();
			String sql = "DELETE FROM employment_table WHERE student_id = ? AND company_id = ?;";
			//↑
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, student_id);
			pStmt.setInt(2, company_id);
			resurt = pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resurt;
	}
	
}
