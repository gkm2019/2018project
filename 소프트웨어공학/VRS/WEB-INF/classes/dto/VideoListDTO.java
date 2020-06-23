package dto;

public class VideoListDTO {
	
	private String vlistnum;
	private String vname;
	private String vrelease;
	private String vprice;
	private String vdirector;
	
	public VideoListDTO() {}
	public VideoListDTO(String vlistnum, String vname, String vrelease, String vprice, String vdirector) {
		super();
		this.vlistnum = vlistnum;
		this.vname = vname;
		this.vrelease = vrelease;
		this.vprice = vprice;
		this.vdirector = vdirector;
	}
	
	public String getVlistnum() {
		return vlistnum;
	}
	public void setVlistnum(String vlistnum) {
		this.vlistnum = vlistnum;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVrelease() {
		return vrelease;
	}
	public void setVrelease(String vrelease) {
		this.vrelease = vrelease;
	}
	public String getVprice() {
		return vprice;
	}
	public void setVprice(String vprice) {
		this.vprice = vprice;
	}
	public String getVdirector() {
		return vdirector;
	}
	public void setVdirector(String vdirector) {
		this.vdirector = vdirector;
	}

}
