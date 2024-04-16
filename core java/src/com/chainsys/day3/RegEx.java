package com.chainsys.day3;

import java.util.Scanner;

public class RegEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String name="vikra2m";
		if(name.matches("\\d.+")) {
			System.out.println("name should not contain digit");
		}
		else {
			System.out.println("else");
		}

	}

}
