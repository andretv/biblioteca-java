package server;

import java.util.ArrayList;

import shared.Admin;
import shared.Book;
import shared.Customer;
import shared.User;

public class Library {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<User> users = new ArrayList<User>();
	
	public Library() {
		this.populateUsers();
		this.populateBooks();
	}
	
	public synchronized void borrowBook(Customer customer, Book book) {
		if (book.getCustomerId() != 0) {
			try { 
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		book.setCustomerId(customer.getUserId());
	
	}
	
	public void returnBook(Book book) {
		book.setCustomerId(0);
		notify();
	}
	
	public boolean auth(User user) {
		for (int i = 0; i < this.users.size(); i++) {
			User tmpUser = this.users.get(i);
			if (user.getUsername().equals(tmpUser.getUsername())  && user.getUserPassword().equals(tmpUser.getUserPassword())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addUser(User customer) {
		this.users.add(customer);
	}
		
	public void addBook(Book book) {
		this.books.add(book);
	}

	public void populateUsers() {
		for (int i = 0; i < 20; i++) {
			Customer customer = new Customer(i, "user" + i , "123456");
			this.addUser(customer);
		}
		
		for (int i = 20; i < 25; i++) {
			Admin admin = new Admin(i, "admin" + i, "123456");
			this.addUser(admin);;
		}
	}
	
	public void populateBooks() {
		for (int i = 0; i < 10; i++) {
			Book book = new Book(i, "Book" + i, 2000 + i);
			this.addBook(book);;
		}
	}
}
