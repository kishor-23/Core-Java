package com.chainsys.day2;

import java.util.Scanner;

class Movie{
	int id;
	float rating;
	String name;
    String review;
    void showDetails() {
    	System.out.println("Movie id:"+id+"\nName :"+name+"\nRating: "+rating+"\nreview :"+review);
    }
}
public class DemoClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Movie
		Movie m1=new Movie();
		System.out.println("Enter id : ");
		m1.id=sc.nextInt();
		System.out.println("enter movie name :");
		m1.name=sc.next();
		System.out.println("review :");
		m1.review=sc.next();
		System.out.println("rating :");
		m1.rating=sc.nextFloat();
		System.out.println();
		m1.showDetails();
		 Student s2=new Student(1,"vikram",3575,23,'M', "B positive");
		 s2.displayDetails();
		
		
	
	
	}
}
;