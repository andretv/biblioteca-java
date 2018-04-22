package server;

import shared.ActionPackage;
import shared.Customer;
import shared.IMessenger;
import shared.MessengerUDP;

public class AppServer {
	public static void main(String[] args) {
		System.out.println("Server");
		
		Library library = new Library();
		IMessenger messenger = new MessengerUDP(8080);
		
		while(true) {
			ActionPackage pack = (ActionPackage)messenger.receivePackage();
			Attendant attendant = new Attendant(library, pack, messenger);
			attendant.run();
		}
		
	}

}
