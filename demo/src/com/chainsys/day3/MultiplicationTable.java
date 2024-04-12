package com.chainsys.day3; 

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter a number");
		 int num=sc.nextInt();
		 while(num<=0 ) {

			 System.out.println("invalid please enter a positive number ");
			 num=sc.nextInt();
			
			 
			}
		 for(int i=1;i<=10;i++) {
			 System.out.println(i+" X "+num+" = "+(i*num));
		 }

	}

}
