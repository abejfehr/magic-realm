package com.magicrealm.common.packet;

public class ConnectionInfo extends Packet {

	int connectionID;
	
	public void setConnection(int connectionID) {
		this.connectionID = connectionID;
	}
	
	public int getConnection() { return connectionID; }

}
