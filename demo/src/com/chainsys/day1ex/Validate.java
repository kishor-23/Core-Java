package com.chainsys.day1ex;

import java.util.Scanner;

public class Validate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=0;
		System.out.println("enter a number");
  	  while (sc.hasNext()) {  
            //If the next is a int, correct input
              if (sc.hasNextInt()) {  
                 n=sc.nextInt(); 
                 if(n<0) {
              	   System.out.println("Enter a  only positive number "+sc.nextInt()+"is negative ");
                 }
                 else {
              	   break; 
                 }
                
              }  
              //If no int is found, print "Not a Intvalue" 
              System.out.println("enter only numbers 1 to n ,"+sc.next()+"is not a number");  
          }

	}

}
