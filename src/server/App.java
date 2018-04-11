package server;

import shared.IMessenger;
import shared.MessengerUDP;

public class App {
	public static void main(String[] args) {
		IMessenger msg = new MessengerUDP();
	}

}
