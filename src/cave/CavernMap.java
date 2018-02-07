package cave;

import java.util.HashMap;
import java.util.Map;

public class CavernMap {
	
	Map<String, Cavern> caverns;
	
	public CavernMap() {
		caverns = new HashMap<String, Cavern>();
	}
	
	public Cavern makeNewCavern(String name) {
		Cavern newCavern = new Cavern();
		caverns.put(name, newCavern);
		return newCavern;
	}
	
	public Cavern getCavern(String name) {
		return caverns.get(name);
	}
	
	public void makeConnection(String fromString, String toString, DIR dir) {
		
		Cavern from = this.getCavern(fromString);
		Cavern to = this.getCavern(toString);
		
		switch(dir) {
			case NORTH:
				from.setNorthConnection(to);
			case SOUTH:
				from.setSouthConnection(to);
			case EAST:
				from.setEastConnection(to);
			default:
				from.setWestConnection(to);
		}	
	
	}
	
	public DIR getConnection(String fromString, String toString) {
		for (DIR d : DIR.values()) {
			if (caverns.get(fromString).getConnection(d).equals(caverns.get(toString))) {
				return d;
			}
		}
		return null;
	}

}
