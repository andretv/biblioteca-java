package server;

import java.util.ArrayList;

import shared.ActionPackage;
import shared.Book;
import shared.Customer;
import shared.IMessenger;
import shared.ResponsePackage;

public class Attendant extends Thread {
	
	private Library library;
	private ActionPackage action;
	private IMessenger messenger;
	
	public Attendant(Library library, ActionPackage action, IMessenger messenger) {
		this.library = library;
		this.action = action;
		this.messenger = messenger;
	}
	
	
	@Override
	public void run() {
		ActionPackage pack = this.action;
		ResponsePackage response = new ResponsePackage();
		
		if (pack.getAction().equals("login" )) {
			this.library.auth(pack.getUser());
		} else if (pack.getAction().equals("list-books")) {
			
			ArrayList<Book> books = this.library.getBooksList();
			response.setResponseSlug("list-books");
			response.setBooksList(books);
			this.messenger.sendPackage(response);
			
		}else if (pack.getAction().equals("borrow-book")) {
			this.library.borrowBook((Customer)pack.getUser(), pack.getBook());
		} else if (pack.getAction().equals("return-book")) {
			this.library.returnBook(pack.getBook());
		} else if (pack.getAction().equals("register-book")) {
			this.library.addBook(pack.getBook());
		} else if (pack.getAction().equals("remove-book")) {
//			this.library.removeBook(pack.getBook());
		} else if (pack.getAction().equals("logout")) {
//			this.library.logout(pack.getUser());
		}
	}
	
}
