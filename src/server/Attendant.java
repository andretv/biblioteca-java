package server;

import shared.Book;
import shared.Customer;

public class Attendant {
	
	private Library library;
	
	public Attendant(Library library) {
		this.library = library;
	}
	
	public void borrowBook(Customer customer, Book book) {
		this.library.borrowBook(customer, book);
	}
	
	public void returnBook(Book book) {
		this.library.returnBook(book);
	}
	
}
