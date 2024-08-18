package application;

public class loginPassword {
	
	private Integer userName = null;
	private String passWord = null;
 
	public loginPassword(Integer userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public Integer getUserName() {
		return userName;
	}
	public void setUserName(Integer userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
