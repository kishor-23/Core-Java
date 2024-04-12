package com.chainsys.day3;

import java.util.Scanner;

public class Pattern10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number(4)");
		int n = sc.nextInt();
		while (n <= 0) {

			System.out.println("invalid please enter a positive number ");
			n = sc.nextInt();

		}
		for (int i = n; i >= 1; i--) {
			for (int space = i; space < n; space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				if (j % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}
			System.out.println();
		}

	}

}
