package com.chainsys.day8april22task;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Payment> payments = new ArrayList<>();
		//Date date=Validation.getDate();

		System.out.println("*** Payroll Application ***");
		System.out.println("1. Add Employee");
		System.out.println("2. Display Employee Details");
		System.out.println("3. Add Payroll by Employee ID");
		System.out.println("4. Display Payrolls");
		System.out.println("5. Exit");
		System.out.println("--------------------------");
		System.out.println();

		while (true) {
			System.out.println("Choose an option (1, 2, 3, 4, 5):");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				Employee.addEmployee(employees);
				System.out.println("***Employee added successfully***");
				System.out.println();
				break;
			case 2:
				if (employees.isEmpty()) {
					System.out.println("No records found.");
					System.out.println();
				} else {
					Employee.displayEmployees(employees);
				}
				break;

			case 3:
				System.out.println("Enter Employee ID:");
				int id = Validation.getPositiveInput(sc);
				Payment.addPaymentbyEmpid(id, employees, payments);
				break;

			case 4:
				if (payments.isEmpty()) {
					System.out.println("No records found.");
					System.out.println();
				} else {
					System.out.println("=== Payroll Details ===");
					for (Payment p : payments) {
						System.out.println(p.toString());
					}
					System.out.println();
				}
				break;
			case 5:
				System.out.println();
				System.out.println("...End...");
				return;
			default:
				System.out.println("Wrong input!");
				System.out.println();
			}
		}
	}
}
