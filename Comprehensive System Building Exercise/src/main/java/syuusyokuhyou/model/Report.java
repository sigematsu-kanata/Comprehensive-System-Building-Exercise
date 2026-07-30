package syuusyokuhyou.model;

public class Report {
	private String student_class; //
	private int student_id; //学籍番号
	private int student_nunber; //syusseki番号
	private String jender;
	private String enrollment_status; //iruka
	private String activity_situation; //syuushoku_joutai
	public Report() {
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_nunber(int student_nunber) {
		this.student_nunber = student_nunber;
	}
	public int getStudent_nunber() {
		return student_nunber;
	}
	public String getJender() { return jender; }
    public void setJender(String jender) { this.jender = jender; }
    
	public void setEnrollment_status(String enrollment_status) {
		this.enrollment_status = enrollment_status;
	}
	public String getEnrollment_status() {
		return enrollment_status;
	}
	public void setActivity_situation(String activity_situation) {
		this.activity_situation = activity_situation;
	}
	public String getActivity_situation() {
		return activity_situation;
	}
}
