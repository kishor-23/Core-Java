package model;

public class User {
	String mailId;
	String name;
	String password;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String mailId, String name, String password) {
		this.mailId = mailId;
		this.name = name;
		this.password = password;
	}
	public User(){
		
	}
	


	public User(String mailId, String password) {

		this.mailId = mailId;

		this.password = password;
	}
}
