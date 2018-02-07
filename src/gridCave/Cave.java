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
	
	

}
