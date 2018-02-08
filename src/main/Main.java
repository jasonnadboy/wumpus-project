package main;

import java.util.Scanner;

import gridCave.Game;

public class Main {

	public static void main(String[] args) {
		
		Game newGame = new Game();
		
		System.out.println("Game Begins"
				+ "\n Welcome to a new game of Hunt The Wumpus!!!"
				+ "\n You are trapped in a cave system and you must kill the Wumpus to win the game."
				+ "\n On each turn you must input one of five movements: NORTH, EAST, WEST, SOUTH, REST"
				+ "\n If you feel wind, you are next to a cavern with a pit."
				+ "\n If you heard chirping, you are next to a cavern with bats."
				+ "\n If you smell coffee, you are next to a cavern with the Wompus feasting on a frappe."
				+ "\n");
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Right now: " + newGame.initialCheck());
		
		while (!newGame.isGameOver()) {
			System.out.println("Please input your next move: ");
			newGame.wumpusLocation();
			String input = scanner.nextLine();
			
			String outputMessage = newGame.turn(input);
			
			System.out.println("Turn is over. " + outputMessage);
		}
	}

}
