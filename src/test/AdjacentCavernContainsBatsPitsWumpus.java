package test;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Game;
import gridCave.Wumpus;

public class AdjacentCavernContainsBatsPitsWumpus {

	Cave cave = new Cave();
	Cavern[][] caverns = cave.getCave();
	Game game = new Game();
	Cavern testCavern = caverns[1][1];
	
	Cavern northernCavern = caverns[1][0];
	Cavern southernCavern = caverns[1][2];
	Cavern easternCavern = caverns[2][1];
	Cavern westernCavern = caverns[0][1];
	
	
	public String ifAdjacentCavernContainsBatsHearChirping() {
		northernCavern.putBats();
		if(cave.batNearby(testCavern.getCavernNumber())) {
			return "I HEAR CHIRPS";
		}
		return "";
	}
	
	public String ifAdjacentCavernContainsPitsHearWind() {
		northernCavern.putPit();
		if (cave.pitNearby(testCavern.getCavernNumber())) {
			return "I HEAR WIND";
		}
		return "";
	}
	
	public String ifAdjacentCavernContainsBatsAndWumpusSmellScentAndHearChirps() {
		northernCavern.putBats();
		Wumpus wumpus = new Wumpus(0,1);
		
		String wumpusString = "";
		String batString = "";
		
		if(northernCavern.hasBats() || southernCavern.hasBats() || easternCavern.hasBats() 
				|| westernCavern.hasBats()) {
			batString = "I HEAR CHIRPS";
		}
		Cavern wumpusCavern = caverns[wumpus.getLocationX()][wumpus.getLocationY()];
		if(wumpusCavern.getCavernNumber() == northernCavern.getCavernNumber() 
				|| wumpusCavern.getCavernNumber() == southernCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == easternCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == westernCavern.getCavernNumber()){
			wumpusString = "I SMELL A WUMPUS";
		}
		return batString + " AND " + wumpusString;
	}
	
	public String ifAdjacentCavernContainsBatsAndPitsHearChirpsAndHearWind() {
		northernCavern.putBats();
		southernCavern.putPit();
		
		String pitString = "";
		String batString = "";
		
		if(northernCavern.hasBats() || southernCavern.hasBats() || easternCavern.hasBats() 
				|| westernCavern.hasBats()) {
			batString = "I HEAR CHIRPS";
		}
		if(northernCavern.hasPits() || southernCavern.hasPits() || easternCavern.hasPits() 
				|| westernCavern.hasPits()) {
			pitString = "I HEAR WIND";
		}
		return batString + " AND " + pitString;
	}
	
	public String ifAdjacentCavernContainsPitsAndWumpusSmellScentAndHearWind() {
		northernCavern.putPit();
		Wumpus wumpus = new Wumpus(0,1);
		
		String wumpusString = "";
		String pitString = "";
		
		if(northernCavern.hasPits() || southernCavern.hasPits() || easternCavern.hasPits() 
				|| westernCavern.hasPits()) {
			pitString = "I HEAR WIND";
		}
		Cavern wumpusCavern = caverns[wumpus.getLocationX()][wumpus.getLocationY()];
		if(wumpusCavern.getCavernNumber() == northernCavern.getCavernNumber() 
				|| wumpusCavern.getCavernNumber() == southernCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == easternCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == westernCavern.getCavernNumber()){
			wumpusString =  "I SMELL A WUMPUS";
		}
		return wumpusString + " AND " + pitString;
	}
	
	public String ifAdjacentCavernContainsBatsAndPitsAndWumpusSmellScentAndHearChirpsAndHearWind() {
		northernCavern.putBats();
		southernCavern.putPit();
		Wumpus wumpus = new Wumpus(0,1);
		
		String wumpusString = "";
		String batString = "";
		String pitString = "";
		
		if(northernCavern.hasPits() || southernCavern.hasPits() || easternCavern.hasPits() 
				|| westernCavern.hasPits()) {
			pitString = "I HEAR WIND";
		}
		if(northernCavern.hasBats() || southernCavern.hasBats() || easternCavern.hasBats() 
				|| westernCavern.hasBats()) {
			batString = "I HEAR CHIRPS";
		}
		Cavern wumpusCavern = caverns[wumpus.getLocationX()][wumpus.getLocationY()];
		if(wumpusCavern.getCavernNumber() == northernCavern.getCavernNumber() 
				|| wumpusCavern.getCavernNumber() == southernCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == easternCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == westernCavern.getCavernNumber()){
			wumpusString = "I SMELL A WUMPUS";
		}
		return batString + " AND " + pitString + " AND " + wumpusString;
	}
	
	public String ifAdjacentCavernContainsWumpusSmellScent() {
		Wumpus wumpus = new Wumpus(0,1);
		Cavern wumpusCavern = caverns[wumpus.getLocationX()][wumpus.getLocationY()];
		if(wumpusCavern.getCavernNumber() == northernCavern.getCavernNumber() 
				|| wumpusCavern.getCavernNumber() == southernCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == easternCavern.getCavernNumber()
				|| wumpusCavern.getCavernNumber() == westernCavern.getCavernNumber()){
			return "I SMELL A WUMPUS";
		}
		return "";
	}
	
	public String ifAdjacentCavernContainsNothingSeeNothing() {
		return "";
	}
}
