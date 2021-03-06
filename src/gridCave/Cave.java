package gridCave;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Cave {
	
	Cavern[][] caverns;
	ArrayList<Cavern> cavernsWithBats;
	ArrayList<Cavern> cavernsWithPits;
	
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
		
		cavernsWithBats = new ArrayList<Cavern>();
		cavernsWithPits = new ArrayList<Cavern>();
		
		setBats(2);
		setPits(2);
		
		//System.out.println("Pits " + cavernsWithPits.get(0).getCavernNumber() + " " + cavernsWithPits.get(1).getCavernNumber());
		//System.out.println("bats " + cavernsWithBats.get(0).getCavernNumber() + " " + cavernsWithBats.get(1).getCavernNumber());

	}
	
	private void setBats(int numberOfBats) {
		Random rand = new Random();
		for(int i = 0; i < numberOfBats; i++) {
			int randomX = rand.nextInt(5);
			int randomY = rand.nextInt(5);
			while(randomX == 2 && randomY == 2) {
				randomX = rand.nextInt(5);
				randomY = rand.nextInt(5);
			}
			caverns[randomX][randomY].putBats();
			cavernsWithBats.add(caverns[randomX][randomY]);
		}
	}
	
	private void setPits(int numberOfPits) {
		Random rand = new Random();
		for(int i = 0; i < numberOfPits; i++) {
			int randomX = rand.nextInt(5);
			int randomY = rand.nextInt(5);
			while(randomX == 2 && randomY == 2) {
				randomX = rand.nextInt(5);
				randomY = rand.nextInt(5);
			}
			caverns[randomX][randomY].putPit();
			cavernsWithPits.add(caverns[randomX][randomY]);
		}
		
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

		if(boundaryFromCavern >= 5 || boundaryFromCavern < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<Cavern> getCavernsWithBats() {
		return cavernsWithBats;
	}
	
	public ArrayList<Cavern> getCavernWithPits() {
		return cavernsWithPits;
	}
	
	public boolean pitNearby(int cavernNumber) {
		int x = getCavernX(cavernNumber);
		int y = getCavernY(cavernNumber);
		
		Cavern northernCavern = null;
		Cavern southernCavern = null;
		Cavern easternCavern = null;
		Cavern westernCavern = null;
		
		if(!boundaryExists(cavernNumber, "NORTH")) {
			northernCavern = caverns[x][y-1];
		}
		if(!boundaryExists(cavernNumber, "SOUTH")) {
			southernCavern = caverns[x][y+1];
		}
		if(!boundaryExists(cavernNumber, "EAST")) {
			easternCavern = caverns[x+1][y];
		}
		if(!boundaryExists(cavernNumber, "WEST")) {
			westernCavern = caverns[x-1][y];
		}

		if((northernCavern!= null && northernCavern.hasPits()) 
				|| (southernCavern!= null && southernCavern.hasPits())  
				|| (easternCavern!= null && easternCavern.hasPits()) 
				|| (westernCavern!= null && westernCavern.hasPits()) ) {
			return true;
		}
		
		return false;
	}
	
	public boolean batNearby(int cavernNumber) {
		int x = getCavernX(cavernNumber);
		int y = getCavernY(cavernNumber);
		
		Cavern northernCavern = null;
		Cavern southernCavern = null;
		Cavern easternCavern = null;
		Cavern westernCavern = null;
		
		if(!boundaryExists(cavernNumber, "NORTH")) {
			northernCavern = caverns[x][y-1];
		}
		if(!boundaryExists(cavernNumber, "SOUTH")) {
			southernCavern = caverns[x][y+1];
		}
		if(!boundaryExists(cavernNumber, "EAST")) {
			easternCavern = caverns[x+1][y];
		}
		if(!boundaryExists(cavernNumber, "WEST")) {
			westernCavern = caverns[x-1][y];
		}

		if((northernCavern!= null && northernCavern.hasBats()) 
				|| (southernCavern!= null && southernCavern.hasBats())  
				|| (easternCavern!= null && easternCavern.hasBats()) 
				|| (westernCavern!= null && westernCavern.hasBats()) ) {
			return true;
		}
		
		return false;
	}

}
