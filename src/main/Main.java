package main;

import java.util.Scanner;

import gridCave.Game;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Do you want to play a game? Enter OK if so, otherwise hit return.");
		
		while(scanner.nextLine().equals("OK")) {
			
			Game newGame = new Game();
			
			System.out.println("Do you want to play on baby mode? Enter FINE if so, otherwise hit return. ");
			
			if (scanner.nextLine().equals("FINE")) {
				newGame.turnOnEasyMode();
			}
			
			
			System.out.println("\n Game Begins"
					+ "\n Welcome to a new game of Hunt The Wumpus!!!"
					+ "\n You are trapped in a cave system and you must kill the Wumpus to win the game."
					+ "\n On each turn you must input one of five movements: NORTH, EAST, WEST, SOUTH, REST"
					+ "\n If you feel wind, you are next to a cavern with a pit."
					+ "\n If you heard chirping, you are next to a cavern with bats."
					+ "\n If you smell coffee, you are next to a cavern with the Wompus feasting on a frappe."
					+ "\n To kill the Wumpus, you may input one of five shooting options: SHOOT NORTH, SHOOT EAST, SHOOT WEST, SHOOT SOUTH"
					+ "\n However you may not make a movement and shoot an arrow in the same turn."
					+ "\n If you hit the Wumpus, you win!!! But beware! If you shoot into an adjacent wall, "
					+ "\n 	Newton's Third Law of Motion kicks in and the arrow will bounce back and kill you, resulting in a game over."
					+ "\n");		
			
			System.out.println("Right now ... You have five arrows. " + newGame.initialCheck());
			
			while (!newGame.isGameOver()) {
				System.out.println("\nPlease input a command: ");
				newGame.wumpusLocation();
				String input = scanner.nextLine();
				
				String outputMessage = newGame.turn(input);
				
				System.out.println(outputMessage);
			}	
		System.out.println("\nDo you want to play again? Enter OK if so, otherwise hit return.");
		}
		System.out.println("Thank you for your time. May the Agile Practice be with you.");
	}

}
