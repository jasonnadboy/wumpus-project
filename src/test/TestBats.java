package test;

import gridCave.Game;

public class TestBats {
	
	private Game theGame = new Game();
	private int[] count = new int[25];
	
	public TestBats() {
		for (int i = 0; i < 10000; i++) {
			theGame.turn();
			int num = theGame.getCavernContainingCharacter().getCavernNumber();
			count[num-1]++;
			theGame.resetCharacterToStartingPoint();
		}
	}
	
	public boolean dropLocationIsEvenlyDistributed() {
		for (int i : count) {
			if (i < 325) {
				return false;
			}
		}
		return true;
	}
}
