package model.dto;

public class TimeDO {
	String cID;
	String cTime;
	String cRoom;
	
	public TimeDO() {
		
	}

	public TimeDO(String cID, String cTime, String cRoom) {
		this.cID = cID;
		this.cTime = cTime;
		this.cRoom = cRoom;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getcRoom() {
		return cRoom;
	}

	public void setcRoom(String cRoom) {
		this.cRoom = cRoom;
	}
}
