package com.chainsys.day3;

import java.util.Scanner;

public class ShopBillGenerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
				System.out.println("1. note unit price 500");
		System.out.println("2. pen unit price 10");
		System.out.println("3. box unit price 100");
		System.out.println("4.exit");
		int cost=0;
		while(true) {
			System.out.println("Choose a product and quantity or to exit choose 4");
			int opt=sc.nextInt();
			
			switch (opt) {
			  case 1:
			    System.out.println("note Quantity");
			    int qnt=sc.nextInt();
			    while(qnt<0) {
					 System.out.println("invalid, number should be greater than 0 ");
					 qnt=sc.nextInt();
				}
			    cost=cost+qnt*500;
			    break;
			  case 2:
				  System.out.println("pen Quantity");
				    int qntOfPen=sc.nextInt();
				    while(qntOfPen<0) {
						 System.out.println("invalid, number should be greater than 0 ");
						 qntOfPen=sc.nextInt();
					}
				    cost+=qntOfPen*10;
				    break;
			  case 3:
				  System.out.println("box Quantity");
				  int qntOfBox=sc.nextInt();
				  while(qntOfBox<0) {
						 System.out.println("invalid, number should be greater than 0 ");
						 qnt=sc.nextInt();
					}
				  cost+=qntOfBox*10;
				  break;
			  case 4:
				  System.out.println("Total price "+cost);
				  if(cost>1000) {
					  System.out.println("you have discount of 10%");
					  System.out.println("Discount price"+ (cost - (cost/10)));
				  }
				  
				  
				  return;
				  
			  default:
			    System.out.println("Wrong input !");
			}
			
		}

	}

}
