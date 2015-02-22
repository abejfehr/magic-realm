package com.magicrealm.common.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.magicrealm.common.model.hextile.AwfulValley;
import com.magicrealm.common.model.hextile.BadValley;
import com.magicrealm.common.model.hextile.Borderland;
import com.magicrealm.common.model.hextile.Cavern;
import com.magicrealm.common.model.hextile.Caves;
import com.magicrealm.common.model.hextile.Cliff;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.packet.MapPacket;
import com.magicrealm.common.packet.Packet;
import com.magicrealm.common.packet.RegisterPlayer;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

public class NetworkController {

	/*
	 * Private members
	 */
	private static Server server;
	private static Client client;
	private static HashMap<Integer, ArrayList<Subscriber>> subscribers = null;
	
	
	
	/*
	 * Start methods
	 */
	public static void StartServer(int serverPort) throws IOException {
	    
		// Create the server
		server = new Server(65536*4, 65536*4);
		
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
	            		
	            		System.out.println("Sending a map to all connected clients");
	            	}
	            	if(object instanceof RegisterPlayer) {
	    				
	    				GameController.addPlayer(connection, ((RegisterPlayer) object).getPlayer());
	    				server.sendToAllTCP(object);
	            		System.out.println("new Player " + GameController.getPlayer(connection).toString()+", has been registered");
	    			}
	            }
	         }

	    });
	    
	    // Register the classes for serialization
	    registerClasses(server.getKryo());
	}
	
	public static void StartClient(String serverIP, int serverPort) throws IOException {
	    
		// Create the client
		client = new Client(65536*4, 65536*4);
		
		// Connect to the server
	    client.start();
	    client.connect(5000, serverIP, serverPort);
	    
	    // Add the listener
	    client.addListener(new Listener() {
	    	
	    	public void received(Connection connection, Object object) {

	    		if(object instanceof Packet) {
	    			
	    			if(object instanceof MapPacket) {
	    				
	    				GameController.setMap(((MapPacket)object).getMap());
	    				
	    				fireEvent(Events.MAP_UPDATED);
	    				
	            		System.out.println("Received an updated map");
	    			}  
	    			if(object instanceof RegisterPlayer) {
	    				
	    				GameController.addPlayer(connection, ((RegisterPlayer) object).getPlayer());
	    				
	    				System.out.println("This many events are subscribed to" + subscribers.size());
	    				fireEvent(Events.PLAYER_REGISTERED);
	    				
	    				System.out.println("Received Registered Player");	    				
	    			}
	    		} 			
	    	}
	    	
	    });

	    // Register the classes for serialization
	    registerClasses(client.getKryo());
	    
	}

	
	
	protected static void fireEvent(int event) {
		
		// Goes through the list of subscribers for that event, and updates them
		for( Subscriber n : subscribers.get(event) ) {
			n.eventFired(event);
		}
		
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

		JavaSerializer javaSerializer = new JavaSerializer();
		
		// Packets
	    kryo.register(com.magicrealm.common.packet.MapPacket.class);
	    kryo.register(com.magicrealm.common.packet.MapTilesPacket.class);
	    kryo.register(com.magicrealm.common.packet.Packet.class);
	    kryo.register(com.magicrealm.common.packet.RequestMapPacket.class);
	    kryo.register(com.magicrealm.common.packet.RegisterPlayer.class);
	    
	    // Primitives and Utils
	    kryo.register(byte[].class);
	    kryo.register(byte[][].class);
	    kryo.register(float[].class);
	    kryo.register(int[].class);
	    kryo.register(short[].class);
	    kryo.register(java.util.ArrayList.class);
	    kryo.register(java.util.Hashtable.class);
	    
	    // Model
	    kryo.register(com.magicrealm.common.model.hextile.HexTile.class);
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[].class);
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[][].class);
	    kryo.register(com.magicrealm.common.model.path.Clearing.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.path.Edge.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.map.Map.class);
	    kryo.register(com.magicrealm.common.Dwellings.class);
	    kryo.register(com.magicrealm.common.Vulnerability.class);

	    // Tiles(part of the model)
	    kryo.register(com.magicrealm.common.model.hextile.AwfulValley.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.BadValley.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Borderland.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Cavern.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Caves.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Cliff.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Crag.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.CurstValley.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.DarkValley.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.DeepWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.EvilValley.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.HighPass.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Ledges.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.LindenWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.MapleWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Mountain.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.NutWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.OakWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.PineWoods.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.hextile.Ruins.class, javaSerializer);
	    
	    //Characters(part of the model)
	    kryo.register(com.magicrealm.common.character.Amazon.class);
	    kryo.register(com.magicrealm.common.character.BlackKnight.class);
	    kryo.register(com.magicrealm.common.character.Captain.class);
	    kryo.register(com.magicrealm.common.character.Dwarf.class);
	    kryo.register(com.magicrealm.common.character.Elf.class);
	    kryo.register(com.magicrealm.common.character.Swordsman.class);
	    
	    //Weapons(part of the model)
	    kryo.register(com.magicrealm.common.weapon.Axe.class);
	    kryo.register(com.magicrealm.common.weapon.BroadSword.class);
	    kryo.register(com.magicrealm.common.weapon.Crossbow.class);
	    kryo.register(com.magicrealm.common.weapon.DevilSword.class);
	    kryo.register(com.magicrealm.common.weapon.GreatAxe.class);
	    kryo.register(com.magicrealm.common.weapon.GreatSword.class);
	    kryo.register(com.magicrealm.common.weapon.LightBow.class);
	    kryo.register(com.magicrealm.common.weapon.Mace.class);
	    kryo.register(com.magicrealm.common.weapon.MediumBow.class);
	    kryo.register(com.magicrealm.common.weapon.MorningStar.class);
	    kryo.register(com.magicrealm.common.weapon.ShortSword.class);
	    kryo.register(com.magicrealm.common.weapon.Spear.class);
	    kryo.register(com.magicrealm.common.weapon.Staff.class);
	    kryo.register(com.magicrealm.common.weapon.ThrustingSword.class);
	    
	}
	
	
	
	/*
	 * Registers a subscriber to a particular event
	 */
	public static void subscribe(int event, Subscriber subscriber) {
		
		// Initialize the list if it hasn't already been done
		if(subscribers == null) {
			subscribers = new HashMap<Integer, ArrayList<Subscriber>>();
		}
		
		// Check if that event has not yet been registered
		if(!subscribers.containsKey(event)) {
			
			ArrayList<Subscriber> list = new ArrayList<Subscriber>();
			
			subscribers.put(event, list);
		}
		
		// Add the subscriber to the list
		ArrayList<Subscriber> list = subscribers.get(event);
		list.add(subscriber);
		subscribers.put(event, list);
		
	}
	public static void sendToServer(Packet packet) {			
		client.sendTCP(packet);
    }
}
