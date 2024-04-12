package com.chainsys.day5;

import java.util.ArrayList;
import java.util.Scanner;

public class CabFare {
	public static int getPositiveIntInput(Scanner scanner) {
		int n = 0;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
				if (n <= 0) {
					System.out.println("Enter only positive numbers in specified range " + n + " is negative.");
				} else {
					break;
				}
			} else {
				System.out.println("Enter only numbers in Give range(1,2,3) " + scanner.next() + " is not a number.");
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Cab> cabs = new ArrayList<>();

		cabs.add(new Cab("Micro", 10));
		cabs.add(new Cab("mini", 15));
		cabs.add(new Cab("Prime", 20));

		System.out.println("Welcome to Cab booking...");
		System.out.println();
		System.out.println("list of cabs and price ");
		int i = 0;
		for (Cab c : cabs) {
			i++;
			System.out.println(i + " " + c.type + "  : price per kiloMeter :" + c.price);
		}
		System.out.println();
		System.out.println("we have Discount :\n" + "  2% discount for tota1 fare amount greater than 2000\n"
				+ "  5% discount for total fare amount greater than 5000");
	
		System.out.println("Coupon Code:\n"
				+ " COUP_2 means 2% discount on bill amount\n"
				+ " COUP_5 means 5% discount on bill amount");
		System.out.println();
		System.out.println("Choose a cab (1,2,3)");

		int opt = getPositiveIntInput(sc);
		while (!(opt >= 1 && opt <= 3)) {
			System.out.println("Enter 1,2,3 only");
			opt = getPositiveIntInput(sc);

		}
		System.out.println("enter distance :");
		int distance = getPositiveIntInput(sc);
		System.out.println();
		double fare = cabs.get(opt - 1).calculateFare(distance);

		System.out.println("total fare is: " + fare);
		System.out.println("do you have coupon :(yes/no)");
		String coupon = sc.next();

		while (true) {
			if (coupon.equalsIgnoreCase("yes") || coupon.equalsIgnoreCase("no")) {
				break;
			}
			System.out.println("invalid choose yes or no");
			coupon = sc.next();
		}
//coupon code 
		if (coupon.equals("yes")) {
			System.out.println("enter the code : ");
			String code = sc.next();
			while (true) {
				//code is correct or not
				if (cabs.get(opt - 1).hasCoupon(code)) {
//					int discount = 0;
//					if (code.equals("COUP_2")) {
//						discount = 2;
//					} else {
//						discount = 5;
//					}
				//	System.out.println("you have a discount of " + discount + "% ");
					System.out.println("you have "+code.charAt(code.length()-1)+"% discount");
					System.out.println("after applying coupon code the price is :");
					System.out.println(" " + cabs.get(opt - 1).CouponPrice( fare,code));
					System.out.println("booking confirm \n Thank you :)");
					break;

				} else {
					System.out.println("wrong code....");

					System.out.println("do want to retype it (yes/no)");
					String s = sc.next();
					if (s.equals("yes")) {
						System.out.println("enter the code : ");
						code = sc.next();
					} 
					else if(s.equals("no")){
						System.out.println("total fare is: " + fare);
						System.out.println("booking confirm ..");
						break;
					}
					else {
						System.out.println("wrong input choose yes or no");
					}
				}
			}
		} else {
			System.out.println("total fare is: " + fare);
			System.out.println("booking confirm .. \n Thank you :) ");
		}

	}

}
