package com.chainsys.oops;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Movie m1 = new Movie("spider man", 4, "good movie");
		Person p1 = new Person("abinesh", "male", 22);

		Movie m2 = new Movie();
		System.out.println("Movie class ..");
		System.out.println("enter movie name");
		String movie = sc.nextLine();
		System.out.println("enter rating (1-5)");
		int rating = Validation.getPositiveInput(sc);
		
		while(rating>5) {
			System.out.println("rating should be (1-5)");
			rating = Validation.getPositiveInput(sc);
		}

		sc.nextLine();
		System.out.println("enter review");
		String review = sc.nextLine();

		m2.setName(movie);
		m2.setRating(rating);
		m2.setReview(review);
		System.out.println("person class ... ");
		System.out.println("enter person name");
		String name = sc.nextLine();
		
		while (!Validation.isname(name)) {
			System.out.println("invalid: Enter only letters(vikram)");
			name = sc.next();
		}
		
		System.out.println("enter  gender: (male/female)");
		String sex = sc.next();

		while (true) {
			if (sex.equals("male") || sex.equals("female")) {
				break;
			}
			System.out.println("invalid choose male or female");
			sex = sc.next();
		}
		
		System.out.println("enter age :");
		int age = Validation.getPositiveInput(sc);

		Person p2 = new Person();
		p2.setAge(age);
		p2.setGender(sex);
		p2.setName(name);

		System.out.println("movies ");

		System.out.println(m1.toString());

		System.out.println(m2.toString());
		System.out.println("person ");

		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}

}
