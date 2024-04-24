package com.chainsys.day8april22task;

import java.util.ArrayList;

public class User {
 String mailId;
 String name;
 String password;
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(String mailId, String name, String password) {
	
	this.mailId = mailId;
	this.name = name;
	this.password = password;
}


// Function to register a new user
public static void registerUser(String mailId, String name, String password,ArrayList<User> users) {
    // Check if the user already exists
    for (User user : users) {
        if (user.getMailId().equals(mailId)) {
            System.out.println("User already exists with this email ID.");
            return;
        }
    }
    // Create a new user object and add it to the list
    User newUser = new User(mailId, name, password);
    users.add(newUser);
    System.out.println("User registered successfully.");
}



public static User loginUser(String mailId, String password,ArrayList<User> users) {
    // Check if the user exists and the password matches
    for (User user : users) {
        if (user.getMailId().equals(mailId) && user.getPassword().equals(password)) {
           // System.out.println("Login successful. Welcome, " + user.getName() + "!");
            return user;
        }
    }
    // If no user found or password doesn't match
    System.out.println("Invalid email ID or password. Please try again.");
    return null;
}
 
}


  

