package gakusei.bean;

import java.io.Serializable;

/**
 * 学生情報テーブルの1レコードに対応するBeanクラス。
 * 画面入出力項目一覧に定義された項目をすべて保持する。
 */
public class StudentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentId;        // 学籍番号
    private String attendanceNo;     // 出席番号
    private String name;             // 氏名
    private String kana;             // 読み仮名（平仮名）
    private String gender;           // 性別
    private String status;           // 在籍状況
    private String prefHope;         // 県内外志望
    private String job1;             // 希望職種１
    private String job2;             // 希望職種２
    private String job3;             // 希望職種３
    private String mediationDecline; // あっせん辞退

    private String className;        // クラス（class_masterとの結合結果。一覧表示専用）

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getAttendanceNo() { return attendanceNo; }
    public void setAttendanceNo(String attendanceNo) { this.attendanceNo = attendanceNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPrefHope() { return prefHope; }
    public void setPrefHope(String prefHope) { this.prefHope = prefHope; }

    public String getJob1() { return job1; }
    public void setJob1(String job1) { this.job1 = job1; }

    public String getJob2() { return job2; }
    public void setJob2(String job2) { this.job2 = job2; }

    public String getJob3() { return job3; }
    public void setJob3(String job3) { this.job3 = job3; }

    public String getMediationDecline() { return mediationDecline; }
    public void setMediationDecline(String mediationDecline) { this.mediationDecline = mediationDecline; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
}
