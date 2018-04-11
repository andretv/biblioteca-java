package shared;

public interface IMessenger {
	void setDestPort(int port);
	void sendPackage(Object data);
	Object receivePackage();
}
