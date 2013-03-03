package com.testing.android;

public class LibraryBook {

	String title;
	String author;
	LibraryMember user;

	//Constructor
	public LibraryBook(String mystring, String author) {
		// TODO Auto-generated constructor stub
		this.title = mystring;
		this.author = author;
		user = new LibraryMember();
		this.user.setName(null);
		this.user.setNumber(0);
}
	
	public void setAuthor(String author) {
		
		this.author=author;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getBookName(){
		return title;
	}
}
