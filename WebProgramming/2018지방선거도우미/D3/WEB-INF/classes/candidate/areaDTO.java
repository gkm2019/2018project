package candidate;

public class areaDTO {

	private int area_idx;
	private String area_name;
	private int candi_total;
	
	public int getAreaIDX() {
		return area_idx;
	}
	public void setAreaIDX(int area_idx) {
		this.area_idx=area_idx;
	}
	public String getAreaName() {
		return area_name;
	}
	public void setAreaName(String area_name) {
		this.area_name=area_name;
	}
	public int getAreaCandiTotal() {
		return candi_total;
	}
	public void setAreaCandiTotal(int candi_total) {
		this.candi_total=candi_total;
	}
	
	public areaDTO() {
		
	}
	
	public areaDTO(int area_idx, String area_name, int candi_total) {
		super();
		this.area_idx=area_idx;
		this.area_name=area_name;
		this.candi_total=candi_total;
	}
	@Override
	public String toString() {
		return "areaDTO [area_idx="+area_idx+", area_name="+area_name+
				", cnadi_total="+candi_total+"]";
	}
}
