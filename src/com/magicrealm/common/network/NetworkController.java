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
import com.magicrealm.common.Player;
import com.magicrealm.common.packet.ConnectionInfo;
import com.magicrealm.common.packet.GameStartPacket;
import com.magicrealm.common.packet.MapPacket;
import com.magicrealm.common.packet.Message;
import com.magicrealm.common.packet.Packet;
import com.magicrealm.common.packet.PlayerList;
import com.magicrealm.common.packet.RegisterCharacter;
import com.magicrealm.common.packet.RegisterPlayer;
import com.magicrealm.common.packet.RequestConnection;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

public class NetworkController {

	/*
	 * Private members
	 */
	private static Server server;
	private static Client client;
	private static HashMap<Integer, ArrayList<Subscriber>> subscribers = null;
	private static boolean isHost;
	
	
	
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
	            	 * RequestConnection
	            	 */
	            	if(object instanceof RequestConnection) {
	            		
	            		System.out.println("I've received a user's request for connection info");
	            		
	            		// Send the user a packet back with the connection
	            		ConnectionInfo cInfo = new ConnectionInfo();
	            		cInfo.setConnection(connection.getID());
	            		server.sendToTCP(connection.getID(), cInfo);
	            		
	            		// Send the user a packet back with the players that have already joined
	            		PlayerList players = new PlayerList();
	            		players.setPlayers(GameController.getPlayerHashMap());
	            		server.sendToTCP(connection.getID(), players);
	            	}
	            	
	            	/*
	            	 * RequestMapPacket
	            	 */
	            	if(object instanceof RequestMapPacket) {
	            		// We've received a request for  a new map.
	            		System.out.println("Entered RequestMapPacket server handler");
	            		MapPacket mp = new MapPacket(GameController.getMap());
	            		
	            		server.sendToAllTCP(mp);
	            		
	            		System.out.println("Sending a map to all connected clients");
	            	}
	            	if(object instanceof MapPacket) {
	            		System.out.println("server received new map");
	            		
	            		server.sendToAllTCP(object);
	            		System.out.println("Sending a map to all connected clients");
	            	}
	            	if(object instanceof RegisterPlayer) {
	    				
	    				GameController.addPlayer(connection.getID(), ((RegisterPlayer) object).getPlayer());
	    				
	    				((RegisterPlayer)object).setConnectionID(connection.getID());
	    				server.sendToAllTCP(object);
	    				
	            		System.out.println("new Player " + GameController.getPlayer(connection.getID()).toString()+", has been registered");
	    			}
	            	
	            	/*
	            	 * RegisterCharacter
	            	 */
	            	if(object instanceof RegisterCharacter) {
	            		
	            		// Just send it back to everyone
	            		server.sendToAllTCP(object);
	            		
	            	}
	            	
