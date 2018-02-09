package test;

import gridCave.Game;

public class TestSmellWumpus {
	
	Game game = new Game();
	
	public void placeWumpusNearPlayer() {
		game.hardSetWumpusLocation(1, 2);
	}
	
	public void placeWumpusFarFromPlayer() {
		game.hardSetWumpusLocation(4, 2);
	}
	
	public boolean isWumpusAdjacent() {
		return game.isPlayerNearWumpus();
	}
	
	public String generateWumpusMessage() {
		if (isWumpusAdjacent()) {
			return "I SMELL WUMPUS";
		}
		else {
			return "";
		}
	}

}
