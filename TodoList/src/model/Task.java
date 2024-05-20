package model;

public class Task {
	private int id;
	private String name;
	private String status;
	private String priority;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	String date;
	int userId;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	public Task(int id) {
		this.id = id;
	}

	public Task(String name, String status, String priority, String date, int userId) {
		this.name = name;
		this.status = status;
		this.date = date;
		this.priority = priority;
		this.userId = userId;

	}

	public Task(int id, String status, int userId) {
		this.id = id;
		this.status = status;
		this.userId = userId;

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

}
