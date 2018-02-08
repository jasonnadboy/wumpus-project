package test;

import java.util.ArrayList;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Game;

public class BatsAndPitsAndWumpusCavernIsRandom {
	private Game theGame = new Game();
	private int[] count = new int[25];
	
	public void TestWumpusRandomMovement() {
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 1000; j++) {
				theGame.moveWumpus();
			}
			int cavernNumber = theGame.getCavernContainingWumpus().getCavernNumber();
			count[cavernNumber-1]++;
		}
		
	}
	
	public void TestPitsRandomPlacement() {
		for (int i = 0; i < 10000; i++) {
			Game newGame = new Game();
			//Cavern pitCavern = newGame.
			//int cavernNumber = pitCavern.getCavernNumber();
			//count[cavernNumber-1]++;
		}
		
	}
	
	public void TestBatsRandomPlacement() {
		for (int i = 0; i < 10000; i++) {
			Cave newCave = new Cave();
			ArrayList<Cavern> batCaverns = newCave.getCavernsWithBats();
			for(Cavern c : batCaverns) {
				int cavernNumber = c.getCavernNumber();
				count[cavernNumber-1]++;
			}
		}
		
	}
	
	public boolean evenDistributionAfter10000Games() {
		for (int c : count) {
			if (c < 200) {
				return false;
			}
		}
		return true;
	}
}
