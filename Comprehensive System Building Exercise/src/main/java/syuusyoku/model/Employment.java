package syuusyoku.model;

public class Employment {
	private int student_id; //学籍番号
	private int company_id;  //企業番号
	private String activity_situation;    //就職状態
	private String introduction;  //紹介区分
	private String prefecture; //県内外
	private String region; //地域
	private String information_date; //説明会日
	private String exam_date1; //一次試験
	private String exam_date2; //二次試験
	private String exam_date3;//三次試験
	private String finel;//最終結果
	private String memo;//
	
	public Employment(int student_id, int company_id, String activity_situation, String introduction, String prefecture, String region, String information_date, String exam_date1, String exam_date2, String exam_date3, String finel, String memo) {
		this.student_id = student_id;
		this.company_id = company_id;
		this.activity_situation = activity_situation;
		this.introduction = introduction;
		this.prefecture = prefecture;
		this.region = region;
		this.information_date = information_date;
		this.exam_date1 = exam_date1;
		this.exam_date2 = exam_date2;
		this.exam_date3 = exam_date3;
		this.finel = finel;
		this.memo = memo;
	}
	public Employment() {
	}
	
	public int getStudentId() { return student_id; }
    public void setStudentId(int studentId) { this.student_id = studentId; }

    public int getCompanyId() { return company_id; }
    public void setCompanyId(int companyId) { this.company_id = companyId; }

    public String getActivitySituation() { return activity_situation; }
    public void setActivitySituation(String activity_situation) { this.activity_situation = activity_situation; }

    public String getIntroduction() { return introduction; }
    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getPrefecture() { return prefecture; }
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getInformation_date() { return information_date; }
    public void setInformation_date(String informationDate) { this.information_date = informationDate; }

    public String getExam_date1() { return exam_date1; }
    public void setExam_date1(String exam_date1) { this.exam_date1 = exam_date1; }

    public String getExam_date2() { return exam_date2; }
    public void setExam_date2(String exam_date2) { this.exam_date2 = exam_date2; }

    public String getExam_date3() { return exam_date3; }
    public void setExam_date3(String exam_date3) { this.exam_date3 = exam_date3; }
    
    public String getfinel() { return finel; }
    public void setfinel(String finel) { this.finel = finel; }
    
    public String getmemo() { return memo; }
    public void setmemo(String memo) { this.memo = memo; }
    
	
	
}