package kigyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gakusei.dao.DBManager;
import kigyou.bean.CompanyBean;

//DBのcompanyテーブルに対して
//検索・追加・更新・削除を行う

public class CompanyDao{
	
	//企業名検索
	public List<CompanyBean> findByName(String keyword) throws SQLException{
		List<CompanyBean> list = new ArrayList<>();
		String sql = "SELECT * FROM company_table ";
		boolean hasKeyword = keyword != null && !keyword.isEmpty();
		boolean muchKeyword = false;
		if(hasKeyword) {
			muchKeyword = keyword.matches("-?\\d+");//数列か判断
		}
		if (muchKeyword) {
			sql += "WHERE company_id LIKE ? ";
		}else if(hasKeyword) {
            sql += "WHERE company_name LIKE ? ";
        }
        sql += "ORDER BY company_id";
        try (Connection con = DBManager.getConnection();	
                PreparedStatement ps = con.prepareStatement(sql)) {
        		
               if (hasKeyword) {
                   ps.setString(1, "%" + keyword + "%");
               }else if(muchKeyword) {
            	   ps.setString(1, "%" + keyword + "%");
               }
               try (ResultSet rs = ps.executeQuery()) {
                   while (rs.next()) {
                       list.add(mapRow(rs));
                   }
               }
           }
		return list;
	}
	
	
	private CompanyBean mapRow(ResultSet rs) throws SQLException {
		CompanyBean bean = new CompanyBean();
		
		bean.setCompany_name(rs.getString("company_name"));
		bean.setAlias_name(rs.getString("alias_name"));
		bean.setCompany_id(rs.getInt("company_id"));
		bean.setPostal_code(rs.getString("postal_code"));
		bean.setCompany_address(rs.getString("company_address"));
		bean.setPhone_number(rs.getString("phone_number"));
		bean.setMail_address(rs.getString("mail_address"));
		bean.setPerson_name(rs.getString("person_name"));
		bean.setRecruitment_record(rs.getString("recruitment_record"));
		
		
        return bean;
    }






	//全体収得（企業管理画面用）
	public List<CompanyBean> findAll(){
		List<CompanyBean> list = new ArrayList<>();
		String sql = "SELECT * FROM company ORDER BY company_id";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
			//１行ずつCompanyに詰めてリストに追加
			while(rs.next()) {
				CompanyBean bean = new CompanyBean();
				bean.setCompany_name(rs.getString("company_name"));
				bean.setAlias_name(rs.getString("alias_name"));
				bean.setCompany_id(rs.getInt("company_id"));
				bean.setPostal_code(rs.getString("postal_code"));
				bean.setCompany_address(rs.getString("company_address"));	
				bean.setPhone_number(rs.getString("phone_number"));
				bean.setMail_address(rs.getString("mail_address"));
				bean.setPerson_name(rs.getString("person_name"));
				bean.setRecruitment_record(rs.getString("recruitment_record"));
				list.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//主キーで１件取得（更新・削除確認用）
	public CompanyBean findById(int id) throws SQLException {
		
		String sql = "SELECT * FROM company_table WHERE company_id=?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        }
        return null;
		
		/*
		CompanyBean bean = new CompanyBean();
		String sql = "SELECT * FROM company_table WHERE company_id=?";
		
		System.out.println("start");
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			System.out.println("try");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("try if");
				System.out.println(rs.getString("company_name"));
				
				bean.setCompany_name(rs.getString("company_name"));
				bean.setAlias_name(rs.getString("alias_name"));
				bean.setCompany_id(rs.getInt("company_id"));
				bean.setPhone_number(rs.getString("postal_code"));
				bean.setCompany_address(rs.getString("company_address"));
				bean.setPhone_number(rs.getString("phone_number"));
				bean.setMail_address(rs.getString("mail_address"));
				bean.setPerson_name(rs.getString("person_name"));
				bean.setRecruitment_record(rs.getString("recruitmentrecord"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
		*/
	}
	
	//新規登録
	public void insert(CompanyBean bean) throws SQLException {
		//company_idはDB側で自動割り当て想定
		String sql = "INSERT INTO company_table"
				   + "(company_name, alias_name, postal_code, company_address, "
				   + "phone_number, mail_address, person_name, recruitment_record) "
				   + "VALUES(?,?,?,?,?,?,?)";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, bean.getCompany_name());
			ps.setString(2, bean.getAlias_name());
			ps.setString(3, bean.getPostal_code());
			ps.setString(4, bean.getCompany_address());
			ps.setString(5, bean.getPhone_number());
			ps.setString(6, bean.getMail_address());
			ps.setString(7, bean.getPerson_name());
			ps.setString(8, bean.getRecruitment_record());
			
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//更新
	public void updata(CompanyBean bean) throws SQLException{
		String sql = "UPDATE company_table SET"
				   + "company_name=?, alias_name=?, postal_code=?, company_address=?, "
				   + "phone_number=?, mail_address=?, person_name=?, recruitment_record=? "
				   + "WHERE company_id=?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, bean.getCompany_name());
			ps.setString(2, bean.getAlias_name());
			ps.setString(3, bean.getPostal_code());
			ps.setString(4, bean.getCompany_address());
			ps.setString(5, bean.getPhone_number());
			ps.setString(6, bean.getMail_address());
			ps.setString(7, bean.getPerson_name());
			ps.setString(8, bean.getRecruitment_record());
			ps.setInt(9, bean.getCompany_id());
			
			ps.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//削除
	public void delete(int id) throws SQLException{
		String sql = "DELETE FROM company_table WHERE company_id=?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private Connection getConnection() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}