package com.chainsys.day2;

import java.util.Scanner;

public class Hospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hospitalName;
        String headDoctorName;
       
        long telephoneNo;
        int numOfDoctors;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the hospitalName :");
        hospitalName = sc.next();
       
        System.out.println("Enter telephoneNo :");
        telephoneNo = sc.nextLong();
        System.out.println("Enter headDoctorName :");
        headDoctorName = sc.next();
        System.out.println("Number of doctors :");
        numOfDoctors = sc.nextInt();
       
        
        System.out.println("hospitalName :" +hospitalName + "\ntelephoneNo :" +telephoneNo + "\nheadDoctorName :" + headDoctorName + "\nNumber of doctor:" + numOfDoctors);
      

	}

}
