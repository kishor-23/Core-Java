package com.codechallenges.leetcode;

import java.util.Stack;

public class ValidParentheses {
   public static boolean isValid(String str) {
	   Stack<Character> stack = new Stack<Character>();
	   for(char c:str.toCharArray()){
		   if(c=='(') {
			   stack.push(')');
		   }
		   else if(c=='[') {
			   stack.push(']');
		   }
		   else if(c=='{') {
			   stack.push('}');
		   }
		   else if(stack.isEmpty()|| stack.pop()!=c){
               return false;
           }
	   }
        return stack.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()[]{}";
		System.out.println("string :"+s);
		System.out.println("is valid :"+ isValid(s));
		

	}

}
