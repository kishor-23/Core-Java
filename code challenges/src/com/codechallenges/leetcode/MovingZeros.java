package com.codechallenges.leetcode;

import java.util.Arrays;

public class MovingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int arr[]= {1,0,2,0,4,0,5	};
  //ans :1,2,4,5,0,0,0
  int index=0;
  for(int i=0;i<arr.length;i++) {
	  if(arr[i]!=0) {
		  int temp=arr[index];
		  arr[index]=arr[i];
		  arr[i]=temp;
		  index++;
	  }
  }
  System.out.println(Arrays.toString(arr));
	  
  }

}
