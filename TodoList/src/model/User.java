package model;

public class User {
	private int id;
	private String mailId;
	private String name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public User(int id, String mailId, String name, String password) {
		this.id = id;
		this.mailId = mailId;
		this.name = name;
		this.password = password;
	}

	public User() {

	}

	public User(String mailId, String password) {

		this.mailId = mailId;

		this.password = password;
	}
}
