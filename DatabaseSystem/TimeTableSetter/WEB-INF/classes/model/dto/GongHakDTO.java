package model.dto;

public class GongHakDTO {
	
	private int ghGraduateYear;
	private int ghGeneral;
	private int ghEssential;
	private int ghEssential_sub;
	private int ghOption;
	private int ghOption_sub;

	
	public int getGhGraduateYear() {
		return ghGraduateYear;
	}
	public void setGhGraduateYear(int ghGraduateYear) {
		this.ghGraduateYear = ghGraduateYear;
	}
	public int getGhGeneral() {
		return ghGeneral;
	}
	public void setGhGeneral(int ghGeneral) {
		this.ghGeneral = ghGeneral;
	}
	public int getGhEssential() {
		return ghEssential;
	}
	public void setGhEssential(int ghEssential) {
		this.ghEssential = ghEssential;
	}
	public int getGhEssential_sub() {
		return ghEssential_sub;
	}
	public void setGhEssential_sub(int ghEssential_sub) {
		this.ghEssential_sub = ghEssential_sub;
	}
	public int getGhOption() {
		return ghOption;
	}
	public void setGhOption(int ghOption) {
		this.ghOption = ghOption;
	}
	public int getGhOption_sub() {
		return ghOption_sub;
	}
	public void setGhOption_sub(int ghOption_sub) {
		this.ghOption_sub = ghOption_sub;
	}
	
	public GongHakDTO() {}
	
	public GongHakDTO(int ghGraduateYear, int ghGeneral, int ghEssential, int ghEssential_sub, int ghOption, int ghOption_sub ) {
		this.ghGraduateYear=ghGraduateYear;
		this.ghGeneral=ghGeneral;
		this.ghEssential=ghEssential;
		this.ghEssential_sub=ghEssential_sub;
		this.ghOption=ghOption;
		this.ghOption_sub=ghOption_sub;
	}
}
