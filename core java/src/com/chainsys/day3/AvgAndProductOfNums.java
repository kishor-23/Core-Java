package com.chainsys.day3;

import java.util.Scanner;

public class AvgAndProductOfNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Take integer inputs from user until he/she presses q ( Ask to press q to quit after every integer input ). 
	//	Print average and product of all numbers.
       Scanner sc=new Scanner(System.in);
       int product=1;
       int sum=0;
       double avg=0;
       int n=0;
       System.out.println("Enter a numbers (q to quit):");
       while(true) {
    	   char value=sc.next().charAt(0);
    	   if(value=='q') {
    		   break;
    	   }
    	   if((value>='0' && value<='9' ) || value=='q') {
    		   int num=Integer.parseInt(""+value);
        	   product*=num;
        	   n++;
        	   sum+=num;
        	   avg=sum/n;
    	   }
    	   else {
    		   System.out.println("enter only number if you want exit q");
    		//   value=sc.next().charAt(0);   
    	   }
    	  
    			   
       }
       System.out.println("average "+avg);
       System.out.println("product "+product);
	}

}
