package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
	private static final Scanner scanner = new Scanner(System.in);

	public static boolean isName(String name) {
		return name.matches("^[a-zA-Z ]+$");
	}

	public static Date getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // Rejects invalid dates like 2024-02-31

		Date date = null;
		while (date == null) {
			System.out.println("Enter date yyyy-mm-dd:");
			String dateInput = scanner.next();
			try {
				date = dateFormat.parse(dateInput);
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
			}
		}
		return date;
	}

	public static boolean isMailValid(String mail) {
		return mail.matches("^[a-z]+[a-z0-9\\.]+@[a-z0-9]+\\.[a-z]{2,}$");
	}

	public static boolean isValidPassword(String password) {
		return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*.\\d).{6,}");
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

	public static int getIdPositiveValue() {
		System.out.println("enter id :");
		int n;
		while (true) {
			try {
				n = scanner.nextInt();
				if (n > 0) {
					return n;
				} else {
					System.out.println("Please enter a positive integer:");
				}
			} catch (InputMismatchException e) {
				System.err.println("Exception occurs : "+e+"\n Please enter a positive integer:");
				scanner.next(); // consume the invalid input
			}
		}

	}
	 public static String getCurrentDate() {
	        // Get the current date
	        LocalDate currentDate = LocalDate.now();
	        
	        // Format the date as yyyy-MM-dd
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = currentDate.format(formatter);
	        
	        return formattedDate;
	    }

	public static Date getValidDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		dateFormat.setLenient(false); // Rejects invalid dates like 2024-02-31

		Date currentDate = new Date();
		// Get current date
		Date date = null;
		Scanner scanner = new Scanner(System.in);
		String currentdate = dateFormat.format(currentDate);
		while (date == null) {
			System.out.println("Enter a date in (yyyy-MM-dd-HH-mm):");
			String dateInput = scanner.next();
			try {
				date = dateFormat.parse(dateInput);
				// Compare entered date with current date
				if (date.before(dateFormat.parse(currentdate))) {
					System.out.println("Entered date should be in the future. or current date");
					// Reset date to null to repeat the loop
					date = null;
				}

			} catch (ParseException e) {
				System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
			}
		}
		return date;
	}
}
