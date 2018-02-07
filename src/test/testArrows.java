package test;

import gridCave.Game;

public class testArrows {
	
	public int arrowCountAtStartOfGame() {
		Game newGame = new Game();
		return newGame.theCharacter.getNoOfArrows();
	}
	
	
	public String arrowCount0ReturnError() {
		Game newGame = new Game();
		newGame.theCharacter.setNoOfArrows(0);
		return newGame.theCharacter.shootArrow();
		}

}
