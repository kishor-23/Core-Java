package com.chainsys.oops;

public class Bank {

    String bankName;
    String branch;
    String ifsc;
    String[] savingsPlans; 
    User[] users; 
    // Array to store user details

    public String[] getSavingsPlans() {
        return savingsPlans;
    }

    public void setSavingsPlans(String[] savingsPlans) {
        this.savingsPlans = savingsPlans;
    }

   
    public void setUsers(User[] users) {
        this.users = users;
    }

    
    public User[] getUsers() {
        return users;
    }

   
    public void deposit(String accountNo, double amount) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNo)) {
                user.setSavings(user.getSavings()+amount);
                System.out.println("Depositing " + amount + " using account number " + accountNo);
             //   System.out.println("savings :"+user.getSavings());
                return; 
            }
        }
        System.out.println("Account not found with account number: " + accountNo);
    }


 
    public void deposit(double amount, String phone) {
        for (User user : users) {
            if (user.getPhoneno().equals(phone)) {
                user.setSavings(user.getSavings() + amount);
                System.out.println("Depositing " + amount + " using phone number " + phone);
                return;
            }
        }
        System.out.println("Account not found with phone number: " + phone);
    }

    
    public void deposit(String accountNo, double amount, String phone) {
        for (User user : users) {
            if (String.valueOf(user.getAccountNumber()).equals(accountNo) && user.getPhoneno().equals(phone)) {
                user.setSavings(user.getSavings() + amount);
                System.out.println("Depositing " + amount + " using account number " + accountNo + " and phone number " + phone);
                return; 
            }
        }
        System.out.println("Account not found with account number: " + accountNo + " and phone number: " + phone);
    }


   
    public void showAvailableSavingsPlans() {
        System.out.println("list of Savings Plans:");
        for (String plan : savingsPlans) {
            System.out.println(plan);
        }
    }

   
    public void printUserDetails() {
        System.out.println("User Details:");
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Account Number: " + user.getAccountNumber());
            System.out.println("Phone Number: " + user.getPhoneno());
            System.out.println("saving amount:"+user.getSavings());
           // System.out.println(); 
        }
    }

   

    public Bank(String bankName, String branch, String ifsc) {
        this.bankName = bankName;
        this.branch = branch;
        this.ifsc = ifsc;
    }
}
