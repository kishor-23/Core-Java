package com.chainsys.day3;

import java.util.Scanner;

public class OddEvenNCube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter a value for n:");
		 int n=sc.nextInt();
		 while(n<0) {
			 System.out.println("invalid, number should be greater than 0 ");
			 n=sc.nextInt();
		}
		 System.out.println("Even numbers");
		 for(int i=0;i<n;i=i+2) {
			 System.out.print(i+" ");
		 }
		 System.out.println();
		 System.out.println("Odd numbers");
		 for(int i=1;i<n;i=i+2) {
			 System.out.print(i+" ");
		 }
		 System.out.println();
		 System.out.println("Cube of n :"+n*n*n);
		 

	}

}
