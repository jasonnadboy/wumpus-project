package arrows;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Character;
import gridCave.Game;

public class Action {
	
	Cave cave;
	Game game;
	
	public Action(Game game, Cave cave) {
		this.game = game;
		this.cave = cave;
	}

	public void shootArrowDirection(int currentCavern, String direction) {
		int currentX = cave.getCavernX(currentCavern);
		int currentY = cave.getCavernY(currentCavern);
		
		if (direction == "NORTH" && currentX != 0) {
			shootArrowNorth(currentX,currentY);
		} else if(direction == "SOUTH" && currentX != 4){
			shootArrowSouth(currentX,currentY);
		} else if (direction == "EAST" && currentY != 4) {
			shootArrowEast(currentX,currentY);
		} else if (direction == "WEST" && currentY != 0) {
			shootArrowWest(currentX,currentY);
		}
		else {
			hitABoundaryHitYourself();
		}
		
		
	// 	cave.getCavernY(currentCavern);
//		if (cave.boundaryExists(currentCavern, direction) == false) {
//			 Cavern[][] caverns = cave.getCave();
//			 if (caverns[cave.getCavernX(currentCavern)][cave.getCavernY(currentCavern)].putCanContainArrow()){
//				 caverns[0][1].putArrow();
//				 // Arrow is retrievable
//				 
//			 }
//		} else {
//			// You killed yourself
//		}
	}

	private void hitABoundaryHitYourself() {
		game.gameOver();
		}

	private void shootArrowWest(int currentX, int currentY) {
		int destinationY = currentY;
		Cavern[][] caverns = cave.getCave();
		while(destinationY != 0) {
			if ((caverns[currentX][destinationY] == game.getCavernContainingWumpus())) {
				hitTheWampus();
			}
			destinationY--;
		}
		caverns[currentX][0].putArrow();
		
	}

	private void shootArrowEast(int currentX, int currentY) {
		int destinationY = currentY;
		Cavern[][] caverns = cave.getCave();
		while(destinationY != 4) {
			if ((caverns[currentX][destinationY] == game.getCavernContainingWumpus())) {
				hitTheWampus();
			}
			destinationY++;
		}
		caverns[currentX][4].putArrow();
	}

	private void shootArrowSouth(int currentX, int currentY) {
		int destinationX = currentX;
		Cavern[][] caverns = cave.getCave();
		while(destinationX != 4) {
			if ((caverns[destinationX][currentY] == game.getCavernContainingWumpus())){
				hitTheWampus();
			}
			destinationX++;
		}
		caverns[4][currentY].putArrow();
	}

	private void shootArrowNorth(int currentX, int currentY) {
		int destinationX = currentX;
		Cavern[][] caverns = cave.getCave();
		while(destinationX != 0) {
			if ((caverns[destinationX][currentY] == game.getCavernContainingWumpus())) {
				hitTheWampus();
			}
			destinationX--;			
		}
		caverns[0][currentY].putArrow();
	}

	private void hitTheWampus() {
		
	}
}
