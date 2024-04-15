package com.chainsys.day6;

import java.util.Arrays;
import java.util.Random;

public class ArraysProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {5, 2, 7, 1, 9, 3};

        // Sorting the array Arrays.sort(arrayname)
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Searching  Arrays.binarySearch(array,search element)
        int searchKey = 7;
        int index = Arrays.binarySearch(numbers, searchKey);
        if (index >= 0) {
            System.out.println("Element " + searchKey + " found at index " + index);
        } else {
            System.out.println("Element " + searchKey + " not found");
        }

        // Arrays.fill(array,length)
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled array: " + Arrays.toString(filledArray));

        // Copying an array
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(originalArray, 7);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Checking equality of arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        boolean equalArrays = Arrays.equals(array1, array2);
        System.out.println("Arrays are equal: " + equalArrays);
        Random random=new Random(1000);
        System.out.println("random number in array :"+array1[random.nextInt(array1.length)]);
                

	}

}
