package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<User> users = userOperations.listofUsers();

        System.out.println(" *** Welcome to TodoList App *** ");
        startPage(users, userOperations, taskOperations);
    }

    public static void startPage(ArrayList<User> users, UserDAO userOperations, TaskDAO taskOperations) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1. Sign in");
            System.out.println(" 2. Sign up");
            System.out.println(" 3. Exit");
            System.out.println("Choose an option (1 to 3):");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Enter email id:");
                	String mail = sc.next();
            		System.out.println("Enter password:");
            		String password = sc.next();
                    User user = userOperations.loginUser(mail, password);
                    if (user == null) {
                        System.out.println("Login failed...");
                    } else {
                        System.out.println("Login successful...");
                        List<Task> todo = taskOperations.listoftask(user);
                        app(user, todo, taskOperations);
                    }
                    break;
                case "2":
                	System.out.println("Enter name:");
            		String username = sc.next();
            		while (!Validation.isname(username)) {
            			System.out.println("invalid: Enter only letters");
            			username = sc.next();
            		}

            		System.out.println("Enter email id:");
            		String mailId = sc.next();

            		while (!Validation.isMailVaild(mailId)) {
            			System.out.println("please enter a vaild mail id like name@gmail.com ");
            			mailId = sc.next();
            		}
            		System.out.println("Enter password:");
            		String userpassword = sc.next();
            		while (!Validation.isValidPassword(userpassword)) {
            			System.out.println(
            					"inValid password !,password should have 1 specail character, number ,capital  example:#Password123 ");
            			userpassword = sc.next();
            		}
                    userOperations.registerUser(mailId, username, userpassword);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }

    public static void app(User user, List<Task> todo, TaskDAO taskOperations) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========= Todo List =========");
            taskOperations.displayTodayTasks(user);
            System.out.println("==============================");
            System.out.println("1. Add task");
            System.out.println("2. Update task status");
            System.out.println("3. Delete task");
            System.out.println("4. Display all tasks");
            System.out.println("5. display upcoming 5Days Tasks");
            System.out.println("6. Logout");
            System.out.println("Choose an option (1 to 6):");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    taskOperations.addTask(user);
                    break;
                case "2":
                    taskOperations.updateTaskStatus(user);
                    break;
                case "3":
                    taskOperations.deleteTask(user);
                    break;
                case "4":
                    taskOperations.displayAllTasks(user);
                    break;
                case "5":
                    taskOperations.displayTodayAndNext5DaysTasks(user);
                    break;
                case "6":
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}
