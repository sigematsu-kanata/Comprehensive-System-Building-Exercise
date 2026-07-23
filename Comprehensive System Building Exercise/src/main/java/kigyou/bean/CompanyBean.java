package kigyou.bean;

import java.io.Serializable;

public class CompanyBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String company_name;//会社名
	private String alias_name;//別名
	private int company_id;//会社ID
	private String postal_code;//郵便番号
	private String company_address;//会社の住所
	private String phone_number;//電話番号
	private String mail_address;//メールアドレス
	private String person_name;//人の名前
	private String recruitment_record;//採用記録

	
	public String getCompany_name() {return company_name;}
	public void setCompany_name(String company_name) {this.company_name = company_name;}
	
	public String getAlias_name() {return alias_name;}
	public void setAlias_name(String alias_name) {this.alias_name = alias_name;}
	
	public int getCompany_id() {return company_id;}
	public void setCompany_id(int company_id) {this.company_id = company_id;}
	
	public String getPostal_code() {return postal_code;}
	public void setPostal_code(String postal_code) {this.postal_code = postal_code;}
	
	public String getCompany_address() {return company_address;}
	public void setCompany_address(String company_address) {this.company_address = company_address;}
	
	public String getPhone_number() {return phone_number;}
	public void setPhone_number(String phone_number) {this.phone_number = phone_number;}
	
	public String getMail_address() {return mail_address;}
	public void setMail_address(String mail_address) {this.alias_name = mail_address;}
	
	public String getPerson_name() {return person_name;}
	public void setPerson_name(String person_name) {this.person_name = person_name;}
	
	public String getRecruitment_record() {return recruitment_record;}
	public void setRecruitment_record(String recruitment_record) {this.recruitment_record = recruitment_record;}

}
