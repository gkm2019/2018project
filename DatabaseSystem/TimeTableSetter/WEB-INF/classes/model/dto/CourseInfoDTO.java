package model.dto;

public class CourseInfoDTO {
	private String cID;
	private String cName;
	private String cProfessor;
	private int cGrade;
	private int cCredit;
	private int cCredit_sub;
	private int limit_per;
	private String section;
	
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcProfessor() {
		return cProfessor;
	}
	public void setcProfessor(String cProfessor) {
		this.cProfessor = cProfessor;
	}
	public int getcGrade() {
		return cGrade;
	}
	public void setcGrade(int cGrade) {
		this.cGrade = cGrade;
	}
	public int getcCredit() {
		return cCredit;
	}
	public void setcCredit(int cCredit) {
		this.cCredit = cCredit;
	}
	public int getcCredit_sub() {
		return cCredit_sub;
	}
	public void setcCredit_sub(int cCredit_sub) {
		this.cCredit_sub = cCredit_sub;
	}
	public int getLimit_per() {
		return limit_per;
	}
	public void setLimit_per(int limit_per) {
		this.limit_per = limit_per;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public CourseInfoDTO() {}
	
	public CourseInfoDTO(String cID, String cName, String cProfessor, int cGrade, int cCredit, int cCredit_sub, int limit_per, String section) {
		super();
		this.cID=cID;
		this.cName=cName;
		this.cProfessor=cProfessor;
		this.cGrade=cGrade;
		this.cCredit=cCredit;
		this.cCredit_sub=cCredit_sub;
		this.limit_per=limit_per;
		this.section=section;
	}
}
