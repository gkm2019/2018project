package coursePage;

public class locationDTO {
	private int course_idx;
	private int location_idx;
	private String location_step;
	private String location_image1;
	private String location_image2;
	private String location_image3;
	private String location_name;
	private String location_addr;
	private String location_tel;
	private String location_info;
	
	public int getCourseIDX() {
		return course_idx;
	}
	public void setCourseIDX(int course_idx) {
		this.course_idx=course_idx;
	}
	
	public int getLocationIDX() {
		return location_idx;
	}
	public void setLocationIDX(int location_idx) {
		this.location_idx=location_idx;
	}
	public String getLocationStep() {
		return location_step;
	}
	public void setLocationStep(String location_step) {
		this.location_step=location_step;
	}
	
	public String getLocationImage1() {
		return location_image1;
	}
	public String getLocationImage2() {
		return location_image2;
	}
	public String getLocationImage3() {
		return location_image3;
	}
	
	public void setLocationImage1(String location_image1) {
		this.location_image1=location_image1;
	}
	public void setLocationImage2(String location_image2) {
		this.location_image2=location_image2;
	}
	public void setLocationImage3(String location_image3) {
		this.location_image3=location_image3;
	}
	
	public String getLocationName() {
		return location_name;
	}
	public void setLocationName(String location_name) {
		this.location_name=location_name;
	}
	
	public String getLocationAddr() {
		return location_addr;
	}
	public void setLocationAddr(String location_addr) {
		this.location_addr=location_addr;
	}
	
	public String getLocationTel() {
		return location_tel;
	}
	public void setLocationTel(String location_tel) {
		this.location_tel=location_tel;
	}
	
	public String getLocationInfo() {
		return location_info;
	}
	public void setLocationInfo(String location_info) {
		this.location_info=location_info;
	}
	
	public locationDTO() {
		//기본 생성자
	}
	public locationDTO(int course_idx, int location_idx, String location_step, String location_image1, String location_image2, String location_image3, 
			String location_name, String location_addr, String location_tel, String location_info) {
		super();
		this.course_idx=course_idx;
		this.location_idx=location_idx;
		this.location_step=location_step;
		this.location_image1=location_image1;
		this.location_image2=location_image2;
		this.location_image3=location_image3;
		this.location_name=location_name;
		this.location_addr=location_addr;
		this.location_tel=location_tel;
		this.location_info=location_info;
		
	}
	
	@Override
	public String toString() {
		return "courseDTO [course_idx=" + course_idx + ", location_idx="+location_idx+", location_step="+location_step+
				", location_image1="+location_image1+", location_image2=" +location_image2+
				", location_image3" +location_image3+", location_name="+location_name+
				", location_addr"+location_addr+", location_tel"+location_tel+", location_info="+location_info+"]";
	}
}
