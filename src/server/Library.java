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

	public ArrayList<Book> getBooksList() {
		return this.books;
	}

	public synchronized void borrowBook(Customer customer, Book book) {
		Book tempBook = null;
		
		for (int i = 0; i < this.books.size(); i++) {
			if (book.getId() == this.books.get(i).getId()) {
				tempBook = this.books.get(i);
			}
		}

		if (tempBook.getCustomerId() != 0) {
			try {
				System.out.println("Livro locado. Aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Usuário " + customer.getUsername() + " alugou o livro");
		tempBook.setCustomerId(customer.getUserId());

	}

	public void returnBook(Book book) {
		Book tempBook = null;
		
		for (int i = 0; i < this.books.size(); i++) {
			if (book.getId() == this.books.get(i).getId()) {
				tempBook = this.books.get(i);
			}
		}
		
		System.out.println("Livro '" + book.getTitle() + "' devolvido");
		tempBook.setCustomerId(0);
		notify();
	}

	public boolean auth(User user) {
		for (int i = 0; i < this.users.size(); i++) {
			User tmpUser = this.users.get(i);
			if (user.getUsername().equals(tmpUser.getUsername())
					&& user.getUserPassword().equals(tmpUser.getUserPassword())) {
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
			Customer customer = new Customer(i, "user" + i, "123456");
			this.addUser(customer);
		}

		for (int i = 20; i < 25; i++) {
			Admin admin = new Admin(i, "admin" + i, "123456");
			this.addUser(admin);
			;
		}
	}

	public void populateBooks() {
		for (int i = 0; i < 10; i++) {
			Book book = new Book(i, "Book" + i, 2000 + i);
			this.addBook(book);
			;
		}
	}
}
