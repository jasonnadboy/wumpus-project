package gridCave;

import java.util.Random;

public class Wumpus {
	
	private int locationX;
	private int locationY;
	
	public Wumpus(int X, int Y) {
		locationX = X;
		locationY = Y;
	}
	
	public int getLocationX() {
		return locationX;
	}
	
	public int getLocationY() {
		return locationY;
	}
	
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	
	public void move() {
		int tempX = locationX;
		int tempY = locationY;
		do {
			tempX = locationX;
			tempY = locationY;
			Random rand = new Random();
			int randomDirectionNumber = rand.nextInt(4);
			switch(randomDirectionNumber) {
				case 0: tempY--;
					break;
				case 1: tempY++;
					break;
				case 2: tempX--;
					break;
				case 3: tempX++;
					break;
				default:
					break;
		}	
		} while (tempX < 0 && tempX > 4 && tempY < 0 && tempY > 4);
		locationX = tempX;
		locationY = tempY;
	}

}
