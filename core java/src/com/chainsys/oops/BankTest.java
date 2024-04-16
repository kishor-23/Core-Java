package com.chainsys.oops;

import java.util.Scanner;

public class BankTest {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
       
        Bank bank = new Bank("ABC Bank", "Main Branch", "ABC123");
        // Create user objects with provided data
       // User user2 = new User("babu", "12345", 1000, "1234567899");
      //  User user3 = new User("raghu", "56789", 2000, "1234567897");
        
        System.out.println("enter user details ...");
        System.out.println("enter name :");
        String username=sc.next();
        while(!Validation.isname(username)) {
        	System.out.println("enter only letters");
        	username=sc.next();
        }
        System.out.println("enter account :");
        String useraccno=sc.next();
        while(!Validation.isaccount(useraccno)) {
        	System.out.println("enter only letters");
        	useraccno=sc.next();
        }
        System.out.println("enter phone no:");
        String userphoneno=sc.next();
        while(!Validation.isPhoneNumber(userphoneno)) {
        	System.out.println("enter only numbers");
        	userphoneno=sc.next();
        }
        System.out.println("enter initial deposit amount : ");
        double useramount=Validation.getPositiveInput(sc);
        
        User user1=new User(username,useraccno,useramount,userphoneno);
        User[] users = {user1};
        bank.setUsers(users);
        bank.printUserDetails();
       
      String[] savingsPlans = {"Regular Savings", "High-Interest Savings"};
       bank.setSavingsPlans(savingsPlans);
       
      bank.showAvailableSavingsPlans();
      System.out.println();
        System.out.println("enter amount to deposit");
        double amount=Validation.getPositiveInput(sc);
        
        
     //method overloading 
        // Deposit with account number
        bank.deposit(useraccno,amount);
       
        // Deposit with phone number
        bank.deposit(amount, userphoneno);

        // Deposit with account number && phone number
        bank.deposit(useraccno,amount, userphoneno);
       // System.out.println("after deposit saving has "+user1.getSavings());
        bank.printUserDetails();
    }
}
