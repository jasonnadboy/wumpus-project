package gridCave;

import java.util.HashSet;
import java.util.Random;

import arrows.Action;


public class Game {
	
	public Character theCharacter;
	public Cave theCave;
	public Wumpus theWumpus;
	private boolean isGameOver;
	public Action arrowAction;

	private HashSet<String> directions;
	
	public Game() {
		isGameOver = false;
		
		directions = new HashSet<String>();
		directions.add("NORTH");
		directions.add("SOUTH");
		directions.add("WEST");
		directions.add("EAST");
		directions.add("REST");
		
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
	
	public void moveWumpus() {
		theWumpus.move();
	}
	
	public String turn(String direction) {
		
		if(theCave.boundaryExists(this.getCavernContainingCharacter().getCavernNumber(), direction)) {
			return "Cannot move in this direction due to boundary - please try again.";
		}
		
		if(!directions.contains(direction)) {
			return "Invalid direction given. Please try again.";
		}
		
		String outputMessage = "";
		
		theCharacter.move(direction);
		
		if (direction.equals("REST")) {
			outputMessage+="You have successfully rested. ";
		}
		else {
			outputMessage+="You have successfully moved ";
			outputMessage+=direction.toLowerCase();
			outputMessage+=". ";
		}

		theWumpus.move();
		
		
		if (theWumpus.getLocationX() == theCharacter.getX()) {
			if (theWumpus.getLocationY() == theCharacter.getY()) {
				this.gameOver();
				outputMessage+= "The Wumpus got you. Game over.";
			}
		}

		if (this.getCavernContainingCharacter().hasBats()) {
			this.characterEntersCavernContainingBats();
			outputMessage+= "You have entered a cavern infested with bats and they have flown you to a random location in the cave. ";
		}
		
		if (this.getCavernContainingCharacter().hasPits()) {
			this.gameOver();
			outputMessage+= "You fell in a pit. Game over.";
		}
		
		
		
		return outputMessage;
	}
	
	public void gameOver() {
		isGameOver = true;
	}
	
	public void resetCharacterToStartingPoint() {
		theCharacter.hardSetLocation(2, 2);
	}

	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return isGameOver;
	}
	
}
