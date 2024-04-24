package com.chainsys.day8april22task;

public class Task {
	static int increment=1;
	int id;
	String name;
	String status;
	String date;
	String umail;

	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Task(String name, String status) {
		this.id = increment++;
		this.name = name;
		this.status = status;
	}
	public Task(String name, String status,String date,String umail) {
		this.id = increment++;
		this.name = name;
		this.status = status;
		this.date=date;
		this.umail=umail;
	}
	

	
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + ", date=" + date + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	

}
