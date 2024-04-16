package com.chainsys.day3;


import java.util.Scanner;

public class AssignWorkPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ask user to enter age, sex ( M or F ), marital status ( Y or N ) and then using 
		//following rules print their place of service.
		//if employee is female, then she will work only in urban areas.

	//	if employee is a male and age is in between 20 to 40 then he may work in anywhere

	//	if employee is male and age is in between 40 t0 60 then he will work in urban areas only.

	//	And any other input of age should print "ERROR".
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name :");
		String name=sc.next();
		System.out.println("enter age:");
		int age=sc.nextInt();
		 
		 while(age<20 || age>60) {
			 System.out.println("invalid ,age should be 20 to 60 ");
			 age=sc.nextInt();
			
			}
		System.out.println("enter sex: ");
		String sex=sc.next();
        while(true) {
        	if(sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")) {
        		break;
        	}
        	System.out.println("invalid choose male or female");
    		sex=sc.next();
        }
		
		if(sex.equalsIgnoreCase("female") ) {
			System.out.println(name+" ,you will work only in urban areas ");
		}
		else if(sex.equalsIgnoreCase("male") && (age >=20 && age <=40)) {
		   System.out.println("may work in anywhere");
		
		}
		else if(sex.equalsIgnoreCase("male") && (age >=40 && age <=60)) {
			System.out.println(name+" ,you will work only in urban areas ");		}
		else {
			System.out.println("Error");
		}


	}

}
