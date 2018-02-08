package test;

import gridCave.Game;

public class TestWumpusRandomStartingLocation {
	

	private int[] count = new int[25];
	
	public TestWumpusRandomStartingLocation() {
		for (int i = 0; i < 10000; i++) {
			Game theGame = new Game();
			int cavernNumber = theGame.getCavernContainingWumpus().getCavernNumber();
			count[cavernNumber]++;
		}
	}
	
	public boolean 

}
