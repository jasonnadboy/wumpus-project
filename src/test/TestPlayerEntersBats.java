package test;

import java.util.ArrayList;

import gridCave.Cavern;
import gridCave.Game;

public class TestPlayerEntersBats {
	
	Game game = new Game();
	String direction = "";
	
	public TestPlayerEntersBats() {
		ArrayList<Cavern> batCaverns = game.theCave.getCavernsWithBats();
		Cavern batCavern = batCaverns.get(0);
		int batCavernNumber = batCavern.getCavernNumber();
		int batCavernX = game.theCave.getCavernX(batCavernNumber);
		int batCavernY = game.theCave.getCavernY(batCavernNumber);
		
		if(!game.theCave.boundaryExists(batCavernNumber, "WEST")) {
			game.theCharacter.hardSetLocation(batCavernX-1, batCavernY);
			direction = "EAST";
		}else if(!game.theCave.boundaryExists(batCavernNumber, "EAST")) {
			game.theCharacter.hardSetLocation(batCavernX+1, batCavernY);
			direction = "WEST";
		}else if(!game.theCave.boundaryExists(batCavernNumber, "NORTH")) {
			game.theCharacter.hardSetLocation(batCavernX, batCavernY-1);
			direction = "SOUTH";
		}else if(!game.theCave.boundaryExists(batCavernNumber, "SOUTH")) {
			game.theCharacter.hardSetLocation(batCavernX, batCavernY+1);
			direction = "NORTH";
		}
	}
	
	public String outputMessage() {
		ArrayList<Cavern> batCaverns = game.theCave.getCavernsWithBats();
		Cavern batCavern = batCaverns.get(0);
		
		int cavernXDifference = 0;
		int cavernYDifference = 0;
		
		if(direction == "EAST") {
			cavernXDifference = 1;
		}
		if(direction == "WEST") {
			cavernXDifference = -1;
		}
		if(direction == "NORTH") {
			cavernXDifference = 1;
		}
		if(direction == "SOUTH") {
			cavernXDifference = -1;
		}
		
		if(game.theCave.getCave()[game.theCave.getCavernX(game.getCavernContainingCharacter().getCavernNumber()) + cavernXDifference]
				[game.theCave.getCavernY(game.getCavernContainingCharacter().getCavernNumber()) + cavernYDifference] == batCavern) {
		return "You have entered a cavern infested with bats and they have flown you to a random location in the cave.";
		} else {
			return "";
		}
	}
	
	private Cavern getPlayerLocation() {
		return game.getCavernContainingCharacter();
	}
	
	private Cavern getBatLocation() {
		ArrayList<Cavern> batCaverns = game.theCave.getCavernWithPits();
		Cavern batCavern = batCaverns.get(0);
		return batCavern;
	}
	
	public boolean playerNewLocationDoesNotEqualOldLocation() {
		game.turn(direction);
		if(getPlayerLocation() != getBatLocation()) {
			return true;
		} else {
			return false;
		}
	}

}
