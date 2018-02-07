package cave;

public class Cavern1 {
	
	private String name;
	private Cavern1 northConnection;
	private Cavern1 southConnection;
	private Cavern1 eastConnection;
	private Cavern1 westConnection;
	
	public Cavern1(String n) {
		name = n;
	}
	
	public void setNorthConnection(Cavern1 northCavern) {
		northConnection = northCavern;
	}
	
	public void setSouthConnection(Cavern1 southCavern) {
		southConnection = southCavern;
	}
	
	public void setEastConnection(Cavern1 eastCavern) {
		eastConnection = eastCavern;
	}
	
	public void setWestConnection(Cavern1 westCavern) {
		westConnection = westCavern;
	}
	
	public Cavern1 getConnection(DIR dir) {
		switch(dir) {
			case N:
				return northConnection;
			case S:
				return southConnection;
			case E:
				return eastConnection;
			case W:
				return westConnection;
			default:
				return null;
		}		
	
	}
	
	public String getName() {
		return name;
	}
}
