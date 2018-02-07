package gridCave;

public class test {
	
	private int cavernOrigin;
	private int cavernDestination;

	private int originX;
	private int originY;
	private int destinationX;
	private int destinationY;
	
	public void setCurrentCavern(int cavernNumber) {
		cavernOrigin = cavernNumber;
	}
	
	public void setDestinationCavern(int cavernNumber) {
		cavernDestination = cavernNumber;
	}
	
	public String getCavernToCavernDirection(){
		Cave cave = new Cave();
		
		originX = cave.getCavernX(cavernOrigin);
		originY = cave.getCavernY(cavernOrigin);
		destinationX = cave.getCavernX(cavernDestination);
		destinationY = cave.getCavernY(cavernDestination);
		
		return findCavernDirection();
	}

	private String findCavernDirection() {
		int xDifference = destinationX - originX;
		int yDifference = destinationY - originY;

		if(xDifference == 1 && yDifference == 0) {
			return "E";
		}
		else if (xDifference == -1 && yDifference == 0) {
			return "W";
		}
		else if (xDifference == 0 && yDifference == 1) {
			return "N";
		}
		else if (xDifference == 0 && yDifference == -1) {
			return "S";
		} else {
			return null;
		}
	}

}
