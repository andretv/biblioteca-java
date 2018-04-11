package shared;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.net.UnknownHostException;

public class MessengerUDP implements IMessenger {
	private int destPort;
	private DatagramSocket socket;
	
	public MessengerUDP() {
		try {
			this.socket = new DatagramSocket();
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public MessengerUDP(int port) {
		try {
			this.socket = new DatagramSocket(port);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void setDestPort(int port) {
		this.destPort = port;
	}
	
	public void sendPackage(Object data) {
		try {
			InetAddress receiverAddress = InetAddress.getLocalHost();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(data);
			byte[] dataByte = baos.toByteArray();

			DatagramPacket pack = new DatagramPacket(
					dataByte, 
					dataByte.length, 
					receiverAddress, 
					this.destPort
				);
			
			this.socket.send(pack);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object receivePackage() {
		try {
			DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
			this.socket.receive(pack);
			byte[] dataByte = pack.getData();
			ByteArrayInputStream bais = new ByteArrayInputStream(dataByte);
			ObjectInputStream ois = new ObjectInputStream(bais);
			this.destPort = pack.getPort();
			return ois.readObject();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
