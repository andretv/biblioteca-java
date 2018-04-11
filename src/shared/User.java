package shared;

public class User extends Thread {

	private int id;
	private String name;
	private String password;
	
	public int getUserId() {
		return id;
	}
	public void setUserId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return name;
	}
	public void setUserName(String name) {
		this.name = name;
	}
	public String getUserPassword() {
		return password;
	}
	public void setUserPassword(String password) {
		this.password = password;
	}
	
}