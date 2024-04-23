package com.chainsys.oops;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Movie m1 = new ImplMovie("spider man", 4, "good movie");
		ImplMovie m2 = new ImplMovie();
	
	//	System.out.println("Movie class ..");
		System.out.println("Enter movie name :");
		String movie = sc.nextLine();
		System.out.println("Enter rating (1-5) :");
		int rating = Validation.getPositiveInput(sc);
		
		while(rating>5) {
			System.out.println("rating should be (1-5)");
			rating = Validation.getPositiveInput(sc);
		}

		sc.nextLine();
		System.out.println("Enter review ");
		String review = sc.nextLine();

		m2.setName(movie);
		m2.setRating(rating);
		m2.setReview(review);
		

		System.out.println("movies ");

		System.out.println(m1.displayMovieDetails());

		System.out.println(m2.displayMovieDetails());
	



	}

}
