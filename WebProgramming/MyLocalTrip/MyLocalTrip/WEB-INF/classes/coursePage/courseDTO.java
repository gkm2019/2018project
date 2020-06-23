package coursePage;

public class courseDTO {
	private int course_idx;
	private String course_image1;
	private String course_image2;
	private String course_image3;
	private String course_name;
	private String course_thema;
	private String course_info;
	private int area_idx;
	
	public int getCourseIDX() {
		return course_idx;
	}
	public void setCourseIDX(int course_idx) {
		this.course_idx=course_idx;
	}
	
	public String getCourseImage1() {
		return course_image1;
	}
	public String getCourseImage2() {
		return course_image2;
	}
	public String getCourseImage3() {
		return course_image3;
	}
	public void setCourseImage1(String course_image1) {
		this.course_image1=course_image1;
	}
	public void setCourseImage2(String course_image2) {
		this.course_image2=course_image2;
	}
	public void setCourseImage3(String course_image3) {
		this.course_image3=course_image3;
	}
	
	public String getCourseName() {
		return course_name;
	}
	public void setCourseName(String course_name) {
		this.course_name=course_name;
	}
	
	public String getCourseThema() {
		return course_thema;
	}
	public void setCourseThema(String course_thema) {
		this.course_thema=course_thema;
	}
	
	public String getCourseInfo() {
		return course_info;
	}
	public void setCourseInfo(String course_info) {
		this.course_info=course_info;
	}
	public int getAreaIDX() {
		return area_idx;
	}
	public void setAreaIDX(int area_idx) {
		this.area_idx=area_idx;
	}
	
	public courseDTO() {
		//기본 생성자
	}
	public courseDTO(int course_idx, String course_image1, String course_image2, String course_image3, 
			String course_name, String course_thema, String course_info, int area_idx) {
		super();
		this.course_idx=course_idx;
		this.course_image1=course_image1;
		this.course_image2=course_image2;
		this.course_image3=course_image3;
		this.course_name=course_name;
		this.course_thema=course_thema;
		this.course_info=course_info;
		this.area_idx=area_idx;
	}
	
	@Override
	public String toString() {
		return "courseDTO [course_idx=" + course_idx + ", course_image1="+course_image1+", course_image2=" +course_image2+
				", course_image3" +course_image3+", course_name="+course_name+", course_thema"+course_thema+
				", course_info"+course_info+", area_idx="+area_idx+"]";
	}
}
