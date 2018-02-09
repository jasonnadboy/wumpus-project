package test;

import java.util.ArrayList;

import gridCave.Cavern;
import gridCave.Game;

public class TestPlayerEntersPit {
	
	Game game = new Game();
	
	public TestPlayerEntersPit() {
		ArrayList<Cavern> pitCaverns = game.theCave.getCavernWithPits();
		Cavern pitCavern = pitCaverns.get(0);
		int pitCavernNumber = pitCavern.getCavernNumber();
		int pitCavernX = game.theCave.getCavernX(pitCavernNumber);
		int pitCavernY = game.theCave.getCavernY(pitCavernNumber);
		
		if(!game.theCave.boundaryExists(pitCavernNumber, "WEST")) {
			game.theCharacter.hardSetLocation(pitCavernX-1, pitCavernY);
			game.turn("EAST");
		}else if(!game.theCave.boundaryExists(pitCavernNumber, "EAST")) {
			game.theCharacter.hardSetLocation(pitCavernX+1, pitCavernY);
			game.turn("WEST");
		}else if(!game.theCave.boundaryExists(pitCavernNumber, "NORTH")) {
			game.theCharacter.hardSetLocation(pitCavernX, pitCavernY-1);
			game.turn("SOUTH");
		}else if(!game.theCave.boundaryExists(pitCavernNumber, "SOUTH")) {
			game.theCharacter.hardSetLocation(pitCavernX, pitCavernY+1);
			game.turn("NORTH");
		}
	}
	
	public Cavern getPlayerLocation() {
		return game.getCavernContainingCharacter();
	}
	
	public Cavern getPitLocation() {
		ArrayList<Cavern> pitCaverns = game.theCave.getCavernWithPits();
		Cavern pitCavern = pitCaverns.get(0);
		return pitCavern;
	}
	
	public String generatePitDeathMessage() {
		if(game.getCavernContainingCharacter().hasPits()) {
			return "You fell in the pit. Game Over";
		} else {
			return "";
		}
	}
	
	public boolean playerLocationEqualsPitLocation() {
		if(getPlayerLocation() == getPitLocation()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isGameOver() {
		return game.isGameOver();
	}

}
