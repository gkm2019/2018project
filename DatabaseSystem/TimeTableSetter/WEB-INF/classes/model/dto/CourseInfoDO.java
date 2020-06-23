package model.dto;

import java.util.ArrayList;

public class CourseInfoDO {
	String cID;
	String cName;
	String cProfessor;
	int cGrade;
	int cCredit;
	int cCredit_sub;
	String limit_per;
	String section;
	String cDepartment;
	String cDiv;
	String cSubDiv;
	String cTime;
	ArrayList<String> time;
	
	public CourseInfoDO() {
		time = new ArrayList<String>();
	}
	
	public CourseInfoDO(String cID, String cName, String cProfessor,
			int cGrade, int cCredit, int cCredit_sub, String limit_per,
			String section, String cDepartment, String cDiv, String cSubDiv, String cTime) {
		this.cID = cID;
		this.cName = cName;
		this.cProfessor = cProfessor;
		this.cGrade = cGrade;
		this.cCredit = cCredit;
		this.cCredit_sub = cCredit_sub;
		this.limit_per = limit_per;
		this.section = section;
		this.cDepartment = cDepartment;
		this.cDiv = cDiv;
		this.cSubDiv = cSubDiv;
		this.time = new ArrayList<String>();
	}

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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getcDepartment() {
		return cDepartment;
	}

	public void setcDepartment(String cDepartment) {
		this.cDepartment = cDepartment;
	}

	public String getcDiv() {
		return cDiv;
	}

	public void setcDiv(String cDiv) {
		this.cDiv = cDiv;
	}

	public String getcSubDiv() {
		return cSubDiv;
	}

	public void setcSubDiv(String cSubDiv) {
		this.cSubDiv = cSubDiv;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getLimit_per() {
		return limit_per;
	}

	public void setLimit_per(String limit_per) {
		this.limit_per = limit_per;
	}
	
	public ArrayList<String> getTime(){
		return time;
	}	
	
	public void setTime(ArrayList<String> time) {
		this.time = time;
	}
}
