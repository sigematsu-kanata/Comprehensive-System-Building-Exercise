package model;

public class Company{
	private String company_name; //企業名
	private String alias_name;  //企業別名
	private int company_id;    //企業番号
	private int postal_code;  //郵便番号
	private String company_address; //住所
	private String phone_number; //電話番号
	private String mail_address; //メールアドレス
	private String person_name; //担当者名
	private String recruitmentrecord; //採用実績
	
	//以下、getter/setter
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String alias_name() {
		return alias_name;
	}
	public void setalias_name(String alias_name) {
		this.alias_name = alias_name;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getRecruitmentrecord() {
		return recruitmentrecord;
	}
	public void setRecruitmentrecord(String recruitmentrecord) {
		this.recruitmentrecord = recruitmentrecord;
	}
	
	
}