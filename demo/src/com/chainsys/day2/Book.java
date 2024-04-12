package com.chainsys.day2;

public class Book {
	 int id;
     String title;
     String author;
     double price;
     Book(int id,String title, String author, double Price){
    	 this.id=id;
         this.title = title;
         this.author = author;
         this.price = Price;
     }
     void displayDetails() {
    	 System.out.println("Book id:"+id+"\nTitle:"+title+"\nauthor: "+author+"\nprice :"+price);
     }
     public static void main(String[] args) {
    	 Book b1=new Book(1,"Wings of Fire","A. P. J. Abdul Kalam and Arun Tiwari",200);
 		b1.displayDetails();	
     }
     
     }

