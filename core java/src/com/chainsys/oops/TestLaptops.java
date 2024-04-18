package com.chainsys.oops;

public class TestLaptops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("child class");
		Lenovo thinkpad=new Lenovo(60000,"thinkpad");
		//accessing parent class variable brand
		System.out.println("brand :"+thinkpad.getBrand());
		//override describe 
		System.out.println(thinkpad.describe());

	}

}
