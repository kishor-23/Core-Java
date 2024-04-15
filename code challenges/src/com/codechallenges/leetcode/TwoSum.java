package com.codechallenges.leetcode;

import java.util.Arrays;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[j]+nums[i]==target){
                    return new int[]{i,j};
                }
      return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,7,11,15};
		int target=26;
	
		System.out.println(Arrays.toString(arr));
		System.out.println("target sum: "+target);
		System.out.println("index :"+Arrays.toString(twoSum(arr,target)));
		
		

	}

}
