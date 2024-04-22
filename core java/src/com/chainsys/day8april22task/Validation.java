package com.chainsys.day8april22task;



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public static boolean isname(String name) {
		// only letters
		String regEx = "^[a-zA-Z]+$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(name);
		return m.matches();

	}
	public static boolean isMonthYear(String s) {
		// only letters
		  String regex = "^(?:jan|feb|mar|april|may|june|july|aug|sept|oct|nov|dec)(?:\\d{4})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();

	}
    public static boolean isPhoneNumber(String phoneNumber) {
        // Phone number pattern: accepts 10 digits, optionally separated by hyphens
        String regEx = "^\\d{10}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
  


	public static int getPositiveInput(Scanner scanner) {
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

}

