package com.chainsys.day3;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 int sumOfDigits=0;
		 System.out.println("Enter a number :");
		 int num=sc.nextInt();
		 while(num<0) {
			 System.out.println("invalid, number should be greater than 0 ");
			 num=sc.nextInt();
		}
		 
		 while(num>0) {
			 sumOfDigits+=num%10;
			 num=num/10;
		 }
		 System.out.println("sum is "+sumOfDigits);


	}

}
