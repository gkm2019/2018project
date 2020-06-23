package model.dto;

public class UserListDTO {
	private String stdID;
	private int ghGraduateYear;
	private String cID;
	private String whether;
	
	public String getStdID() {
		return stdID;
	}
	public void setStdID(String stdID) {
		this.stdID = stdID;
	}
	public int getGhGraduateYear() {
		return ghGraduateYear;
	}
	public void setGhGraduateYear(int ghGraduateYear) {
		this.ghGraduateYear = ghGraduateYear;
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getWhether() {
		return whether;
	}
	public void setWhether(String whether) {
		this.whether = whether;
	}
	
	public UserListDTO() {}
	public UserListDTO(String stdID, int ghGraduateYear, String cID, String whether) {
		this.stdID=stdID;
		this.ghGraduateYear=ghGraduateYear;
		this.cID=cID;
		this.whether=whether;
	}
	
}
