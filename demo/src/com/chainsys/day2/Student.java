package com.chainsys.day2;

public class Student {
   private	int idn;
	String name;
	int rollno;
	int age;
	char gender;
	String bloodGroup;
	//initial value to objects
	Student(int id,String name,int rollno,int age,char gender, String bloodGroup){
	   idn=id;
		this.name=name;
		this.rollno=rollno;
		this.age=age;
		this.gender=gender;
		this.bloodGroup=bloodGroup;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		name=name;
	}
	 void displayDetails() {
    	 System.out.println("sid:"+idn+"\nName:"+name+"\nrollno "+rollno+"\nage :"+age+"\nbloodGroup :"+bloodGroup+"\ngender :"+gender);
     }
	 public static void main(String[] args) {
		 Student s1=new Student(1,"vikram",3575,23,'M', "B positive");
		 s1.displayDetails();
		 s1.setName("vikram");
		 System.out.println(s1.getName());
	 }

}
