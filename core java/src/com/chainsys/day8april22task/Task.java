package com.chainsys.day8april22task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
	static int increment=1;
	int id;
	String name;
	String status;
	String date;
	String umail;

	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Task(String name, String status) {
		this.id = increment++;
		this.name = name;
		this.status = status;
	}
	public Task(String name, String status,String date,String umail) {
		this.id = increment++;
		this.name = name;
		this.status = status;
		this.date=date;
		this.umail=umail;
	}
	

	
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + ", date=" + date + "]";
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static void addTask(ArrayList<Task> todo, User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a todo task:");
		String task = sc.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String taskDate = format.format(Validation.getDate());
		todo.add(new Task(task, "not done", taskDate, user.getMailId()));
	}
	public static void updateTaskStatus(ArrayList<Task> todo, User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter task id:");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.println("Enter new task status:");
		String status = sc.nextLine();
		for (Task t : todo) {
			if (t.getId() == id && t.getUmail().equals(user.getMailId())) {
				t.setStatus(status);
				System.out.println("Task status updated successfully.");
				return;
			}
		}
		System.out.println("Task not found or you do not have permission to update.");
	}
	public static void deleteTask(ArrayList<Task> todo, User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter task id:");
		int id = sc.nextInt();
		for (int i = 0; i < todo.size(); i++) {
			if (todo.get(i).getId() == id && todo.get(i).getUmail().equals(user.getMailId())) {
				todo.remove(i);
				System.out.println("Task deleted successfully.");
				return;
			}
		}
		System.out.println("Task not found or you do not have permission to delete.");
	}
	public static void displayAllTasks(ArrayList<Task> todo, User user) {
		for (Task t : todo) {
			if (t.getUmail().equals(user.getMailId())) {
				System.out.println(t.toString());
			}
		}
	}

}
