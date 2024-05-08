package model;

public class Task {
	int id;
	String name;
	String status;
	String  priority;
	String date;
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	String usermail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
    public Task(int id) {
    	this.id = id;
    }
	public Task( String name, String status, String date,String usermail) {
		this.name = name;
		this.status = status;
		this.date = date;
		this.usermail=usermail;
	
	}
	public Task( String name, String status,String priority,  String date,String usermail) {
		this.name = name;
		this.status = status;
		this.date = date;
		this.priority = priority;
		this.usermail=usermail;
	
	}
	public Task(int id,String status,String usermail) {
		this.id = id;
		this.status = status;
		this.usermail=usermail;
	
	}
	public Task( String name, String status, String date) {
		this.name = name;
		this.status = status;
		this.date = date;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	
}
