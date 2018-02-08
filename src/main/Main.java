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
				+ "\n");
		
		Scanner scanner = new Scanner(System.in);
		
		while (!newGame.isGameOver()) {
			System.out.println("Please input your next move: ");
			String input = scanner.nextLine();
			
			String outputMessage = newGame.turn(input);
			
			System.out.println("Turn is over. " + outputMessage);
		}
	}

}
