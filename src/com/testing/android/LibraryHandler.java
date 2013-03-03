package com.testing.android;

import java.util.ArrayList;

public class LibraryHandler {
	
	ArrayList<LibraryBook> Books;
	ArrayList<LibraryMember> Members;
	
	public LibraryHandler()
	{
	
	   Books = new ArrayList<LibraryBook>();
	   Members = new ArrayList<LibraryMember>();
	}
	
	public void addBook(LibraryBook B1) {
		
		Books.add(B1);
		
	}
	
	public void addMember(LibraryMember M1) {
		
		Members.add(M1);
	}
	
	public ArrayList<LibraryBook> getBooks() {
		
		return Books;
	}
	
	public ArrayList<LibraryMember> getMembers() {
		
		return Members;
	}
	public String toString()
	{
		return "Number of Books:" + this.getMembers().size();
	}
	

}
