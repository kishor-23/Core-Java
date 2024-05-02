package databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStudent {
	public static boolean isname(String name) {
		String regEx = "^[a-zA-Z]+$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(name);
		return m.matches();

	}
	public static int getPositiveInput(Scanner scanner) {
		int n = 0;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
				if (n <= 0) {
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	      Scanner sc=new Scanner(System.in);
	      StudentDao studentOperations=new StudentImpl();
	      System.out.println("  ***Welcome***  ");
	        while (true) {
				System.out.println(" 1. display student details ");
				System.out.println(" 2. add record");
				System.out.println(" 3. update student detail ");
				System.out.println(" 4. delete record ");
				System.out.println(" 5. exit ");
				String choice = sc.next();
				switch (choice) {
				case "1":
					 studentOperations.readStudentDetails();
					break;
				case "2":
					System.out.println("enter your name ");
					String name=sc.next();
				    while(!isname(name)) {
				    	System.out.println("enter only letters");
				    	 name=sc.next();
				    }
				    System.out.println("enter your age ");
				    int age =getPositiveInput(sc);
					 StudentImpl stud = new StudentImpl(name,age); 
					 studentOperations.insertStudent(stud);
					break;
				case "3":
					 System.out.println("enter your id ");
					   int  id =getPositiveInput(sc);
					System.out.println("enter your name ");
					String studentname=sc.next();
				    while(!isname(studentname)) {
				    	System.out.println("enter only letters");
				    	 name=sc.next();
				    }
				    System.out.println("enter your age ");
				    int studentage =getPositiveInput(sc);
				    studentOperations.updateStudent( id,studentname,studentage); 
					break;
				case "4":
				
				    System.out.println("enter id : ");
				    int sid =getPositiveInput(sc);
				    studentOperations.deleteStudent(sid);
					break;
				case "5":
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("Invalid option! Please choose again.");
				}
			}

	}


}
