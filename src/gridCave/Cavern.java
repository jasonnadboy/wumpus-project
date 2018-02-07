package gridCave;

public class Cavern {
	
	private int cavernNumber;
	
	private boolean containsBats;
	private boolean containsPits;
	
	public Cavern(int i) {
		cavernNumber = i;
		containsBats = false;
		containsPits = false;
	}

	public int getCavernNumber() {
		return cavernNumber;
	}
	
	public boolean hasBats() {
		return containsBats;
	}
	
	public boolean hasPits() {
		return containsPits;
	}
	
	public void putBats() {
		containsBats = true;
	}
	
	public void putPit() {
		containsPits = true;
	}

}
