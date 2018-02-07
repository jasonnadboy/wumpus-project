package gridCave;

public class Cave {
	
	Cavern[][] caverns;
	
	public Cave() {
		
		int[] cavernNumbers = {1,2,3,4,5,16,17,18,19,6,15,24,25,20,7,14,23,22,21,8,13,12,11,10,9};
		int counter = 0;
		
		caverns = new Cavern[5][5];
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				caverns[x][y] = new Cavern(cavernNumbers[counter]);
				counter++;
			}
		}
		
		setBats(2);
		setPits(2);
	}
	
	private void setBats(int numberOfBats) {
		caverns[0][1].putBats();
		caverns[3][2].putBats();
	}
	
	private void setPits(int numberOfPits) {
		caverns[1][0].putPit();
		caverns[0][2].putPit();
	}
	
	public Cavern[][] getCave() {
		return caverns;
	}

	public int getCavernX(int cavernNumber) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if(caverns[x][y].getCavernNumber() == cavernNumber) {
					return x;
				}
			}
		}
		return -1;

	}

	public int getCavernY(int cavernNumber) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if(caverns[x][y].getCavernNumber() == cavernNumber) {
					return y;
				}
			}
		}
		return -1;
	}
	
	public boolean boundaryExists(int cavernNumber, String direction) {
		int cavernX = getCavernX(cavernNumber);
		int cavernY = getCavernY(cavernNumber);
		int boundaryFromCavern = 0;
		
		if (direction.toUpperCase().equals("NORTH")) {
			boundaryFromCavern = cavernY - 1;
		}
		if (direction.toUpperCase().equals("SOUTH")) {
			boundaryFromCavern = cavernY + 1;
		}
		if (direction.toUpperCase().equals("EAST")) {
			boundaryFromCavern = cavernX + 1;
		}
		if (direction.toUpperCase().equals("WEST")) {
			boundaryFromCavern = cavernX - 1;
		}

		if(boundaryFromCavern >= 3 || boundaryFromCavern < 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
