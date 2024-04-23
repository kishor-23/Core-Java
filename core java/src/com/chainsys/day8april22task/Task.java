package com.chainsys.day8april22task;

public class Task {
	static int increment=1;
	int id;
	String name;
	String status;
	public Task(String name, String status) {
		this.id = increment++;
		this.name = name;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	public int getId() {
		return id;
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
