
package com.chainsys.day8april22task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TodoListApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> todo = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("user@mail.com","user","hello"));
        System.out.println(" *** Welcome to TodoList App *** ");
        startPage(todo, users);
    }

    public static void startPage(ArrayList<Task> todo, ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1. Sign in");
            System.out.println(" 2. Sign up");
            System.out.println(" 3. Exit");
            System.out.println("Choose an option (1 to 3):");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    signIn(todo, users);
                    break;
                case "2":
                    signUp(users);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }

    public static void signIn(ArrayList<Task> todo, ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email id:");
        String mail = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        User user = User.loginUser(mail, password, users);
        if (user != null) {
        //	for (int i = 0; i < 5; ++i) System.out.println();
        	
            System.out.println("Login successful. Welcome, " + user.getName() + "!");
            System.out.println();
            app(todo, user, users);
        } 
    }

    public static void signUp(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter email id:");
        String mailId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        User.registerUser(mailId, name, password, users);
        
    }

    public static void app(ArrayList<Task> todo, User user, ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        while (true) {
        	boolean found=false;
            System.out.println("========= Todo List =========");
            if (todo.isEmpty()) {
                System.out.println("No tasks to do today. Add a task!");
            } else {
                for (Task t : todo) {
                	found=true;
                    if (t.getDate().equals(formatter.format(date)) && t.getUmail().equals(user.getMailId())) {
                       
                    	System.out.println(t.toString());
                    }
                }
                if(!found) {
                	System.out.println("No tasks to do today. Add a task!");
                }
            }
            System.out.println("==============================");
            System.out.println("1. Add task");
            System.out.println("2. Update task status");
            System.out.println("3. Delete task");
            System.out.println("4. Display all tasks");
            System.out.println("5. Logout");
            System.out.println("Choose an option (1 to 5):");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    addTask(todo, user);
                    break;
                case "2":
                    updateTaskStatus(todo, user);
                    break;
                case "3":
                    deleteTask(todo, user);
                    break;
                case "4":
                    displayAllTasks(todo, user);
                    break;
                case "5":
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
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
