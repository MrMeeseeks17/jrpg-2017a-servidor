package chatServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServidorChat extends Thread {

	private ServerSocket server;

	
	public ServidorChat(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	public void stopRequest(){
		try {
			server.close();
		} catch (IOException e) {
			
		}
		String[] usrV = (String[]) ChatHandler.clients.keySet().toArray(
				new String[ChatHandler.clients.keySet().size()]);
		for(int i=0;i<usrV.length;i++){
			ChatHandler.kick(usrV[i]);
		}
	}
	
	@Override
	public void run() {
		Socket client;
		ChatHandler.clients = new HashMap<>();
		try {
			while( (client=this.server.accept()) != null){
				ChatHandler c = new ChatHandler(client);
				c.start();
			}
		} catch (IOException e) {
			
		}
	
	}

}
