package com.chainsys.day8april22task;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Task> todo = new ArrayList<>();
		System.out.println("***welcome to todolist app***");
		while (true) {
			
			System.out.println("====Todo List======");
			if(todo.isEmpty()) {
				System.out.println("no task to do, add a task");
				System.out.println();
			}
			else {
				for (Task t : todo) {
					System.out.println(t.toString());
				}
				System.out.println("===============");
				System.out.println();
			}
			
			System.out.println("1. Add task");
			System.out.println("2. update task status");
			System.out.println("3. delete task");
			System.out.println("4. exit");
			System.out.println("choose an option(1 to 5)");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("enter a todo task :");
				String task = sc.next();
				todo.add(new Task(task, "not done"));
				break;


			case 2:
               System.out.println("enter task id:");
               int id=Validation.getPositiveInput(sc);
               boolean found = false;
       		for (Task t : todo) {
       			if (t.getId() == id) {
       				found = true;
       				System.out.println("enter a todo task status :");
    				String status = sc.next();
    				t.setStatus(status);
       			}
       		}
				break;

			case 3:
				 System.out.println("enter task id:");
	               int tid=Validation.getPositiveInput(sc);
	               boolean founded = false;
	       		for (int i=0;i< todo.size();i++) {
	       			if (todo.get(i).id == tid) {
	       				founded=true;
	       				todo.remove(i);
	       					    			
	       			}
	       		}
	       		if(!founded) {
	       			System.out.println("not found");
	       		}
				break;
			case 4:
				System.out.println("...thank you...");
				return;

			default:
				System.out.println("Wrong input!");
				System.out.println();
			}

		}

	}

}
