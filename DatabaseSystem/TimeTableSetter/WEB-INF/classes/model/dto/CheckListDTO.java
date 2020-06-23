package model.dto;

public class CheckListDTO {
	private int ghGraduateYear;
	private String cID;
	private String section;
	
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public CheckListDTO() {
		//기본 생성자
	}
	
	public CheckListDTO(int ghGraduateYear, String cID, String section) {
		super();
		this.ghGraduateYear=ghGraduateYear;
		this.cID=cID;
		this.section=section;
	}
	
}
