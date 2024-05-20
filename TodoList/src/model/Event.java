package model;

public class Event {
	int id;
	int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	String eventName;
	String date;

	public int getId() {
		return id;
	}
	public Event() {
		
	}
	public Event( int userid, String eventName, String date) {
		this.userid = userid;
		this.eventName = eventName;
		this.date = date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
