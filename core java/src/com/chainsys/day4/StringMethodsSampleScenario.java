package com.chainsys.day4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringMethodsSampleScenario {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Account  Creation...");
		System.out.println("Enter your name :");
		String name=sc.next();
		while(!isname(name)) {
			System.out.println("invalid: Enter only letters(vikram)");
			 name=sc.next();
		}
	
		System.out.println("Enter your mail iD:");
		
		String mailId=sc.next();
		
		while(!isMailVaild(mailId)) {
			System.out.println("please enter a vaild mail id like name@gmail.com ");
			mailId=sc.next();
		}
	System.out.println("Enter your company mail id: ");
		
		String companyMailId=sc.next();
	
		while(!isvalidCompanyid(companyMailId)) {
			System.out.println("please enter a vaild mail id  like  example@chainsys.com");
			companyMailId=sc.next();
		}

      
		
	
		System.out.println("enter sex: ");
		String sex=sc.next();
		
        while(true) {
        	if(sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("m")|| sex.equalsIgnoreCase("f")) {
        		break;
        	}
        	System.out.println("invalid choose male or female");
    		sex=sc.next();
        }
        System.out.print("Please enter a password: ");
        String password = sc.next();

        while(!isValidPassword(password)) {
            System.out.println("inValid password !,password should have 1 specail character, number ,capital  example:#Password123 ");
            password = sc.next();
        }
        System.out.println();
		System.out.println("Account created :");
		System.out.println("Name    :"+name);
	    System.out.println("mail id :"+mailId);
	    System.out.println("mail id :"+companyMailId);
	    
	
		System.out.println("gender  :"+sex);
		System.out.println("password :"+password);
		
		
	    

	}
	 public static boolean isMailVaild(String mail) {
//	        // Check minimum length
//	        if (mail.length() < 6) {
//	            return false;
//	        }
//	        //@ position should not be in first or last position 
//	        //mail should have @ 
//	        int atIndex=mail.indexOf('@');
//	        if(atIndex==0 || atIndex== mail.length()-1  || atIndex==-1) {
//	        	return false;
//	        }
		 
		 //^[a-z0-9]  -[kishor23] is vaild ,before @
		 //@[A-Za-z0-9] means after @ 
		 // \\.[A-Z]{2,} means after dot it should have 2 or more char
		 String regEx = "^[a-z0-9]+[a-z0-9\\.]+@[a-z0-9]+\\.[a-z]{2,}$";

	        //pattern is a singleton class we can not create object
	        Pattern p=Pattern.compile(regEx);
	        Matcher m=p.matcher(mail);	        
	       return m.matches();
	    }
	 public static boolean isvalidCompanyid(String mail) {
		 String regEx = "^[a-z0-9]+[a-z0-9\\.]+@chainsys.+[a-z]{2,}$";

	        //pattern is a singleton class we can not create object
	        Pattern p=Pattern.compile(regEx);
	        Matcher m=p.matcher(mail);	        
	       return m.matches();
	 }
	 public static boolean isname(String name) {
		 //only letters
		 String regEx = "^[a-zA-Z]+$";
		 Pattern p=Pattern.compile(regEx);
	        Matcher m=p.matcher(name);	        
	       return m.matches();
		 
	 }
	 
	 public static boolean isValidPassword(String password) {
	        // Check minimum length 6
	  String regEx = "(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{5,}";
	
		  Pattern p=Pattern.compile(regEx);
	        Matcher m=p.matcher(password);	        
	       return m.matches();
	       
//	        if (password.length() < 6) {
//	            return false;
//	        }
//	        int specail=0;
//	        int digit=0;
//	        boolean hasDigit=false;
//	        boolean hasSpecialCharacter=false;
//	        for(int i=0;i<password.length();i++) {
//             if(!Character.isDigit(password.charAt(i))&& !Character.isLetter(password.charAt(i))&& !Character.isWhitespace(password.charAt(i))) {
//             	specail++;
//             }
//             if(password.charAt(i)<='9' && password.charAt(i)>='0') {
//             	digit++;
//             }
//	        }
//	        if(specail>0) {
//	        	 hasSpecialCharacter=true;
//	        }
//	        if(digit>0) {
//	        	hasDigit =true;
//	        }
//
//	        return hasSpecialCharacter && hasDigit;
	    }

}
