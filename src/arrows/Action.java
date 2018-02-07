package arrows;

import gridCave.Character;

public class Action {
	
	Character character;
	
	public Action(Character character) {
		this.character = character;
	}
	
	public String shootArrow() {
		int numberOfArrows = character.getNoOfArrows();
		if (numberOfArrows > 0) {
			character.setNoOfArrows(numberOfArrows--);
			return "Arrow shot";
		} else {
			return "You do not have any arrows left";
		}
	}
}
