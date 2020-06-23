package dto;

public class OverdueDTO {
	String cid;
	String vnum;
	String vname;
	String overdueday;
	
	public OverdueDTO() {}
	public OverdueDTO(String cid, String vnum, String vname, String overdueday) {
		this.cid = cid;
		this.vnum = vnum;
		this.vname = vname;
		this.overdueday = overdueday;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getVnum() {
		return vnum;
	}
	public void setVnum(String vnum) {
		this.vnum = vnum;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getOverdueday() {
		return overdueday;
	}
	public void setOverdueday(String overdueday) {
		this.overdueday = overdueday;
	}

}
