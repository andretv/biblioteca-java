package client;

import shared.Customer;
import shared.MessengerUDP;

public class AppClient {

	public static void main(String[] args) {
		System.out.println("Cliente");
		
		MessengerUDP messenger = new MessengerUDP();
		messenger.setDestPort(8080);
	
		Customer customer = new Customer(1, "user1", "123456");
		messenger.sendPackage(customer);
		
		
		messenger.receivePackage();
	}

}
