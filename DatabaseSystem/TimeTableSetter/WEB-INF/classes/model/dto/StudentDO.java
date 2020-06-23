package model.dto;

public class StudentDO {
	String stdID;
	String stdName;
	int stdGrade;
	int stdGraduateYear;
	String stdPW;
	
	public StudentDO() {
		
	}
	
	public StudentDO(String stdID, String stdName, int stdGrade, int stdGraduateYear, String stdPW) {
		this.stdID = stdID;
		this.stdName = stdName;
		this.stdGrade = stdGrade;
		this.stdGraduateYear = stdGraduateYear;
		this.stdPW = stdPW;
	}
	
	public String getStdID() {
		return stdID;
	}
	public void setStdID(String stdID) {
		this.stdID = stdID;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(int stdGrade) {
		this.stdGrade = stdGrade;
	}

	public int getStdGraduateYear() {
		return stdGraduateYear;
	}

	public void setStdGraduateYear(int stdGraduateYear) {
		this.stdGraduateYear = stdGraduateYear;
	}

	public String getStdPW() {
		return stdPW;
	}

	public void setStdPW(String stdPW) {
		this.stdPW = stdPW;
	}

	
}
/*
	stdID VARCHAR(20) primary key,
    stdName varchar(50) not null,
    stdGrade int,
    stdGraduateYear int
*/