package com.codechallenges.leetcode;

import java.util.ArrayList;
import java.util.List;

//leecode : 1431. Kids With the Greatest Number of Candies

public class KidsAndCandies {
	 public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        int max=0;
	        for(int i=0;i<candies.length;i++){
	            if(max<candies[i]){
	                max=candies[i];
	            }
	        }
	        List<Boolean> ans=new ArrayList<Boolean>();
	        for(int i=0;i<candies.length;i++){
	            if(candies[i]+extraCandies<max){
	                ans.add(false);
	            }
	            else{
	                ans.add(true);
	            }
	        }
	         return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int candies[] = {2,3,5,1,3};
		 int extraCandies = 3;
		 //ans : [true,true,true,false,true]
		 
		 List<Boolean> ans=kidsWithCandies(candies, extraCandies);
		 System.out.println(ans);

	}

}
