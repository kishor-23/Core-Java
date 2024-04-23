package com.chainsys.oops;

public class Lenovo extends Laptop {

	private String model;

	public Lenovo( double price, String model) {
		super("lenovo", price);
		this.model = model;
	}
    public Lenovo() {
    	
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
