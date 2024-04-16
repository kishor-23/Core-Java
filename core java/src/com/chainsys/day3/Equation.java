package com.chainsys.day3;

public class Equation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Enter a number ");
		
      //2y2 + y + 5 for all numbers between 5 and 10 for y.
		int i=5;
		System.out.println("2y2 + y + 5 for all numbers between 5 and 10 for y");
		System.out.println();
	 while(i<=10) {
		 int e=(2*(i*i))+i+5;
		 System.out.println("2("+i+")^2"+" + "+i+"+ 5 = "+ e);
		 i++;
	 }
	}

}
