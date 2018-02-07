package gridCave;

public class Character {
	
	private int x;
	private int y;
	private int noOfArrows = 5;

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

	public int getNoOfArrows() {
		return noOfArrows;
	}

	public void setNoOfArrows(int noOfArrows) {
		this.noOfArrows = noOfArrows;
	}
}
