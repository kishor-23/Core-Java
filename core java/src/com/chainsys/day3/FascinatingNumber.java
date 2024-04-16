package com.chainsys.day3;

import java.util.Scanner;

public class FascinatingNumber {

	public static void main(String[] args) {

//		327×2=654
//
//				327×3=981
//
//				Now, concatenate the above results to the given number (n).
//
//				"327"+"654"+ "981"= 327654981
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :");
		int n = sc.nextInt();
		while (n<0) {
			System.out.println("Invaild , n should be greater than 0");
			n=sc.nextInt();
		}
		String fascinating = "" + n + "" + n * 2 + "" + n * 3;
		System.out.println("concatenate number " + fascinating);
        int fascinatingNumber=Integer.parseInt(fascinating);
        if(fascinating.contains("1")&& fascinating.contains("2")&&fascinating.contains("3")&&
        fascinating.contains("4")&&fascinating.contains("5")&&fascinating.contains("6")&&
        fascinating.contains("7")&&fascinating.contains("8")&&fascinating.contains("9")) {
        	System.out.println("Fasinating number");
        }
        else {
        	System.out.println("not ");
        }
	}

}
 