package com.chainsys.day3;

import java.util.Scanner;

public class Tax {

	
		// TODO Auto-generated method stub
		 public static double taxCalculator(int grossSalary, int savings) {
		        // Calculate taxable income after deducting savings
		        int taxableIncome = grossSalary - Math.min(savings, 100000);

		        // Apply tax slabs
		        double tax = 0.0;
		        if (taxableIncome <= 100000) {
		            // Slab 0: No tax
		            tax = 0;
		        } else if (taxableIncome <= 200000) {
		            // Slab 1: 10% of the difference above 100,000
		            tax = 0.1 * (taxableIncome - 100000);
		        } else if (taxableIncome <= 500000) {
		            // Slab 2: Tax from Slab 0 + Tax from Slab 1 + 20% of income exceeding 200,000
		            tax = (0.1 * 100000) + (0.2 * (taxableIncome - 200000));
		        } else {
		            // Slab 3: Tax from Slab 0 + Tax from Slab 1 + Tax from Slab 2 + 30% of income exceeding 500,000
		            tax = (0.1 * 100000) + (0.2 * 300000) + (0.3 * (taxableIncome - 500000));
		        }

		        return tax;
		    }

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter your gross salary: ");
		        int grossSalary = sc.nextInt();
				 while(grossSalary<=0) {

					 System.out.println("invalid please enter a positive number ");
					 grossSalary=sc.nextInt();
					
					 
					}

		        System.out.print("Enter your total savings: ");
		        int savings = sc.nextInt();

		        double incomeTax = taxCalculator(grossSalary, savings);
		        System.out.println("Income tax amount is: " + incomeTax);
       }

	

}
