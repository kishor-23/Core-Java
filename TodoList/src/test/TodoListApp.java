package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.*;
import dao.*;
import impl.*;

public class TodoListApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		UserDAO userOperations = new UserImpl();
		TaskDAO taskOperations = new TaskImpl();
//		HabitImpl habitOperations=new HabitImpl();
		System.out.println(" *** Welcome to TodoList App *** ");
		startPage(userOperations, taskOperations);
	}

	public static void startPage(UserDAO userOperations, TaskDAO taskOperations)
			throws ClassNotFoundException, SQLException {
		HabitImpl habitOperations=new HabitImpl();
		HabitRecordImpl recordOperations=new HabitRecordImpl();
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
//					todoTask(user, taskOperations, userOperations);
//					todoHabit(user,habitOperations,recordOperations);
					 homepage(user, userOperations);
					
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

	public static void todoTask(User user, TaskDAO taskOperations, UserDAO userOperations)
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
			System.out.println("8. back");
			System.out.println("Choose an option (1 to 7):");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter a todo task:");
				String task = sc.nextLine();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
				String taskDate = format.format(Validation.getValidDate());
				System.out.println("enter priority (high,medium,low)");
				String priority = sc.nextLine();
				while (true) {
					if (priority.equals("high") || priority.equals("low") || priority.equals("medium")) {
						break;
					}
					System.out.println("invalid choose male or female");
					priority = sc.next();
				}

				Task addtask = new Task(task, "not done", priority, taskDate, user.getId());
				taskOperations.addTask(addtask);
				break;
			case "2":
				System.out.println("Enter task id:");
				int id = Validation.getPositiveInput(sc);
				sc.nextLine();
				System.out.println("update task status :");
				String status = sc.nextLine();
				Task updatetask = new Task(id, status, user.getId());
				taskOperations.updateTaskStatus(updatetask);
				break;
			case "3":
				// System.out.println("Enter task id:");
				int taskid = Validation.getIdPositiveValue();
				taskOperations.deleteTask(taskid, user.getId());
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
					userOperations.deleteUser(user.getId());
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
public static void homepage(User user,UserDAO userOperations) throws ClassNotFoundException, SQLException {
//	UserDAO userOperations = new UserImpl();
	TaskDAO taskOperations = new TaskImpl();
	HabitImpl habitOperations=new HabitImpl();
	HabitRecordImpl recordOperations=new HabitRecordImpl();
	Scanner sc = new Scanner(System.in);
	while (true) {
		System.out.println(" 1. todo task ");
		System.out.println(" 2. todo habit");
		System.out.println(" 3. delete account");
		System.out.println(" 4. logout");
		
		System.out.println("Choose an option (1 to 4):");
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			todoTask(user, taskOperations, userOperations);
			
			break;
		case "2":
			todoHabit(user,habitOperations,recordOperations);
			break;
		case "3":
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
				userOperations.deleteUser(user.getId());
				return;
			}
			System.out.println();
			break;
		case "4":
			System.out.println("Good bye....");
			System.out.println("Logged out successfully.");
			return;
		default:
			System.out.println("Invalid option! Please choose again.");
		}
	}
			
			
}
	
	
	public static void todoHabit(User user, HabitImpl habitOperations,HabitRecordImpl recordOperations) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("========= habit List =========");
		    habitOperations.displayAllHabits(user);
			System.out.println("==============================");
			System.out.println("1. Add habit ");
			System.out.println("2. Add today's habit status");
			System.out.println("3. view habit tracking history");
			System.out.println("4. back");
			System.out.println("Choose an option (1 to 4):");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter a habit:");
				String habit = sc.nextLine();
				Habit addhabit = new Habit(user.getId(),habit);
				habitOperations.addHabit(addhabit);
				break;
			case "2":
				System.out.println("Enter habit id:");
				int id = Validation.getPositiveInput(sc);
				sc.nextLine();
				System.out.println("Did you complete it ?(y/n)");
				String status = sc.nextLine();
				while (true) {
					if (status.equals("y") || status.equals("n")) {
						break;
					}
					System.out.println("invalid choose y or n");
					status = sc.next();

				}
				if (status.equals("y")) {
					status="done";
				}
				else {
					status="not done";
				}
				String date=Validation.getCurrentDate();
			    HabitRecords record=new HabitRecords(user.getId(),id,date,status);
			    recordOperations.addHabitRecord(record);
				break;
			case "3":
				
				System.out.println("enter habit id");
				int habitid = Validation.getPositiveInput(sc);
				sc.nextLine();
				recordOperations.displayAllHabitRecords(user,habitid);
				System.out.println();
				break;

			case "4":
				System.out.println("back to homepage");
				System.out.println();
				return;
			default:
				System.out.println("Invalid option! Please choose again.");
			}
		}
	}
}
