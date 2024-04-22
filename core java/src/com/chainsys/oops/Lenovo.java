package com.chainsys.oops;

public class Lenovo extends Laptop {
//	public Lenovo(String brand, double price) {
//		super(brand, price);
//		// TODO Auto-generated constructor stub
//	}

	private String model;

	public Lenovo( double price, String model) {
		super("lenovo", price);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String describe() {
		return "Laptop [brand= " +  getBrand() + " , model= " + model + ", price=" + getPrice()+ "]";
	}

	
	

}
