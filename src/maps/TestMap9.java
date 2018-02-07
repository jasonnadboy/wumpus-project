package maps;

import cave.CavernMap;
import cave.DIR;

public class TestMap9 {
	
	private CavernMap map;
	private String from;
	private String to;
	
	public TestMap9() {
		map = this.buildMap();
	}
	
	public CavernMap buildMap() {
		
		map = new CavernMap();
		
		map.makeNewCavern("1");
		map.makeNewCavern("2");
		map.makeNewCavern("3");
		map.makeNewCavern("4");
		map.makeNewCavern("5");
		map.makeNewCavern("6");
		map.makeNewCavern("7");
		map.makeNewCavern("8");
		map.makeNewCavern("9");
		
		map.makeConnection("1", "2", DIR.E);
		map.makeConnection("2", "3", DIR.E);
		map.makeConnection("3", "4", DIR.S);
		map.makeConnection("4", "5", DIR.S);
		map.makeConnection("5", "6", DIR.W);
		map.makeConnection("6", "7", DIR.W);
		map.makeConnection("7", "8", DIR.N);
		map.makeConnection("8", "1", DIR.N);	
		map.makeConnection("2", "9", DIR.S);
		map.makeConnection("9", "6", DIR.S);
		
		return map;
		
	}
	
	public DIR getConnection(String from, String to) {
		return map.getConnection(from, to);
	}

}
