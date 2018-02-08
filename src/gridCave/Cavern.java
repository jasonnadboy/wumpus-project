package gridCave;

public class Cavern {
	
	private int cavernNumber;
	private int arrowInCavernCount = 0;
	private boolean containsBats;
	private boolean containsPits;
	private boolean containsArrow;
	
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
	
	public boolean hasArrow() {
		return containsArrow;
	}

	
	public void putBats() {
		containsBats = true;
	}
	
	public void putPit() {
		containsPits = true;
	}
	
	public void putArrow() {
		arrowInCavernCount++;
		containsArrow = true;
	}

	
	public boolean putCanContainArrow() {
		if (containsPits == false && containsBats == false) {
			return true;
		} else {
			return false;
		}
	}


}
