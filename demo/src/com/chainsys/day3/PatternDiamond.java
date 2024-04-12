package com.chainsys.day3;

import java.util.Scanner;

public class PatternDiamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("enter a number(3)");
	     Scanner sc = new Scanner(System.in);
		 int n=sc.nextInt();
		 while(n<=0) {

			 System.out.println("invalid please enter a positive number ");
			 n=sc.nextInt();
			
			 
			}
		for(int i=1;i<=n;i++) {
			for(int space=i;space<n;space++) {
			
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
//				if(j==1 && i==1) {
//				//	System.out.print(" ");
//				}
					System.out.print("*");
				
			}
			System.out.println();
		}
		for(int i=n-1;i>=1;i--) {
			for(int space=i;space<n;space++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
//				if(j==1 && i==1) {
//				//	System.out.print(" ");
//				}
					System.out.print("*");
				
			}
			System.out.println();
		}

	}

}
