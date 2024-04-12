package com.chainsys.day3;

import java.util.Scanner;

public class Raining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		//Write a program that will accept as input from the user, an answer to the following question: 
	//	Is it raining? If it is raining, tell the user to get an umbrella. 
	//	Based on the temperature, either tell the user to bring a heavy jacket (colder than 32 degrees), 
	//	light jacket (between 32 and 50 degrees), or no jacket at all.

	  Scanner sc=new Scanner(System.in);
	  System.out.println("Is it raining? (yes/no)");
	  String rain=sc.next();
	  while(true) {
      	if(rain.equalsIgnoreCase("yes") || rain.equalsIgnoreCase("no")) {
      		break;
      	}
      	System.out.println("invalid choose yes/no");
  		rain=sc.next();
      }
	  if(rain.equalsIgnoreCase("yes")) {
		  System.out.println("get an umbrella");
	  }
	  System.out.println("temperature :");
	  int temp=sc.nextInt();
        if(temp>=32 && temp<=50) {
        	System.out.println("Bring light jacket");
        }
        else if(temp<32) {
        	System.out.println("bring a heavy jacket");
        }
        else {
        	System.out.println("no jacket at all");
        }
	  
	}

}
