package client;

import shared.ActionPackage;
import shared.Admin;
import shared.Book;
import shared.Customer;
import shared.MessengerUDP;
import shared.ResponsePackage;

public class AppClient {

	public static void main(String[] args) {
		System.out.println("Cliente");

		MessengerUDP messenger = new MessengerUDP();
		messenger.setDestPort(8080);

		Customer customer1 = new Customer(1, "user1", "123456");
		Customer customer2 = new Customer(2, "user2", "123456");

		ActionPackage action = new ActionPackage();

		action.setUser(customer1);
		action.setAction("list-books");
		messenger.sendPackage(action);

		ResponsePackage response = (ResponsePackage) messenger.receivePackage();

		action.setBook(response.getBooksList().get(0));

		action.setAction("borrow-book");
		messenger.sendPackage(action);

		action.setUser(customer2);
		messenger.sendPackage(action);

		try {
			System.out.println("Usuario lendo o livro.");
			Thread.sleep(10000);
			System.out.println("Usuario acabou de ler.");		
			action.setAction("return-book");
			messenger.sendPackage(action);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// public static void main(String[] args) {
	// System.out.println("Cliente");
	//
	// MessengerUDP messenger = new MessengerUDP();
	// messenger.setDestPort(8080);
	//
	// Customer customer2 = new Customer(2, "user2", "123456");
	//
	// ActionPackage action = new ActionPackage();
	//
	// action.setUser(customer2);
	// action.setAction("list-books");
	// messenger.sendPackage(action);
	//
	// ResponsePackage response = (ResponsePackage) messenger.receivePackage();
	//
	// action.setBook(response.getBooksList().get(0));
	//
	// action.setAction("borrow-book");
	// messenger.sendPackage(action);
	//
	// }

	/*
	 * 
	 * LIST BOOKS
	 * 
	 */
	// public static void main(String[] args) {
	// System.out.println("Cliente");
	//
	// MessengerUDP messenger = new MessengerUDP();
	// messenger.setDestPort(8080);
	//
	// Customer customer = new Customer(1, "user1", "123456");
	//
	// ActionPackage action = new ActionPackage();
	// action.setAction("list-books");
	// action.setUser(customer);
	// messenger.sendPackage(action);
	//
	// ResponsePackage response = (ResponsePackage) messenger.receivePackage();
	//
	// if (response.getResponseSlug().equals("list-books")) {
	// System.out.println("Lista de Livros:");
	//
	// for (int i = 0; i < response.getBooksList().size(); i++) {
	// Book book = response.getBooksList().get(i);
	// System.out.println(i + ". " + book.getTitle());
	// }
	//
	// }
	//
	// }

}
