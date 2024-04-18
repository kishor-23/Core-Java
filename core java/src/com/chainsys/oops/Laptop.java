package com.chainsys.oops;

public class Laptop {
   private String brand;
   private double price;
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public String describe() {
	return "Laptop [brand=" + brand + ", price=" + price + "]";
}
public Laptop(String brand, double price) {
	super();
	this.brand = brand;
	this.price = price;
}
  
}
