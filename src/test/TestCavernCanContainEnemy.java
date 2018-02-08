package test;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Wumpus;

public class TestCavernCanContainEnemy {
	
	Cave testCave = new Cave();
	Cavern[][] testCaverns = testCave.getCave();
	Cavern testCavern = testCaverns[1][1];
	
	public boolean cavernCanContainBats() {
		testCavern.putBats();
		return testCavern.hasBats();
	}
	
	public boolean cavernCanContainPits() {
		testCavern.putPit();
		return testCavern.hasPits();
	}
	
	public boolean cavernCanContainWumpus() {
		Wumpus wumpus = new Wumpus(1,1);
		int wumpusCavern = testCaverns[wumpus.getLocationX()][wumpus.getLocationY()].getCavernNumber();
		return (testCavern.getCavernNumber() == wumpusCavern);
	
	}
	
	public boolean cavernCanContainBatsAndWumpus() {
		testCavern.putBats();
		Wumpus wumpus = new Wumpus(1,1);
		int wumpusCavern = testCaverns[wumpus.getLocationX()][wumpus.getLocationY()].getCavernNumber();
		return ((testCavern.getCavernNumber() == wumpusCavern) && testCavern.hasBats());
	}
	
	public boolean cavernCanContainPitsAndWumpus() {
		testCavern.putPit();
		Wumpus wumpus = new Wumpus(1,1);
		int wumpusCavern = testCaverns[wumpus.getLocationX()][wumpus.getLocationY()].getCavernNumber();
		return ((testCavern.getCavernNumber() == wumpusCavern) && testCavern.hasPits());
	}
}
