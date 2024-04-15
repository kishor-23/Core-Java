package com.codechallenges.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int merge[]=new int[m+n];
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
             merge[k++]=nums1[i++];
            }
            else{
                 merge[k++]=nums2[j++];
            }

        }
        while(i<m){
            merge[k++]=nums1[i++];
        }
         while(j<n){
             merge[k++]=nums2[j++];
        }
        System.out.println(Arrays.toString(merge));
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {1,2,3,0,0,0};
		int m =3 ;
		int nums2[] = {2,5,6};
		int n = 3;
		merge(nums1, m, nums2, n);
				//Output: [1,2,2,3,5,6]

	}

}
