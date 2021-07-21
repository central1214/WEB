package user;

//Data Transfer Object = DVO 혹은 VO
//Student 같은 객체들
//데이터베이스에 전송하거나 전송될 객체

public class UserDTO {
	
	String userID;
	String userPassword;
	String nickName;
	String email;
	//alt+shift+s 누른 뒤 r
	public String getUserID() {
		return userID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
}
