package com.chainsys.day8april22task;

import java.util.ArrayList;
import java.util.Scanner;


public class Employee{
	public static int autoIncrement = 1;
	private int id;
	private String name;
	private String department;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, String department, double salary) {

		this.id = autoIncrement++;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
    
	public static void addEmployee(ArrayList<Employee> e) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Add Employee ===");
		System.out.println("Enter name:");
		String name = sc.next();
		while (!Validation.isname(name)) {
			System.out.println("Please enter only letters for name:");
			name = sc.next();
		}
		System.out.println("Enter department:");
		String department = sc.next();
		while (!Validation.isname(department)) {
			System.out.println("Please enter only letters for department:");
			department = sc.next();
		}
		System.out.println("Enter salary:");
		double salary = Validation.getPositiveInput(sc);
		e.add(new Employee(name, department, salary));
	}
	public static void displayEmployees(ArrayList<Employee> employees) {
		System.out.println("=== Employee Details ===");
		for (Employee e : employees) {
			System.out.println(e.toString());
		}
		System.out.println();
	}


	

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", department=" + department + ", Salary=" + salary + "]";
	}



	

}
