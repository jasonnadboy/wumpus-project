package cave;

public class Cavern {
	
	private Cavern northConnection;
	private Cavern southConnection;
	private Cavern eastConnection;
	private Cavern westConnection;
	
	public void setNorthConnection(Cavern northCavern) {
		northConnection = northCavern;
	}
	
	public void setSouthConnection(Cavern southCavern) {
		southConnection = southCavern;
	}
	
	public void setEastConnection(Cavern eastCavern) {
		eastConnection = eastCavern;
	}
	
	public void setWestConnection(Cavern westCavern) {
		westConnection = westCavern;
	}
	
	public Cavern getConnection(DIR dir) {
		switch(dir) {
			case N:
				return northConnection;
			case S:
				return southConnection;
			case E:
				return eastConnection;
			default:
				return westConnection;
		}		
	
	}
}
