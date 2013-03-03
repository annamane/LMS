package com.testing.android;

public class LibraryMember {
	
	private String name ; // Name of the Member
	private int phonenum; //Phone number
	private int maximumBooks; //Num of the max books he can check out
	
	
	//Constructor
	public LibraryMember () {
		
		name = "unknown name";
		maximumBooks = 2;
	}
	
	public void setName(String name) {
		
		this.name=name;
	}

	public void setNumber(int num) {
		this.phonenum=num;
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getNumber(){
		return phonenum;
	}
}
