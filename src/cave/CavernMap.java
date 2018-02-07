package cave;

import java.util.HashMap;
import java.util.Map;

public class CavernMap {
	
	Map<String, Cavern1> caverns;
	
	public CavernMap() {
		caverns = new HashMap<String, Cavern1>();
	}
	
	public Cavern1 makeNewCavern(String name) {
		Cavern1 newCavern = new Cavern1(name);
		caverns.put(name, newCavern);
		return newCavern;
	}
	
	public Cavern1 getCavern(String name) {
		return caverns.get(name);
	}
	
	public void makeConnection(String fromString, String toString, DIR dir) {
		
		Cavern1 from = this.getCavern(fromString);
		Cavern1 to = this.getCavern(toString);
		
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
			case W:
				from.setWestConnection(to);
				to.setEastConnection(from);
			default: 
		}	
	
	}
	
	public DIR getConnection(String fromString, String toString) {
		System.out.println("From: " + fromString + "      To: " + toString);
		for (DIR d : DIR.values()) {
			if (caverns.get(fromString).getConnection(d) != null) {
				System.out.println("Direction: " + d);
				System.out.println(caverns.get(fromString).getConnection(d).getName());
				System.out.println(caverns.get(toString).getName());
			}
		}
		return null;
	}

}
