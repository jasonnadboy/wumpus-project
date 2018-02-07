package gridCave;

import java.util.Random;

public class Game {
	
	private Character theCharacter;
	private Cave theCave;
	
	public Game() {
		theCave = new Cave();
		theCharacter = new Character(2,2);
	
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
