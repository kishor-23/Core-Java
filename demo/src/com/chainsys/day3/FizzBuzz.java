package com.chainsys.day3;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Write a program that prints the numbers from 1 to 100. 
	//	But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
		//For numbers which are multiples of both three and five print “FizzBuzz”."
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter a number :");
		 int n=sc.nextInt();
		 while(n<0) {
			 System.out.println("invalid, number should be greater than 0 ");
			 n=sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			if(i%3==0 && i%5==0) {
				System.out.println("FizzBuzz");
			}
			else if(i%3==0) {
				System.out.println("Fizz");
			}
			else if(i%5==0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
			
		}
	}

}
