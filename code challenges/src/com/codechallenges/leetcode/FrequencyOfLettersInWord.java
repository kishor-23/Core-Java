package com.codechallenges.leetcode;

import java.util.HashMap;

class FrequencyOfLettersInWord {

	public static void main(String[] args) {

		String word="ababc";
		HashMap<Character,Integer> hp=new HashMap<>();
		for(int i=0;i<word.length();i++) {
			if(hp.containsKey(word.charAt(i))) {
			   hp.put(word.charAt(i),hp.get(word.charAt(i))+1);
			}
			else {
				hp.put(word.charAt(i),1);
			}
		}
		System.out.println("Count of each letter "+hp);

	}

}
