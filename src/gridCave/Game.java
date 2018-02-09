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

	private HashSet<String> directionsToMove;
	private HashSet<String> directionsToShoot;
	private boolean wumpusIsDead;
	private boolean easyModeOn;
	
	public Game() {
		isGameOver = false;
		wumpusIsDead = false;
		
		directionsToMove = new HashSet<String>();
		directionsToMove.add("NORTH");
		directionsToMove.add("SOUTH");
		directionsToMove.add("WEST");
		directionsToMove.add("EAST");
		directionsToMove.add("REST");
		
		directionsToShoot = new HashSet<String>();
		directionsToShoot.add("SHOOT NORTH");
		directionsToShoot.add("SHOOT SOUTH");
		directionsToShoot.add("SHOOT WEST");
		directionsToShoot.add("SHOOT EAST");
		
		Random rand = new Random();
		
		theCave = new Cave();
		theCharacter = new Character(2,2);
		arrowAction = new Action(this, theCave);
		do {
			theWumpus = new Wumpus(rand.nextInt(5),rand.nextInt(5));
		} while (theWumpus.getLocationX() == 2 && theWumpus.getLocationY() == 2);
		
	}
	
	public void turnOnEasyMode(){
		easyModeOn = true;
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
	
	public void hardSetWumpusLocation(int X, int Y) {
		theWumpus.setLocationX(X);
		theWumpus.setLocationY(Y);
	}
	
	public void moveWumpus() {
		theWumpus.move();
	}
	
	public void wumpusLocation() {
		//System.out.println("W " + this.getCavernContainingWumpus().getCavernNumber());
	}
	
	public String turn(String command) {

		String outputMessage = "";
		
		if (command.equals("END")) {
			this.gameOver();
			return "You ended the current game. ";
		}
		
		if(!directionsToMove.contains(command) && !directionsToShoot.contains(command)) {
			return "Invalid command given. Please try again.";
		}
		
		if(easyModeOn ) {
			outputMessage = outputMessage + "The Wumpus began this turn in Cavern " + this.getCavernContainingWumpus().getCavernNumber() + ". ";
			outputMessage = outputMessage + "You began this turn in Cavern " + this.getCavernContainingCharacter().getCavernNumber() + ". ";
		}
		
		if(directionsToMove.contains(command)) {
			if(theCave.boundaryExists(this.getCavernContainingCharacter().getCavernNumber(), command)) {
				return "Cannot move in this direction due to boundary - please try again.";
			}
			theCharacter.move(command);
			if (command.equals("REST")) {
				outputMessage+="You have successfully rested. ";
			}
			else {
				outputMessage+="You have successfully moved ";
				outputMessage+=command.toLowerCase();
				outputMessage+=". ";
			}
		}
		
		if(directionsToShoot.contains(command)) {
			//INSERT SHOOT LOGIC
			switch (command) {
				case "SHOOT NORTH":
					
					break;
				case "SHOOT SOUTH":
					break;
				case "SHOOT EAST":
					break;
				case "SHOOT WEST":
					break;
				default:
					break;
			}
			
			return "Like the NYC subway, the shooting feature is not functioning properly. ";
		}
		
		outputMessage = outputMessage + "You have " + String.valueOf(theCharacter.getNoOfArrows()) + " arrows left. ";
		

		theWumpus.move();
		
		if (theWumpus.getLocationX() == theCharacter.getX()) {
			if (theWumpus.getLocationY() == theCharacter.getY()) {
				this.gameOver();
				outputMessage+= "The Wumpus got you. Game over.";
				return outputMessage;
			}
		}

		if (this.getCavernContainingCharacter().hasBats()) {
			this.characterEntersCavernContainingBats();
			outputMessage+= "You have entered a cavern infested with bats and they have flown you to a random location in the cave. ";
		}
		
		if (this.getCavernContainingCharacter().hasPits()) {
			this.gameOver();
			outputMessage+= "You fell in a pit. Game over.";
			return outputMessage;
		}
		
		if (this.isPlayerNearWumpus()) {
			outputMessage+= "You smell coffee. ";
		}
		
		if (theCave.pitNearby(this.getCavernContainingCharacter().getCavernNumber())) {
			outputMessage+= "You feel wind. ";
		}

		if (theCave.batNearby(this.getCavernContainingCharacter().getCavernNumber())) {
			outputMessage+= "You hear chirping. ";
		}
/**	
		if (theCave.pitNearby(this.getCavernContainingCharacter().getCavernNumber())) {
			outputMessage+= "You smell coffee. ";
		}
**/		
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

	public String initialCheck() {
		
		String outputMessage = "";
		
		if (theCave.pitNearby(this.getCavernContainingCharacter().getCavernNumber())) {
			outputMessage+= "You feel wind. ";
		}
		
		if (theCave.batNearby(this.getCavernContainingCharacter().getCavernNumber())) {
			outputMessage+= "You hear chirping. ";
		}
		
		return outputMessage;
		
	}
	
	public boolean isPlayerNearWumpus() {
		
		int x1 = theCharacter.getX();
		int y1 = theCharacter.getY();
		int x2 = theWumpus.getLocationX();
		int y2 = theWumpus.getLocationY();
		
		if ((Math.abs(x1-x2) + Math.abs(y1-y2)) == 1) {
			return true;
		}
		
		return false;
		
	}

	public boolean isWumpusDead() {
		return wumpusIsDead;
	}
	
}
