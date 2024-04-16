package com.chainsys.oops;

class Person {
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Person(String name,  String gender,int age) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Person() {
    	
    }

    public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	// Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // toString method to represent person details
    @Override
    public String toString() {
        return name + ", " + age + " years old, " + gender;
    }
}