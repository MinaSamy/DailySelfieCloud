package bloodstone.dailyselfie.cloud.model;

public class UserRegistration {
	private String userName;
	private String passowrd;
	private String displayName;
	
	

	public UserRegistration() {
	}
	
	

	public UserRegistration(String userName, String passowrd, String displayName) {
		super();
		this.userName = userName;
		this.passowrd = passowrd;
		this.displayName = displayName;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
