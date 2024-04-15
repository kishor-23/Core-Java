package com.codechallenges.leetcode;

public class MissingNumber {
	 public static int missingNumber(int[] nums) {
	       int sum=0;
	       for(int i=0;i<nums.length;i++) {
	    	   sum+=nums[i];
	       }
	       int n=nums.length;
	       int nsum=(n*(n+1)/2);
	       
	       
	       
	        return nsum-sum;       
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,4,0};
		
       System.out.println(missingNumber(arr));
	}

}
