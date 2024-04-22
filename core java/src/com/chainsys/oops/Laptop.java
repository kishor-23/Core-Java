package com.chainsys.oops;

//An abstract class is a class that is declared abstract 
//it may or may not include abstract methods. 
//Abstract classes cannot be instantiated
public abstract class Laptop {
   private String brand;
   private double price;
   //abstract method
   public  abstract String describe() ;
   
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




public Laptop(String brand, double price) {

	this.brand = brand;
	this.price = price;
}

  
}
