package com.chainsys.day3;

import java.util.Scanner;

public class SalaryBonusCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A company decided to give bonus of 5% to employee if his/her year of service is more than 5 years.
		//Ask user for their salary and year of service and print the net bonus amount.
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your empid:");
		int empId=sc.nextInt();
		
		while (empId <= 0) {

			System.out.println("invalid please enter a positive number ");
			empId= sc.nextInt();

		}
		System.out.println("Your Salary :");
		double salary=sc.nextDouble();
		while (salary <= 0) {

			System.out.println("invalid please enter a positive number ");
			salary= sc.nextDouble();

		}
		System.out.println("Year of Service:");
		int yos=sc.nextInt();
		if(yos>5) {
			System.out.println("You have 5% bonus ");
			salary+=salary*5/100;
			System.out.println("Net bonus amount :"+salary);
		}
		else {
			System.out.println("You need more experience for bonus");
			System.out.println(" your salary is same :"+salary);
		}

	}

}
