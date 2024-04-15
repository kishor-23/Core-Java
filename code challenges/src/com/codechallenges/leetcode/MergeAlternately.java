package com.codechallenges.leetcode;
/*
 * Input: word1 = "abc", word2 = "pqr"
   Output: "apbqcr"
Explanation: The merged string will be merged as so:
  word1:  a   b   c
  word2:    p   q   r
  merged: a p b q c r
 * 
 */
public class MergeAlternately {
	 public static String mergeAlternately(String word1, String word2) {
	        String s="";
	        int i=0;
	        int j=0;
	        while(i<word1.length() && j<word2.length()){
	            s+=word1.charAt(i);
	            s+=word2.charAt(j);
	            i++;
	            j++;
	        }
	        while(i<word1.length()){
	             s+=word1.charAt(i++);
	        }
	           while(j<word2.length()){
	             s+=word2.charAt(j++);
	        }
	        return s;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1="abc";
		String word2 = "pqr";
		System.out.println("word 1:"+word1);
		System.out.println("word 2:"+word2);
		System.out.println("merge :"+mergeAlternately(word1, word2));
         
	}

}
