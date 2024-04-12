package com.chainsys.day3;

import java.util.Scanner;

public class LoginCredential {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner sc = new Scanner(System.in);
		        System.out.println("Account creation ..");
                System.out.println("Enter your username ");
                String userName=sc.next();
		        System.out.print("enter a password: ");
		        String password = sc.next();
                while(!isValidPassword(password)) {
		  
		            System.out.println("Invalid password should have 1 specail , 1number ");
		            password = sc.next();
		       }
            System.out.println("Account created..");
            System.out.println("login now..");
            System.out.println("enter your username :");
            String loginName=sc.next();
            System.out.print(" enter a password: ");
	        String loginpassword = sc.next();
	        if(loginpassword.equals(password) && userName.equals(loginName)) {
	        	System.out.println("login successfully");
	        }
	        else{
	        	  System.out.println("Invalid login credentials");

	        }
	                  
		    

	}
	 public static boolean isValidPassword(String password) {
	        // Check minimum length
	        if (password.length() < 6) {
	            return false;
	        }
	        int specail=0;
	        int digit=0;
	        boolean hasDigit=false;
	        boolean hasSpecialCharacter=false;
	        for(int i=0;i<password.length();i++) {
                if(!Character.isDigit(password.charAt(i))&& !Character.isLetter(password.charAt(i))&& !Character.isWhitespace(password.charAt(i))) {
                	specail++;
                }
                if(password.charAt(i)<='9' && password.charAt(i)>='0') {
                	digit++;
                }
	        }
	        if(specail>0) {
	        	 hasSpecialCharacter=true;
	        }
	        if(digit>0) {
	        	hasDigit =true;
	        }

	        return hasSpecialCharacter && hasDigit;
	    }


}


