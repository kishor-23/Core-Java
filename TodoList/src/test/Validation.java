package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return mail.matches("^[a-z0-9]+[a-z0-9\\.]+@[a-z0-9]+\\.[a-z]{2,}$");
    }

    public static boolean isValidPassword(String password) {
        return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.\\d]).{6,}");
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
