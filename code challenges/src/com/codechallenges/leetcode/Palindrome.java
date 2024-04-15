package com.codechallenges.leetcode;

public class Palindrome {
	 public static boolean isPalindrome(int x) {
	        int temp=x;
	        int rev=0;
	        while(x>0){
	            rev=(rev*10)+x%10;
	            x=x/10;
	        }
	        return rev==temp?true:false;
	    }

	public static void main(String[] args) {
	
          int n=121;
          System.out.println("n :"+121);
          System.out.println("is palindrome :"+isPalindrome(n));
	}

}
