package test;

import gridCave.Game;

public class TestWumpusRandomStartingLocation {
	

	private int[] count = new int[25];
	
	public TestWumpusRandomStartingLocation() {
		for (int i = 0; i < 10000; i++) {
			Game theGame = new Game();
			int cavernNumber = theGame.getCavernContainingWumpus().getCavernNumber();
			count[cavernNumber-1]++;
		}
	}
	
	public int isStartingPoint(int i) {
		return count[i-1];
	}
	
	public boolean wumpusStartingPointIsRandomlyDistributed() {
		if (count[24] != 0) {
			return false;
		}
		count[24] = 325;
		for (int i : count) {
			if (i < 325) {
				return false;
			}
		}
		return true;
	}

}
