package gridCave;

import java.util.Random;


public class Game {
	
	public Character theCharacter;
	public Cave theCave;
	public Wumpus theWumpus;
	
	public Game() {
		Random rand = new Random();
		
		theCave = new Cave();
		theCharacter = new Character(2,2);
		
		do {
			theWumpus = new Wumpus(rand.nextInt(5),rand.nextInt(5));
		} while (theWumpus.getLocationX() == 2 && theWumpus.getLocationY() == 2);
		
	}
	
	public Cavern getCavernContainingCharacter() {
		int x = theCharacter.getX();
		int y = theCharacter.getY();
		Cavern[][] caverns = theCave.getCave();
		Cavern theCavern = caverns[x][y];
		return theCavern;
	}
	
	public Cavern getCavernContainingWumpus() {
		int x = theWumpus.getLocationX();
		int y = theWumpus.getLocationY();
		Cavern[][] caverns = theCave.getCave();
		Cavern theCavern = caverns[x][y];
		return theCavern;
	}
	
	public void characterEntersCavernContainingBats() {
		Random rand = new Random();
		theCharacter.hardSetLocation(rand.nextInt(5), rand.nextInt(5));
	}
	
	public void turn(String direction) {
		theCharacter.move(direction);
		theWumpus.move();
		if (theWumpus.getLocationX() == theCharacter.getX()) {
			if (theWumpus.getLocationY() == theCharacter.getY()) {
				this.gameOver();
			}
		}
		if (this.getCavernContainingCharacter().hasBats()) {
			this.characterEntersCavernContainingBats();
		}
		
	}
	
	public void gameOver() {
		
	}
	
	public void resetCharacterToStartingPoint(){
		theCharacter.hardSetLocation(2, 2);
	}
	
}
