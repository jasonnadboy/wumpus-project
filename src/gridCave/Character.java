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
			case "EAST": x--;
				break;
			case "WEST": x++;
				break;
			default:
				break;
		}	
	}
	
	public void hardSetLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public String shootArrow() {
		if (noOfArrows > 0) {
			arrowAction.shootArrow();
			noOfArrows--;
			return "Arrow shot in x direction";
		}  else {
		return "You do not have any arrows left";
		}
	}

	public int getNoOfArrows() {
		return noOfArrows;
	}

	public void setNoOfArrows(int noOfArrows) {
		this.noOfArrows = noOfArrows;
	}
}
