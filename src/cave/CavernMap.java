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
			case N:
				from.setNorthConnection(to);
				to.setSouthConnection(from);
			case S:
				from.setSouthConnection(to);
				to.setNorthConnection(from);
			case E:
				from.setEastConnection(to);
				to.setWestConnection(from);
			default:
				from.setWestConnection(to);
				to.setEastConnection(from);
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
