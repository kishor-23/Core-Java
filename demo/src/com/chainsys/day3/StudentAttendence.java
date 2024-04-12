package com.chainsys.day3;

import java.util.Scanner;

public class StudentAttendence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A student will not be allowed to sit in exam if his/her attendence is less than 75%.
//		Take following input from user
//		Number of classes held
//		Number of classes attended.
//		And print
//		percentage of class attended
//		Is student is allowed to sit in exam or not.
//		Also decide to allow student to sit if he/she has medical cause. 
//		Ask user if he/she has medical cause or not ( 'Y' or 'N' ) and print accordingly.
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter number of class attended (total 10 days):");
	int no0fClassAttended =sc.nextInt();
	int totalClasses=10;
	while(totalClasses<0 || totalClasses>10 ) {

	 System.out.println("invalid , total class is 10 , enter 1 to 10");
	 int vaildno=sc.nextInt();
	 totalClasses=vaildno;
	 
	}
	
	System.out.println("do have any medical reason:(true/false)");
	boolean isMedicalCause=sc.nextBoolean();

	double percentage=no0fClassAttended*100/totalClasses;
	if(isMedicalCause) {
		System.out.println("You can attend");
		
	}
	else {
		if(percentage<75) {
			System.out.println("You can not attend");
		}
		else {
			System.out.println("You can attend");
		}
	}
	
	
	

	}

}
