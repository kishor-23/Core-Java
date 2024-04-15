package com.codechallenges.leetcode;

public class LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        
	        int minstrindex=0;
	       
	        int minstrlen=strs[0].length();
	        for(int i=1;i<strs.length;i++){
	            if(strs[i].length()<minstrlen){
	            	//finding the string with minimum number of characters
	                // and the index of tht string in array
	                minstrlen=strs[i].length();
	                minstrindex=i;
	            }
	        }
	        int match=minstrlen;
	        for(int i=0;i<strs.length;i++) {
	            if(i==minstrindex){
	                continue;
	            }
	             int count=0;
	            for(int j=0;j<minstrlen;j++){
	               //comparing letters in minimum character word with all other word string in array
	            
	                if(strs[i].charAt(j)==strs[minstrindex].charAt(j)){
	                    count++;
	                }
	                else{
	                    break;
	                }
	            }
	            if(count<match){
	                match=count;
	            }
	        }

	        String ans= strs[minstrindex];
	        return ans.substring(0,match);
	        
	    }
	 

	public static void main(String[] args) {
		
		String s[]= {"flower","flow","flight"};
		String ans= longestCommonPrefix(s);
		//ans : fl
		System.out.println("longest commonPrefix :"+ans);
		
		

	}

}
