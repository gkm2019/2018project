package dto;

public class VideoDTO {
	
	private String vnum;
	private String vname;
	private String vdirector;
	private String vlistnum;
	private String vtag;
	private String vprice;
	
	public VideoDTO() {}
	public VideoDTO(String vnum, String vname, String vdirector, String vlistnum, String vtag, String vprice){
		super();
		this.vnum = vnum;
		this.vname = vname;
		this.vdirector = vdirector;
		this.vlistnum = vlistnum;
		this.vtag = vtag;
		this.vprice = vprice;
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
	public String getVdirector() {
		return vdirector;
	}
	public void setVdirector(String vdirector) {
		this.vdirector = vdirector;
	}
	public String getVlistnum() {
		return vlistnum;
	}
	public void setVlistnum(String vlistnum) {
		this.vlistnum = vlistnum;
	}
	public String getVtag() {
		return vtag;
	}
	public void setVtag(String vtag) {
		this.vtag = vtag;
	}
	public String getVprice() {
		return vprice;
	}
	public void setVprice(String vprice) {
		this.vprice = vprice;
	}

}
