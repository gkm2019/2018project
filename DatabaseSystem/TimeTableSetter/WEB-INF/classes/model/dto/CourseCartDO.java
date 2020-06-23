package model.dto;

public class CourseCartDO {
	String stdID;
	String cID;
	
	public CourseCartDO() {

	}
	
	public CourseCartDO(String stdID, String cID) {
		this.stdID = stdID;
		this.cID = cID;
	}

	public String getStdID() {
		return stdID;
	}
	public void setStdID(String stdID) {
		this.stdID = stdID;
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
}
