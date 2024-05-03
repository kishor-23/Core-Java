package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public static Date getDate() {
		Date date = null;
		boolean validDate = false;
		Scanner sc = new Scanner(System.in);
		while (!validDate) {
			System.out.println("Enter date yyyy-mm-dd:");
			String dateInput = sc.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				date = dateFormat.parse(dateInput);
				validDate = true; // Set validDate to true if parsing succeeds
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
			}
		}

		return date;
	}

	public static boolean isMailVaild(String mail) {
		String regEx = "^[a-z0-9]+[a-z0-9\\.]+@[a-z0-9]+\\.[a-z]{2,}$";
		// Pattern.matches(regEx, mail);
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(mail);
		return m.matches();
	}

	public static boolean isValidPassword(String password) {
		// Check minimum length 6
		String regEx = "(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{5,}";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(password);
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
