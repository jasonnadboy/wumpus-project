package test;

import gridCave.Game;

public class TestWumpusRandomMovement {
	
	private Game theGame = new Game();
	private int[] count = new int[25];
	
	public TestWumpusRandomMovement() {
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 1000; j++) {
				theGame.moveWumpus();
			}
			int cavernNumber = theGame.getCavernContainingWumpus().getCavernNumber();
			count[cavernNumber-1]++;
		}
		
	}
	
	public int isEndingPoint(int i) {
		return count[i-1];
	}
	
	public boolean eventDistributionOfWumpusLocationAfter1000Moves() {
		for (int c : count) {
			//System.out.println(c);
			if (c < 250) {
				return false;
			}
		}
		return true;
	}

}
