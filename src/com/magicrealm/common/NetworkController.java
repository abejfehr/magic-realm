package com.magicrealm.common;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.magicrealm.common.packet.MapPacket;
import com.magicrealm.common.packet.Packet;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

public class NetworkController {

	/*
	 * Private members
	 */
	private static Server server;	
	private static Client client;
	
	
	
	/*
	 * Start methods
	 */
	public static void StartServer(int serverPort) throws IOException {
	    
		// Create the server
		server = new Server();
		
		// Start the server
	    server.start();
	    server.bind(serverPort);
	    
	    // Add the listener
	    server.addListener(new Listener() {
	    	
	        public void received (Connection connection, Object object) {
	            if (object instanceof Packet) {
	            	
	            	/*
	            	 * RequestMapPacket
	            	 */
	            	if(object instanceof RequestMapPacket) {
	            		// We've received a request for  a new map.
	            		MapPacket mp = new MapPacket(GameController.getMap());
	            		
	            		server.sendToAllTCP(mp);
	            		
	            		//server.sendToAllTCP(new LindenWoods(0));
	            		
	            		System.out.println("Sending a map to all connected clients");
	            	}
	            	
	            }
	         }

	    });
	    
	    // Register the classes for serialization
	    registerClasses(server.getKryo());
	}
	
	public static void StartClient(String serverIP, int serverPort) throws IOException {
	    
		// Create the client
		client = new Client();
		
		// Connect to the server
	    client.start();
	    client.connect(5000, serverIP, serverPort);
	    
	    // Add the listener
	    client.addListener(new Listener() {
	    	
	    	public void received(Connection connection, Object object) {

	    		if(object instanceof Packet) {
	    			
	    			if(object instanceof MapPacket) {
	            		System.out.println("Received an updated map");
	    			}
	    			
	    		}
	    			
	    	}
	    	
	    });

	    // Register the classes for serialization
	    registerClasses(client.getKryo());

	}

	
	
	/*
	 * Sends an object to the server
	 */
	public static void sendToServer(Class<?> pClass) {

		Object packetToSend = null;
		try {
			packetToSend = pClass.newInstance();
			client.sendTCP(packetToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	/*
	 * Sends an object to all connected clients
	 */
	public static void sendToAllClients(Class<?> pClass) {

		Object packetToSend = null;
		try {
			packetToSend = pClass.newInstance();
			server.sendToAllTCP(packetToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	/*
	 * For serialization we need to register the classes
	 */
	public static void registerClasses(Kryo kryo) {

		// Packets
	    kryo.register(com.magicrealm.common.packet.MapPacket.class);
	    kryo.register(com.magicrealm.common.packet.MapTilesPacket.class);
	    kryo.register(com.magicrealm.common.packet.Packet.class);
	    kryo.register(com.magicrealm.common.packet.RequestMapPacket.class);
	    
	    // Primitives and Utils
	    kryo.register(byte[].class);
	    kryo.register(byte[][].class);
	    kryo.register(float[].class);
	    kryo.register(int[].class);
	    kryo.register(short[].class);
	    kryo.register(java.util.ArrayList.class);
	    kryo.register(java.util.Hashtable.class);
	    
	    // Model
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[].class);
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[][].class);
	    kryo.register(com.magicrealm.common.model.path.Clearing.class);
	    kryo.register(com.magicrealm.common.model.Map.class);
	    kryo.register(com.magicrealm.common.Dwellings.class);

	    // Tiles(part of the model)
	    kryo.register(com.magicrealm.common.model.hextile.AwfulValley.class);
	    kryo.register(com.magicrealm.common.model.hextile.BadValley.class);
	    kryo.register(com.magicrealm.common.model.hextile.Borderland.class);
	    kryo.register(com.magicrealm.common.model.hextile.Cavern.class);
	    kryo.register(com.magicrealm.common.model.hextile.Caves.class);
	    kryo.register(com.magicrealm.common.model.hextile.Cliff.class);
	    kryo.register(com.magicrealm.common.model.hextile.Crag.class);
	    kryo.register(com.magicrealm.common.model.hextile.CurstValley.class);
	    kryo.register(com.magicrealm.common.model.hextile.DarkValley.class);
	    kryo.register(com.magicrealm.common.model.hextile.DeepWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.EvilValley.class);
	    kryo.register(com.magicrealm.common.model.hextile.HighPass.class);
	    kryo.register(com.magicrealm.common.model.hextile.Ledges.class);
	    kryo.register(com.magicrealm.common.model.hextile.LindenWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.MapleWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.Mountain.class);
	    kryo.register(com.magicrealm.common.model.hextile.NutWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.OakWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.PineWoods.class);
	    kryo.register(com.magicrealm.common.model.hextile.Ruins.class);
	    
	}
}