	            	/*
	            	 * Message
	            	 */
	            	if(object instanceof Message) {
	            		
	            		Message message = (Message)object;
	            		
	            		// Add the message to the game text(unless I'm the client as well)
	            		// In that case, the text was already updated in our lobby
	            		//if(!message.getPlayer().getName().equals(GameController.myself().getName())) {
	            		//}
	            		
	            		// Send the message to everyone
	            		server.sendToAllTCP(object);
	            		
	            	}
	            	/*
	            	 * game start
	            	 */
	            	if(object instanceof GameStartPacket){
	            		server.sendToAllTCP(object);
	            	}
	            	if(object instanceof PlayerList){
	            		server.sendToAllTCP(object);
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
	    			
	    			if(object instanceof ConnectionInfo) {

	    				System.out.println("I've received my connection info!");
	    				
	    				GameController.setOwnConnectionID(((ConnectionInfo) object).getConnection());
	    				
	    				Player yourself = new Player();
	    				RegisterPlayer registerPlayer = new RegisterPlayer();
	    				registerPlayer.setPlayer(yourself);
	    				NetworkController.sendToServer(registerPlayer);
	    				
	    			}
	    			
	    			if(object instanceof MapPacket) {
	    				
	    				GameController.setMap(((MapPacket)object).getMap());
	   
	    				fireEvent(Events.MAP_UPDATED);
	    				
	            		System.out.println("Received an updated map");
	    			}  
	    			if(object instanceof RegisterPlayer) {
	    				
	    				GameController.addPlayer(((RegisterPlayer) object).getConnectionID(), ((RegisterPlayer) object).getPlayer());
	    				System.out.println("The Players Connection ID: " + ((RegisterPlayer) object).getConnectionID());
	    				
	    				fireEvent(Events.PLAYER_REGISTERED);

	    				System.out.println("Client received Registered Player");
	    			}

	    			if(object instanceof PlayerList) {
	    				
	    				GameController.setNewPlayerList(((PlayerList) object).getPlayers());
	    				
	    			}
	    			
	    			/*
	    			 * RegisterPlayer
	    			 */
	    			if(object instanceof RegisterCharacter) {
	    				
	    				RegisterCharacter rc = (RegisterCharacter)object;
	    				GameController.setCharacter(rc.getConnectionID(), rc.getCharacter());
	    				System.out.println("Client received Registered Character" + rc.getCharacter().toString());

	    			}
	    			
	    			/*
	    			 * Message
	    			 */
	    			if(object instanceof Message) {
	    				
	            		Message message = (Message)object;
	            		
	            		// Add the message to the game text
	            		GameController.updateChatHistory(message.getPlayer(), message.getMessage());
	            			            		
	            		fireEvent(Events.MESSAGE_RECEIVED);
	    				
	    			}
	    			/*
	    			 * Game started
	    			 */
	    			if(object instanceof GameStartPacket) {
	    				fireEvent(Events.GAME_STARTED);    				
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
			if(n != null) {
				n.eventFired(event);
			}
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
		
		// Weird things
		
		// Packets
	    kryo.register(com.magicrealm.common.packet.MapPacket.class);
	    kryo.register(com.magicrealm.common.packet.MapTilesPacket.class);
	    kryo.register(com.magicrealm.common.packet.Packet.class);
	    kryo.register(com.magicrealm.common.packet.RequestConnection.class);
	    kryo.register(com.magicrealm.common.packet.ConnectionInfo.class);
	    kryo.register(com.esotericsoftware.kryonet.Connection.class);
	    kryo.register(com.magicrealm.common.packet.RequestMapPacket.class);
	    kryo.register(com.magicrealm.common.packet.RegisterPlayer.class);
	    kryo.register(com.magicrealm.common.packet.RegisterCharacter.class);
	    kryo.register(com.magicrealm.common.packet.PlayerList.class);
	    kryo.register(com.magicrealm.common.packet.Message.class);
	    kryo.register(com.magicrealm.common.packet.GameStartPacket.class);
	    
	    // Primitives and Utils
	    kryo.register(byte[].class);
	    kryo.register(byte[][].class);
	    kryo.register(float[].class);
	    kryo.register(int[].class);
	    kryo.register(short[].class);
	    kryo.register(String[].class);
	    kryo.register(java.util.ArrayList.class);
	    kryo.register(java.util.Hashtable.class);
	    kryo.register(java.util.HashMap.class);
	    
	    // Model
	    kryo.register(com.magicrealm.common.model.hextile.HexTile.class);
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[].class);
	    kryo.register(com.magicrealm.common.model.hextile.HexTile[][].class);
	    kryo.register(com.magicrealm.common.model.path.Clearing.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.path.Edge.class, javaSerializer);
	    kryo.register(com.magicrealm.common.model.map.Map.class);
	    kryo.register(com.magicrealm.common.Dwellings.class);
	    kryo.register(com.magicrealm.common.Vulnerability.class);
	    kryo.register(com.magicrealm.common.VictoryCondition.class);
	    kryo.register(com.magicrealm.common.Player.class);


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
	
	
	/*
	 * getters and setters
	 */
	
	public static boolean isHost(){ return isHost; }
	public static void    setHostStatus(boolean host) {isHost = host;}
}
