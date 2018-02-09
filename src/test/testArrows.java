package test;

import gridCave.Game;

public class testArrows {
	
	public int arrowCountAtStartOfGame() {
		Game newGame = new Game();
		return newGame.theCharacter.getNoOfArrows();
	}
	
/**
	public String arrowCount0ReturnError() {
		Game newGame = new Game();
		newGame.theCharacter.setNoOfArrows(0);
		return newGame.theCharacter.shootArrow(25, "NORTH");
		}
**/
	
	public boolean whenArrowShotNorthArrowGoesNorth() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(25,"NORTH");
		if (newGame.theCave.getCave()[0][2].hasArrow()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean whenArrowShotSouthArrowGoesSouth() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(25,"SOUTH");
		if (newGame.theCave.getCave()[4][2].hasArrow()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean whenArrowShotEastArrowGoesEast() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(25,"EAST");
		if (newGame.theCave.getCave()[2][4].hasArrow()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean whenArrowShotWestArrowGoesWest() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(25,"WEST");
		if (newGame.theCave.getCave()[2][0].hasArrow()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean playerHitsWallWithArrowGameOver() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(1,"WEST");
		return newGame.isGameOver();
		
	}
	
	public int arrowIsInCavernAndCanBeRetrievedAfterBeingShot() {
		Game newGame = new Game();
		newGame.arrowAction.shootArrowDirection(25, "NORTH");
		return (newGame.theCave.getCave()[0][2].getArrowInCavernCount());
	}
	
	public boolean arrowKillsWampus() {
		Game newGame = new Game();
		newGame.hardSetWumpusLocation(0, 2);
		newGame.arrowAction.shootArrowDirection(25, "NORTH");
		return (newGame.isWumpusDead());
	}
	
	

}
