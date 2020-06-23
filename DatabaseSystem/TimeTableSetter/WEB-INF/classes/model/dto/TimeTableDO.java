package model.dto;

public class TimeTableDO {
	String stdID;
	String tID;
	String cID;
	int creditSum;
	int numOfDay;
	public TimeTableDO() {

	}
	
	public TimeTableDO(String stdID, String tID, String cID, int creditSum, int numOfDay, int numOfCourse) {
		this.stdID = stdID;
		this.tID = tID;
		this.cID = cID;
		this.creditSum = creditSum;
		this.numOfDay = numOfDay;
	}

	public String getStdID() {
		return stdID;
	}

	public void setStdID(String stdID) {
		this.stdID = stdID;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
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
