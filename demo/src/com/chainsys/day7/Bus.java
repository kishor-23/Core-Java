package com.chainsys.day7;

public class Bus {
	//encapsulation
	private static int id=1;
	private int busNo;
	private boolean ac;
	private int capacity;
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Bus( boolean ac, int capacity,String city) {
		
		this.busNo = id++;
		this.ac = ac;
		this.capacity = capacity;
		this.city=city;
	}
	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", ac=" + ac + ", capacity=" + capacity + ", city=" + city + "]";
	}

	

}
