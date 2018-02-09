package test;

import java.util.HashSet;

import gridCave.Game;

public class TestPlayerValidMoves {
	
	Game game = new Game();
	public String inputCommand;
	HashSet<String> directionsToMove = new HashSet<String>();
	
	public void setCommand(String command) {
		inputCommand = command;
	}
	
	public boolean isValid() {
		if((commandMessage() == "You have successfully moved.") 
				|| (commandMessage() == "You have successfully rested.")
				|| (commandMessage() == "You have successfully shot.")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String commandMessage() {
		directionsToMove.add("NORTH");
		directionsToMove.add("SOUTH");
		directionsToMove.add("WEST");
		directionsToMove.add("EAST");
		directionsToMove.add("REST");
		directionsToMove.add("SHOOT NORTH");
		directionsToMove.add("SHOOT SOUTH");
		directionsToMove.add("SHOOT WEST");
		directionsToMove.add("SHOOT EAST");
		
		if(!directionsToMove.contains(inputCommand)) {
			return "Invalid command given. Please try again.";
		}
		
		if(directionsToMove.contains(inputCommand)) {
			if (inputCommand.equals("REST")) {
				return "You have successfully rested.";
			} else if (inputCommand.equals("SHOOT NORTH") 
					|| inputCommand.equals("SHOOT SOUTH")
					|| inputCommand.equals("SHOOT EAST")
					|| inputCommand.equals("SHOOT WEST")) {
				return "You have successfully shot.";
			}
			else {
				return "You have successfully moved.";
			}
		}
		return "";
	}
}
