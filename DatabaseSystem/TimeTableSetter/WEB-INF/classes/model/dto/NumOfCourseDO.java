package model.dto;

public class NumOfCourseDO {
	String tID;
	int numOfCourse;
	int creditSum;
	int numOfDay;
	
	public NumOfCourseDO() {

	}

	public NumOfCourseDO(String tID, int numOfCourse, int creditSum, int numOfDay) {
		this.tID = tID;
		this.numOfCourse = numOfCourse;
		this.creditSum = creditSum;
		this.numOfDay = numOfDay;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
	}

	public int getNumOfCourse() {
		return numOfCourse;
	}

	public void setNumOfCourse(int numOfCourse) {
		this.numOfCourse = numOfCourse;
	}

	public int getCreditSum() {
		return creditSum;
	}

	public void setCreditSum(int creditSum) {
		this.creditSum = creditSum;
	}

	public int getNumOfDay() {
		return numOfDay;
	}

	public void setNumOfDay(int numOfDay) {
		this.numOfDay = numOfDay;
	}	
}
