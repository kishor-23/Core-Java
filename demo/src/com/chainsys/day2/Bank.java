package com.chainsys.day2;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int BankId;
        String BankName;
        String branch;
        long telephoneNo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bank Id:");
        BankId = sc.nextInt();
        System.out.println("Bank Name :");
        BankName = sc.next();
        System.out.println("telephoneNo :");
        telephoneNo = sc.nextLong();
        System.out.println("Enter branch :");
        branch= sc.next();
       
        
        System.out.println("Bank Id :" +BankId + "\ntelephoneNo :" +telephoneNo + "\nBankName :" + BankName + "\nBranch:" + branch);
      

	}

}
