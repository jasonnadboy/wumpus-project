package gridCave;

import arrows.Action;

public class Character {
	
	private int x;
	private int y;
	private int noOfArrows = 5;
	public Action arrowAction;

	public Character(int startX, int startY) {
		x = startX;
		y = startY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move(String direction) {
		switch(direction) {
			case "NORTH": y--;
				break;
			case "SOUTH": y++;
				break;
			case "EAST": x++;
				break;
			case "WEST": x--;
				break;
			case "REST":
				break;
			default:
				break;
		}	
	}
	
	public void hardSetLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void shootArrow(int currentCavern, String direction) {
		if (noOfArrows > 0) {
			arrowAction.shootArrowDirection(currentCavern, direction);
			noOfArrows--;
		}
	}

	public int getNoOfArrows() {
		return noOfArrows;
	}

	public void setNoOfArrows(int noOfArrows) {
		this.noOfArrows = noOfArrows;
	}

}
