package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kigyou.model.Company;

//DBのcompanyテーブルに対して
//検索・追加・更新・削除を行う

public class CompanyDao{
	
	//全体収得（企業管理画面用）
	public List<Company> findAll(){
		List<Company> list = new ArrayList<>();
		String sql = "SELECT * FROM company ORDER BY company_id";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
			//１行ずつCompanyに詰めてリストに追加
			while(rs.next()) {
				Company c = new Company();
				c.setCompany_name(rs.getString("company_name"));
				c.setalias_name(rs.getString("alias_name"));
				c.setCompany_id(rs.getInt("company_id"));
				c.setPostal_code(rs.getInt("postal_code"));
				c.setCompany_address(rs.getString("company_address"));	
				c.setPhone_number(rs.getString("phone_number"));
				c.setMail_address(rs.getString("mail_address"));
				c.setPerson_name(rs.getString("person_name"));
				c.setRecruitmentrecord(rs.getString("recruitmentrecord"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//主キーで１件取得（更新・削除確認用）
	public Company findById(int id) {
		Company c = null;
		String sql = "SELECT * FROM company WHERE company_id=?";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Company();
				c.setCompany_name(rs.getString("company_name"));
				c.setalias_name(rs.getString("alias_name"));
				c.setCompany_id(rs.getInt("company_id"));
				c.setPostal_code(rs.getInt("postal_code"));
				c.setCompany_address(rs.getString("company_address"));
				c.setPhone_number(rs.getString("phone_number"));
				c.setMail_address(rs.getString("mail_address"));
				c.setPerson_name(rs.getString("person_name"));
				c.setRecruitmentrecord(rs.getString("recruitmentrecord"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	//新規登録
	public int insert(Company c) {
		//company_idはDB側で自動割り当て想定
		String sql = "INSERT INTO company("
				   + "company_name, alias_name, company_id, postal_code, company_address,"
				   + "phone_number, mail_address, person_name, recruitmentrecord"
				   + ") VALUES(?,?,?,?,?,?,?,?)";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, c.getCompany_name());
			ps.setString(2, c.alias_name());
			ps.setInt(3, c.getPostal_code());
			ps.setString(4, c.getCompany_address());
			ps.setString(5, c.getPhone_number());
			ps.setString(6, c.getMail_address());
			ps.setString(7, c.getPerson_name());
			ps.setString(8, c.getRecruitmentrecord());
			
			//追加件数（通常１）が返る
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
				
	}
	
	//更新
	public int updata(Company c) {
		String sql = "UPDATE company SET"
				   + "company_name=?, alias_name=?, postal_code=?, company_address=?"
				   + "phone_number=?, mail_address=?, person_name=?, recruitmentrecord=?"
				   + "WHERE company_id=?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, c.getCompany_name());
			ps.setString(2, c.alias_name());
			ps.setInt(3, c.getPostal_code());
			ps.setString(4, c.getCompany_address());
			ps.setString(5, c.getPhone_number());
			ps.setString(6, c.getMail_address());
			ps.setString(7, c.getPerson_name());
			ps.setString(8, c.getRecruitmentrecord());
			ps.setInt(9, c.getCompany_id());
			
			return ps.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//削除
	public int delete(int id) {
		String sql = "DELETE FROM company WHERE company_id=?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	private Connection getConnection() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}