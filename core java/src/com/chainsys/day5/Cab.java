package com.chainsys.day5;

public class Cab {

	 String type;
	 double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	Cab(String type, double price) {

		this.type = type;
		this.price = price;
	}

	public double calculateFare(int distance) {
		double fare = distance * price;
		if (fare > 5000) {
			System.out.println("you have 5% discount");
			fare = fare - (fare * 0.05);
		} else if (fare > 2000) {
			System.out.println("you have 2% discount");
			fare = fare - (fare * 0.02);
		}
		return fare;
	}
//check code 
	public boolean hasCoupon(String c) {
		if (c.equals("COUP_2") || c.equals("COUP_5")) {
			return true;
		} else {
			return false;
		}
	}

	public double CouponPrice(double fare,String coupon) {
	
		if ( coupon.equals("COUP_5")) {
			fare = fare - (fare * 0.05);
		} else if (coupon.equals("COUP_2")) {
			fare = fare - (fare * 0.02);
		}
		return fare;
	}

}
