package bloodstone.dailyselfie.cloud.model;

public class LoginResponse {
	
	
	
	public LoginResponse() {
	}
	
	

	public LoginResponse(boolean result, String userId) {
		super();
		this.result = result;
		this.userId = userId;
	}



	private boolean result;
	private String userId;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
