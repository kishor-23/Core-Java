package com.chainsys.oops;

//interface
//An interface is a completely "abstract class"
//only abstract methods
interface Movie{  
	String displayMovieDetails();
}


public class ImplMovie implements Movie{
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
	public ImplMovie( String name,int rating, String review) {
		
		this.id = c++;
		this.rating = rating;
		this.name = name;
		this.review = review;
	}
	public ImplMovie() {
	   id = c++;
	}
	@Override
	public String displayMovieDetails() {
		return "Movie [id=" + id + ", rating=" + rating + ", name=" + name + ", review=" + review + "]";
	}
	
    
	

}
