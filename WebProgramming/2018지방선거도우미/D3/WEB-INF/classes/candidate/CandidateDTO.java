package candidate;

public class CandidateDTO {
	private int area_idx; //지역 번호
	private int candi_idx; //후보자 번호
	private String candi_image; //후보자 이미지
	private String candi_name; //후보자 이름
	private int candi_num; //후보자 기호
	private String candi_JD; //후보자 정당
	private String candi_birth; //후보자 생년월일
	private String candi_commit; //후보자 공약
	private String candi_commit2;
	private String candi_commit3;
	private String candi_commit4;
	private String candi_commit5;
	
	public int getAreaIDX() {
		return area_idx;
	}
	public void setAreaIDX(int area_idx) {
		this.area_idx=area_idx;
	}
	public int getCandiIDX() {
		return candi_idx;
	}
	public void setCandiIDX(int candi_idx) {
		this.candi_idx=candi_idx;
	}
	public String getCandiImage() {
		return candi_image;
	}
	public void setCandiImage(String candi_image) {
		this.candi_image=candi_image;
	}
	public String getCandiName() {
		return candi_name;
	}
	public void setCandiName(String candi_name) {
		this.candi_name=candi_name;
	}
	public int getCandiNum() {
		return candi_num;
	}
	public void setCandiNum(int candi_num) {
		this.candi_num=candi_num;
	}
	public String getCandiJD() {
		return candi_JD;
	}
	public void setCandiJD(String candi_JD) {
		this.candi_JD=candi_JD;
	}
	public String getCandiBirth() {
		return candi_birth;
	}
	public void setCandiBirth(String candi_birth) {
		this.candi_birth=candi_birth;
	}
	public String getCandiCommit() {
		return candi_commit;
	}
	public void setCandiCommit(String candi_commit) {
		this.candi_commit=candi_commit;
	}
	public String getCandiCommit2() {
		return candi_commit2;
	}
	public void setCandiCommit2(String candi_commit2) {
		this.candi_commit2=candi_commit2;
	}
	public String getCandiCommit3() {
		return candi_commit3;
	}
	public void setCandiCommit3(String candi_commit3) {
		this.candi_commit3=candi_commit3;
	}
	public String getCandiCommit4() {
		return candi_commit4;
	}
	public void setCandiCommit4(String candi_commit4) {
		this.candi_commit4=candi_commit4;
	}
	public String getCandiCommit5() {
		return candi_commit5;
	}
	public void setCandiCommit5(String candi_commit5) {
		this.candi_commit5=candi_commit5;
	}
	public CandidateDTO(int area_idx, int idx, String image, int num, String name, String JD,
			String birth, String commit, String commit2, String commit3, String commit4, String commit5) {
		super();
		this.area_idx=area_idx;
		this.candi_idx=idx;
		this.candi_image=image;
		this.candi_num=num;
		this.candi_name=name;
		this.candi_JD=JD;
		this.candi_birth=birth;
		this.candi_commit=commit;
		this.candi_commit2=commit2;
		this.candi_commit3=commit3;
		this.candi_commit4=commit4;
		this.candi_commit5=commit5;
	}
	
	public CandidateDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return "CandidateDTO [area_idx=" + area_idx + ", candi_idx=" + candi_idx + ", candi_image=" + candi_image + ", candi_num=" + candi_num + 
        		", candi_name=" + candi_name+", candi_JD=" +candi_JD+", candi_birth="+candi_JD+", candi_birth="+candi_birth+", "
        				+ ", candi_commit="+candi_commit+", candi_commit2="+candi_commit2+", candi_commit3"+candi_commit4+
        				", candi_commit5"+candi_commit5+
                "]";
    }

}
