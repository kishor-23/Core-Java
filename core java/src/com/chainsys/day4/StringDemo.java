package com.chainsys.day4;
public class StringDemo {
    public static void main(String[] args) {
       
        String str = "Hello, World!";
        System.out.println("String :"+str);

       
        int length = str.length();
        System.out.println("Length of the string: " + length);


        char character = str.charAt(7);
        System.out.println("Character at index 7: " + character);


        String substring = str.substring(7);
        System.out.println("Substring starting from index 7: " + substring);


        String substring2 = str.substring(7, 12);
        System.out.println("Substring from index 7 to 12: " + substring2);


        int index = str.indexOf("World");
        System.out.println("Index of 'World': " + index);

        int lastIndex = str.lastIndexOf("l");
        System.out.println("Last Index of 'l': " + lastIndex);

      
        String lowerCase = str.toLowerCase();
        System.out.println("Lowercase string: " + lowerCase);


        String upperCase = str.toUpperCase();
        System.out.println("Uppercase string: " + upperCase);

     
        String stringWithWhitespaces = "   Hello, World!   ";
        System.out.println("string with white :"+stringWithWhitespaces);
        String trimmedString = stringWithWhitespaces.trim();
        System.out.println("Trimmed string:" + trimmedString);

        String replacedString = str.replace("o", "0");
        System.out.println("String with 'o' replaced by '0': " + replacedString);
 
 
        String[] splitArray = str.split(", ");
        System.out.println("String split into array and print in reverse: ");
   
        for(int i=splitArray.length-1;i>=0;i--) {
        	System.out.print(splitArray[i]+" ");
        }
    }
}
