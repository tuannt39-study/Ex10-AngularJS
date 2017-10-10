package vn.its.model;

import java.util.Date;

public class User {
	private int userID;
	private String userEmail;
	private String userPass;
	private String userLastName;
	private String userFirstName;
	private Date userDob;

	public User() {
		super();
	}

	public User(int userID, String userEmail, String userPass, String userLastName, String userFirstName,
			Date userDob) {
		super();
		this.userID = userID;
		this.userEmail = userEmail;
		this.userPass = userPass;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.userDob = userDob;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

}
