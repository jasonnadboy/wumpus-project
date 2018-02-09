package test;

import gridCave.Game;

public class TestWumpusDead {
	
	Game game = new Game();
	public boolean isWumpusDead = false;
	
	public void playerKillsTheWumpus() {
		isWumpusDead = true;
	}
	
	public void wumpusIsStillAlive() {
		isWumpusDead = false;
	}
	
	public boolean isWumpusDead() {
		return isWumpusDead;
	}
	
	public String generateWumpusMessage() {
		if (isWumpusDead()) {
			return "You have KILLED the Wumpus. Well done!";
		}
		else {
			return "";
		}
	}

}
