package com.chainsys.day4;


import java.util.Scanner;

public class TeenNumberChecker {
	/*
	 * Teen Number Checker
	We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	Write a method named hasTeen with 3 parameters of type int.
	The method should return boolean and it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
	Write another method named isTeen with 1 parameter of type int.
	The method should return boolean and it needs to return true if the parameter is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
	 * 
	 */

    public static boolean hasTeen(int num1, int num2, int num3) {
        return (isTeen(num1) || isTeen(num2) || isTeen(num3));
    }

    public static boolean isTeen(int num) {
        return (num >= 13 && num <= 19);
    }
    
	public static int getPositiveIntInput(Scanner scanner) {
        int n = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Enter only positive numbers. " + n + " is negative.");
                } else {
                    break;
                }
            } else {
                System.out.println("Enter only numbers. " + scanner.next() + " is not a number.");
            }
        }
        return n;
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter a number 1:");
    	int n1 = getPositiveIntInput(sc);
    	// System.out.println(isTeen(n1));
    	System.out.println("Enter number 2:");
    	int n2=getPositiveIntInput(sc);
    	System.out.println("Enter number 3:");
    	int n3=getPositiveIntInput(sc);
    	
    	 // System.out.println("the number :"+n);
        System.out.println("the three number : "+n1+" "+n2+" "+n3+" \n hasTeen : " +hasTeen(n1, n2, n3)); 
     

       
     
    }

}
