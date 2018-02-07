package gridCave;

import java.util.Random;

import arrows.Action;

public class Game {
	
	public Character theCharacter;
	public Cave theCave;
	public Action arrowAction;
	
	public Game() {
		theCave = new Cave();
		theCharacter = new Character(2,2);
		arrowAction = new Action(theCharacter);
	
	}
	
	public Cavern getCavernContainingCharacter() {
		int x = theCharacter.getX();
		int y = theCharacter.getY();
		Cavern[][] caverns = theCave.getCave();
		Cavern theCavern = caverns[x][y];
		return theCavern;
	}
	
	public void characterEntersCavernContainingBats() {
		Random rand = new Random();
		theCharacter.hardSetLocation(rand.nextInt(5), rand.nextInt(5));
	}
	
	public void turn() {
		theCharacter.move("NORTH");
		if (this.getCavernContainingCharacter().hasBats()) {
			this.characterEntersCavernContainingBats();
		}
	}
	
}
