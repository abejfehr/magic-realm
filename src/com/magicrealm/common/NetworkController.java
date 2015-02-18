package com.magicrealm.common;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

public class NetworkController {

	private static Server server;
	private static Client client;
	
	public static void StartServer(int serverPort) throws IOException {
	    
		server = new Server();
	    server.start();
	    server.bind(serverPort);
	    
	}
	
	public static void StartClient(String serverIP, int serverPort) throws IOException {
	    
		client = new Client();
	    client.start();
	    client.connect(5000, serverIP, serverPort);

	}
	
}
