package com.magicrealm.common.packet;

import com.magicrealm.common.model.Map;

public class MapPacket extends Packet {

	private Map map;
	
	public MapPacket(Map map) { this.map = map; }
	
	public Map getMap() { return map; }

}
