package gridCave;

public class test {
	
	private int cavernOrigin;
	private int cavernDestination;
	
	public void setCurrentCavern(int cavernNumber) {
		cavernOrigin = cavernNumber;
	}
	
	public void setDestinationCavern(int cavernNumber) {
		cavernDestination = cavernNumber;
	}
	
	public String getCavernToCavernDirection(){
		Cave cave = new Cave();
		
		int x1 = cave.getCavernX(cavernOrigin);
		int y1 = cave.getCavernY(cavernOrigin);
		int x2 = cave.getCavernX(cavernDestination);
		int y2 = cave.getCavernY(cavernDestination);
		
		return findCavernDirection(x1,x2,y1,y2);
	}

	private String findCavernDirection(int originX, int originY, int destinationX, int destinationY) {
		
		return null;
	}

}
