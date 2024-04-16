package com.chainsys.day2;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bankId;
        String bankName;
        String branch;
        long telephoneNo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bank Id:");
        bankId = sc.nextInt();
        System.out.println("Bank Name :");
        bankName = sc.next();
        System.out.println("telephoneNo :");
        telephoneNo = sc.nextLong();
        System.out.println("Enter branch :");
        branch= sc.next();
       
        
        System.out.println("Bank Id :" +bankId + "\ntelephoneNo :" +telephoneNo + "\nBankName :" + bankName + "\nBranch:" + branch);
      

	}

}
