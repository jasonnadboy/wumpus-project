package gridCave;

public class Cave {
	
	Cavern[][] caverns;
	
	public Cave() {
		
		int[] cavernNumbers = {1,2,3,8,9,4,7,6,5};
		int counter = 0;
		
		caverns = new Cavern[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				caverns[x][y] = new Cavern(cavernNumbers[counter]);
				counter++;
			}
		}		
	}

	public Cavern[][] getCave() {
		return caverns;
	}

	public int getCavernX(int cavernNumber) {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(caverns[x][y].getCavernNumber() == cavernNumber) {
					return x;
				}
			}
		}
		return -1;

	}

	public int getCavernY(int cavernNumber) {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(caverns[x][y].getCavernNumber() == cavernNumber) {
					return y;
				}
			}
		}
		return -1;
	}
}
