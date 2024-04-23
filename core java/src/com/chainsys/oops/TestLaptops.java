package com.chainsys.oops;

import java.util.Scanner;

import com.chainsys.day8april22task.Validation;

public class TestLaptops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Lenovo thinkpad = new Lenovo(60000, "thinkpad");

		System.out.println("enter model name:");
		String modelname = sc.next();
		while (!Validation.isname(modelname)) {
			System.out.println("Please enter only letters for name:");
			modelname = sc.next();
		}

		System.out.println("enter price :");
		int price = Validation.getPositiveInput(sc);
		Lenovo ideapad = new Lenovo(price, modelname);
		// accessing parent class variable brand
		System.out.println("brand :" + thinkpad.getBrand());
		// override describe
		System.out.println(thinkpad.describe());

		System.out.println(ideapad.describe());
	}

}
