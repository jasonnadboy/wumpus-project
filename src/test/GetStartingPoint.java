package test;

import gridCave.Game;

public class GetStartingPoint {
	
	private Game game = new Game();
	
	//public String get
	
	public int startingCavernAlways() {
		return game.getCavernContainingCharacter().getCavernNumber();
	}
	
	public Boolean startingCavernContainsBats() {
		return game.getCavernContainingCharacter().hasBats();
	}
	
	public Boolean startingCavernContainsPits() {
		return game.getCavernContainingCharacter().hasPits();
	}
	
}
