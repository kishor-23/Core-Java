package com.chainsys.day8april22task;

import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
	public static int autoIncrement = 1;
	private int id;
	private int empId;
	private double payPerHour;
	private int noOfHoursWorked;
	private int overtime;
	private double grossPay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}

	public int getNoOfHoursWorked() {
		return noOfHoursWorked;
	}

	public void setNoOfHoursWorked(int noOfHoursWorked) {
		this.noOfHoursWorked = noOfHoursWorked;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double calGrosspay(double payPerHour, int noOfHoursWorked, int overtime) {

		// Gross Pay = (Pay per Hour x Total Hours Worked) + (Overtime Pay per Hour x
		// Total Overtime Hours)
		double pay = (payPerHour * noOfHoursWorked) + (overtime * payPerHour);
		return pay;
	}

	// add payroll using employee id
	public static void addPaymentbyEmpid(int empid, ArrayList<Employee> employees, ArrayList<Payment> payments) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Add Payments to Employee using id ===");
		boolean found = false;
		for (Employee e : employees) {
			if (e.getId() == empid) {
				found = true;
				// calculating pay per hour using salary by dividing total number of days(here
				// 22) per month and working hours per day(8hrs)
				double payperHour = (e.getSalary() / 22) / 8;
				System.out.println("Employee ID: " + e.getId() + " | Name: " + e.getName() + " | Pay per Hour: $"
						+ String.format("%.2f", payperHour));
				System.out.println("Enter number of working hours for " + e.getName() + ":");
				int noOfHours = Validation.getPositiveInput(sc);
				System.out.println("Enter overtime hours for " + e.getName() + ", if no overtime enter 0:");
				int overtime = Validation.getPositiveInput(sc);
				payments.add(new Payment(empid, payperHour, noOfHours, overtime));
			}
		}
		if (found) {
			System.out.println("Payroll added successfully.");
		} else {
			System.out.println("Employee ID not found.");
		}
	}

	public static void updatePaymentById(int paymentId, ArrayList<Payment> payments) {
		Scanner scanner = new Scanner(System.in);
		boolean found = false;

		for (Payment payment : payments) {
			if (payment.getId() == paymentId) {
				found = true;
				System.out.println("Found Payment with ID: " + paymentId);
				System.out.println("Current Payment Details:");
				System.out.println(payment);
				System.out.println("Enter new details:");

				System.out.println("Enter new pay per hour:");
				double payPerHour = Validation.getPositiveInput(scanner);

				System.out.println("Enter new number of working hours:");
				int noOfHoursWorked = Validation.getPositiveInput(scanner);

				System.out.println("Enter new overtime hours, if no overtime enter 0:");
				int overtime = Validation.getPositiveInput(scanner);

				// Update payment details
				payment.setPayPerHour(payPerHour);
				payment.setNoOfHoursWorked(noOfHoursWorked);
				payment.setOvertime(overtime);

				System.out.println("Payment updated successfully:");
				System.out.println(payment);
				break;
			}
		}

		if (!found) {
			System.out.println("Payment with ID " + paymentId + " not found.");
		}
	}

	public static void addPayrolltoAll(ArrayList<Employee> employees, ArrayList<Payment> p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Add Payments to Employees ===");
		for (Employee e : employees) {
			double payperHour = (e.getSalary() / 22) / 8;
			System.out.println("Employee ID: " + e.getId() + " | Name: " + e.getName() + " | Pay per Hour: $"
					+ String.format("%.2f", payperHour));
			System.out.println("Enter number of working hours for " + e.getName() + ":");
			int noOfHours = Validation.getPositiveInput(sc);
			System.out.println("Enter overtime hours for " + e.getName() + ", if no overtime enter 0:");
			int overtime = Validation.getPositiveInput(sc);
			p.add(new Payment(e.getId(), payperHour, noOfHours, overtime));
		}
		System.out.println();
	}

	public Payment(int empId, double payPerHour, int noOfHoursWorked, int overtime) {

		this.id = autoIncrement++;
		this.empId = empId;
		this.payPerHour = payPerHour;
		this.noOfHoursWorked = noOfHoursWorked;
		this.overtime = overtime;
		this.grossPay = calGrosspay(payPerHour, noOfHoursWorked, overtime);
	}

	@Override
	public String toString() {
		return " [id=" + id + ", empId=" + empId + ", payPerHour=" + String.format("%.2f", payPerHour)
				+ ", noOfHoursWorked=" + noOfHoursWorked + ", overtime=" + overtime + ", grossPay="
				+ String.format("%.2f", grossPay) + "]";
	}
}
