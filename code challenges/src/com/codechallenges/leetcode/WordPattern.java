package com.codechallenges.leetcode;

import java.util.HashMap;

public class WordPattern {
	public static boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        HashMap<Character,String> hp=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(hp.containsKey(pattern.charAt(i))){
                if(!hp.get(pattern.charAt(i)).equals(arr[i])){
                    
                     return false;
                }
            }
            else{
                if(hp.containsValue(arr[i])){
                     return false;
                }
                hp.put(pattern.charAt(i),arr[i]);
            }
        }
        return true;
    }
	public static void main(String[] args) {

		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));
	}

}
