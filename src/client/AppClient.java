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

		Customer customer = new Customer(1, "user1", "123456");
		
		ActionPackage action = new ActionPackage();
		action.setAction("list-books");
		action.setUser(customer);
		messenger.sendPackage(action);
	
		
		ResponsePackage response = (ResponsePackage)messenger.receivePackage();
		
		if (response.getResponseSlug().equals("list-books" )) {
			System.out.println("Lista de Livros:");
			for (int i = 0; i < response.getBooksList().size(); i++) {
				Book book = response.getBooksList().get(i);
				System.out.println(i + ". " + book.getTitle());
			}
		}
	}

}
