package com.chainsys.day8april22task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Payment {
	public static int autoIncrement = 1;
	private int id;
	private int empId;
	private double payPerDay;
	private double payperhour;
	private int noOfHoursWorked;
	private int overtime;
	private double grossPay;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public double getPayPerDay() {
		return payPerDay;
	}

	public void setPayPerDay(double payPerDay) {
		this.payPerDay = payPerDay;
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

	public double calGrosspay(double payPerDay, int noOfHoursWorked, int overtime, double payPerHour) {
		// Gross Pay = (Pay per Hour x Total Hours Worked) + (Overtime Pay per Hour x
		// Total Overtime Hours)
		double pay = (payPerDay * noOfHoursWorked) + (overtime * payPerHour);
		return pay;
	}

	public static void displayPayrollById(int empid, ArrayList<Payment> payments) {
		boolean found = false;
		for (Payment payment : payments) {
			
			if (payment.getEmpId() == empid) {
				found=true;
				System.out.println(payments.toString());
			}
		}
		if (!found) {
			System.out.println("Not Found..");
		} 

	}

	public static void displayPayrollBydate(String date, ArrayList<Payment> payments) {
		boolean found = false;
		for (Payment payment : payments) {
			if (payment.getDate().equals(date)) {
				found=true;
				System.out.println(payments.toString());
			}
		}
		if (!found) {
			System.out.println("Not Found..");
		} 

	}

	// add payroll using employee id
	public static void addPaymentbyEmpid(int empid, ArrayList<Employee> employees, ArrayList<Payment> payments) {
		Scanner sc = new Scanner(System.in);

		boolean found = false;
		for (Employee e : employees) {
			if (e.getId() == empid) {
				found = true;
				// calculating pay per day using monthly salary by dividing total number of
				// days(here
				// 22)
				double payperHour = (e.getSalary() / 22) / 8;
				double payperday = e.getSalary() / 22;
				System.out.println("Employee ID: " + e.getId() + " | Name: " + e.getName() + " | Pay per day: rs."
						+ String.format("%.2f", payperday));
				System.out.println("Enter number of working days for " + e.getName() + ":");
				int noOfwork = Validation.getPositiveInput(sc);
				while(noOfwork>22) {
					System.out.println("number of working days for month is only 22");
					System.out.println("enter a valid input");
					noOfwork = Validation.getPositiveInput(sc);
				}
				System.out.println("Enter overtime hours for " + e.getName() + ", if no overtime enter 0:");
				int overtime = Validation.getPositiveInput(sc);

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format(Validation.getDate());
				payments.add(new Payment(empid, payperday, payperHour, noOfwork, overtime, date));
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

				System.out.println("Enter new pay per day:");
				double payPerDay = Validation.getPositiveInput(scanner);

				System.out.println("Enter new number of working hours:");
				int noOfHoursWorked = Validation.getPositiveInput(scanner);

				System.out.println("Enter new overtime hours, if no overtime enter 0:");
				int overtime = Validation.getPositiveInput(scanner);

				// Update payment details
				payment.setPayPerDay(payPerDay);
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

	public Payment(int empId, double payPerDay, double payperhour, int noOfHoursWorked, int overtime, String date) {
		this.id = autoIncrement++;
		this.empId = empId;
		this.payPerDay = payPerDay;
		this.noOfHoursWorked = noOfHoursWorked;
		this.overtime = overtime;
		this.date = date;
		this.payperhour = payperhour;
		this.grossPay = calGrosspay(payPerDay, noOfHoursWorked, overtime, payperhour);
	}
	@Override
	public String toString() {
		return " [id=" + id + ", empId=" + empId + ", payPerday=" + String.format("%.2f", payPerDay)
				+ ", noOfDaysWorked=" + noOfHoursWorked + ", overtime=" + overtime + ", grossPay="
				+ String.format("%.2f", grossPay) + ", payroll date =" + date + "]";
	}
}
