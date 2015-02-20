package com.magicrealm.common.packet;

import com.magicrealm.common.model.map.Map;

public class MapPacket extends Packet {

	private Map map;
	
	public MapPacket() { map = null; } // For serialization
	
	public MapPacket(Map map) { this.map = map; }
	
	public Map getMap() { return map; }

}
