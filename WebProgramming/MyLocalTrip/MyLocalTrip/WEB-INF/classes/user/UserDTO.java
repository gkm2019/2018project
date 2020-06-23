package user;

//Database Transfer Object
public class UserDTO {

	private String userName;
	private String userID;
	private String userPassword;
	private String userEmail;
	private String userEmailHashs;
	private boolean userEmailChecked;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmailHashs() {
		return userEmailHashs;
	}
	public void setUserEmailHashs(String userEmailHashs) {
		this.userEmailHashs = userEmailHashs;
	}
	public boolean isUserEmailChecked() {
		return userEmailChecked;
	}
	public void setUserEmailChecked(boolean userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	
	public UserDTO() {
	}
	
	public UserDTO(String userName, String userID, String userPassword, String userEmail,String userEmailHashs,
			boolean userEmailChecked) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userPassword = userPassword;
		this.userEmail=userEmail;
		this.userEmailHashs = userEmailHashs;
		this.userEmailChecked = userEmailChecked;
	}
	
	
}
