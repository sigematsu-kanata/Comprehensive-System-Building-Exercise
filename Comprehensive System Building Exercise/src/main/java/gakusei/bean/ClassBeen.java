package gakusei.bean;

/**
 * クラステーブルの1レコードに対応するBeanクラス。
 * 画面入出力項目一覧に定義された項目をすべて保持する。
 */
	
public class ClassBeen {
	private static final long serialVersionUID = 1L;
	
	private String attendanceNo  ;
	private String className;
	
	public String getAttendanceNo() { return attendanceNo; }
    public void setAttendanceNo(String attendanceNo) { this.attendanceNo = attendanceNo; }
    
    public String getclassName() { return className; }
    public void setclassName(String className) { this.className = className; }
}
