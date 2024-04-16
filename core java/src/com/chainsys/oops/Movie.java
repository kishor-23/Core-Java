package com.chainsys.oops;

public class Movie {

	int id;
	static int c=1;
	int rating;
	String name;
    String review;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;

	}
	public float getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Movie( String name,int rating, String review) {
		
		this.id = c++;
		this.rating = rating;
		this.name = name;
		this.review = review;
	}
	public Movie() {
	   id = c++;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", rating=" + rating + ", name=" + name + ", review=" + review + "]";
	}
	
    
	

}
