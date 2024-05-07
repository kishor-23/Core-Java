package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Task;
import model.User;
import dao.*;
import impl.*;

public class TodoListApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		UserDAO userOperations = new UserImpl();
		TaskDAO taskOperations = new TaskImpl();
		System.out.println(" *** Welcome to TodoList App *** ");
		startPage(userOperations, taskOperations);
	}

	public static void startPage(UserDAO userOperations, TaskDAO taskOperations)
			throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(" 1. Sign in");
			System.out.println(" 2. Sign up");
			System.out.println(" 3. Exit");
			System.out.println("Choose an option (1 to 3):");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter email id:");
				String mail = sc.nextLine();
				while (!Validation.isMailValid(mail)) {
					System.out.println("please enter a vaild mail id like name@gmail.com ");
					mail = sc.nextLine();
				}
				System.out.println("Enter password:");
				String password = sc.nextLine();
				while (!Validation.isValidPassword(password)) {
					System.out.println(
							"inValid password !,password should have special character, number ,capital & small letters  eg:#Password123 ");
					password = sc.nextLine();
				}
				User user = userOperations.loginUser(mail, password);
				if (user == null) {
					System.out.println("Login failed...");
				} else {
					System.out.println("Login successful...");
					app(user, taskOperations, userOperations);
				}
				System.out.println();
				break;
			case "2":
				System.out.println("Enter name:");
				String username = sc.nextLine();
				while (!Validation.isName(username)) {
					System.out.println("invalid: Enter only letters");
					username = sc.nextLine();
				}

				System.out.println("Enter email id:");
				String mailId = sc.nextLine();

				while (!Validation.isMailValid(mailId)) {
					System.out.println("please enter a vaild mail id like name@gmail.com ");
					mailId = sc.nextLine();
				}
				System.out.println("Enter password:");
				String userpassword = sc.nextLine();
				while (!Validation.isValidPassword(userpassword)) {
					System.out.println(
							"inValid password !,password should have 1 specail character, number ,capital  example:#Password123 ");
					userpassword = sc.nextLine();
				}
				userOperations.registerUser(mailId, username, userpassword);
				break;
			case "3":
				System.out.println("Goodbye!....");
				return;
			default:
				System.out.println("Invalid option! Please choose again.");
			}
		}
	}

	public static void app(User user, TaskDAO taskOperations, UserDAO userOperations)
			throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("========= Todo List =========");
			taskOperations.displayTodayTasks(user);
			System.out.println("==============================");
			System.out.println("1. Add task");
			System.out.println("2. Update task status");
			System.out.println("3. Delete task");
			System.out.println("4. Display all tasks");
			System.out.println("5. Display upcoming 5Days Tasks");
			System.out.println("6. Delete account");
			System.out.println("7. Display task by date");
			System.out.println("8. Logout");
			System.out.println("Choose an option (1 to 7):");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter a todo task:");
				String task = sc.nextLine();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String taskDate = format.format(Validation.getValidDate());
				Task addtask = new Task(task, "not done", taskDate, user.getMailId());
				taskOperations.addTask(addtask);
				break;
			case "2":
				System.out.println("Enter task id:");
				int id = Validation.getPositiveInput(sc);
				sc.nextLine();
				System.out.println("update task status :");
				String status = sc.nextLine();
				Task updatetask = new Task(id, status, user.getMailId());
				taskOperations.updateTaskStatus(updatetask);
				break;
			case "3":
			//	System.out.println("Enter task id:");
				int taskid = Validation.getIdPositiveValue();
				taskOperations.deleteTask(taskid, user.getMailId());
				break;
			case "4":
				taskOperations.displayAllTasks(user);
				System.out.println();
				break;
			case "5":
				taskOperations.displayTodayAndNext5DaysTasks(user);
				System.out.println();
				break;
			case "6":
				System.out.println("Do you want to delete the account (y/n) ?");
				String ans = sc.nextLine();
				while (true) {
					if (ans.equals("y") || ans.equals("n")) {
						break;
					}
					System.out.println("invalid choose y or n");
					ans = sc.next();

				}
				if (ans.equals("y")) {
					userOperations.deleteUser(user.getMailId());
					return;
				}
				System.out.println();
				break;
			case "7":
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateformat.format(Validation.getDate());
				
				taskOperations.displayTasksByDate(date, user);
				break;
				
			case "8":
			    System.out.println("Logged out successfully.");
				System.out.println();
				return;
			default:
				System.out.println("Invalid option! Please choose again.");
			}
		}
	}
}
