package server;

import shared.Customer;
import shared.IMessenger;
import shared.MessengerUDP;

public class AppServer {
	public static void main(String[] args) {
		System.out.println("Server");
		
		Library library = new Library();
		IMessenger messenger = new MessengerUDP(8080);
		
		while(true) {
			Customer customer = (Customer)messenger.receivePackage();
		
			if (library.auth(customer)) {
				System.out.println("AUTENTICOUUUU!!");
			} else {
				System.out.println("Usuário não autenticado");
			}
			
		}
		
	}

}
