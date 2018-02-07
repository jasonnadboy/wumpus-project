package gridCave;

public class Game {
	
	private Character theCharacter;
	private Cave theCave;
	
	public Game() {
		theCave = new Cave();
		theCharacter = new Character(1,1);
	
	}
	
	public Cavern getCavernContainingCharacter() {
		int x = theCharacter.getX();
		int y = theCharacter.getY();
		Cavern[][] caverns = theCave.getCave();
		Cavern theCavern = caverns[x][y];
		return theCavern;
	}

}
