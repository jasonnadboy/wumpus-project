package test;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Game;

public class AdjacentCavernContainsBatsPitsWumpus {
	
	private int cavernX;
	private int cavernY;
	
	private int currentCavern;
	
	Cave cave = new Cave();
	Cavern[][] caverns = cave.getCave();
	Game game = new Game();
	
	private Cavern northernCavern() {
		if (cave.boundaryExists(currentCavern, "NORTH")) {
			return null;
		}
		else {
			return caverns[cavernX][cavernY-1];
		}
	}
	
	private Cavern southernCavern() {
		if (cave.boundaryExists(currentCavern, "SOUTH")) {
			return null;
		}
		else {
			return caverns[cavernX][cavernY+1];
		}
	}
	
	private Cavern westernCavern() {
		if (cave.boundaryExists(currentCavern, "WEST")) {
			return null;
		}
		else {
			return caverns[cavernX-1][cavernY];
		}
	}
	
	private Cavern easternCavern() {
		if (cave.boundaryExists(currentCavern, "EAST")) {
			return null;
		}
		else {
			return caverns[cavernX+1][cavernY];
		}
	}
	
	private String ifCavernContainsBatsHearChirping() {
		if (northernCavern() != null) {
			if(northernCavern().hasBats()) {
				return "I HEAR CHIRPS ";
			}
		}
		else if (southernCavern() != null) {
			if(southernCavern().hasBats()) {
				return "I HEAR CHIRPS ";
			}
		}
		else if (easternCavern() != null) {
			if(easternCavern().hasBats()) {
				return "I HEAR CHIRPS ";
			}
		}
		else if (westernCavern() != null) {
			if(westernCavern().hasBats()) {
				return "I HEAR CHIRPS ";
			}
		}
		return "";
	}
	
	private String ifCavernContainsPitsHearWind() {
		if (northernCavern() != null) {
			if(northernCavern().hasPits()) {
				return "I HEAR WIND ";
			}
		}
		else if (southernCavern() != null) {
			if(southernCavern().hasPits()) {
				return "I HEAR WIND ";
			}
		}
		else if (easternCavern() != null) {
			if(easternCavern().hasPits()) {
				return "I HEAR WIND ";
			}
		}
		else if (westernCavern() != null) {
			if(westernCavern().hasPits()) {
				return "I HEAR WIND ";
			}
		}
		return "";
	}
	
	private String ifCavernContainsWumpusSmellScent() {
		Cavern wumpusCavern = game.getCavernContainingWumpus();
		if(wumpusCavern == northernCavern()) {
			return "I SMELL WUMPUS ";
		}
		if(wumpusCavern == southernCavern()) {
			return "I SMELL WUMPUS ";
		}
		if(wumpusCavern == easternCavern()) {
			return "I SMELL WUMPUS ";
		}
		if(wumpusCavern == westernCavern()) {
			return "I SMELL WUMPUS ";
		}
		return "";
	}
	
	public String cavernAdjacentToContainsEnemyPrintMessage(int cavernNumber) {
		cavernX = cave.getCavernX(cavernNumber);
		cavernY = cave.getCavernY(cavernNumber);
		currentCavern = cavernNumber;
		return ifCavernContainsBatsHearChirping() + ifCavernContainsPitsHearWind() + ifCavernContainsWumpusSmellScent();
	}

}
