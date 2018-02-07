package maps;

import cave.CavernMap;
import cave.DIR;

public class TestMap {
	
	private CavernMap map;
	private String from;
	private String to;
	
	public TestMap() {
		map = this.buildMap();
	}
	
	public CavernMap buildMap() {
		
		CavernMap map = new CavernMap();
		
		map.makeNewCavern("1");
		map.makeNewCavern("2");
		map.makeNewCavern("3");
		map.makeNewCavern("4");
		map.makeNewCavern("5");
		map.makeNewCavern("6");
		map.makeNewCavern("7");
		map.makeNewCavern("8");
		map.makeNewCavern("9");
		
		map.makeConnection("1", "2", DIR.EAST);
		map.makeConnection("2", "1", DIR.WEST);
		map.makeConnection("2", "3", DIR.EAST);
		map.makeConnection("3", "4", DIR.SOUTH);
		map.makeConnection("4", "5", DIR.SOUTH);
		map.makeConnection("5", "6", DIR.WEST);
		map.makeConnection("6", "7", DIR.WEST);
		map.makeConnection("7", "8", DIR.NORTH);
		map.makeConnection("8", "1", DIR.NORTH);	
		map.makeConnection("2", "9", DIR.SOUTH);
		map.makeConnection("9", "6", DIR.SOUTH);
		
		return map;
		
	}
	
	public void setX(String x) {
		from = x;
	}
	
	public void setY(String y) {
		to = y;
	}

}
