package com.chainsys.day4;

import java.util.Scanner;

public class Game {

	// Create a method called displayHighScorePosition
	// it should take a player's name as a parameter, and a 2nd parameter as a
	// position in the high score table
	// You should display the player's name along with a message like "managed to
	// get into position " and the
	// position they got and a further message "on the high score table".
	public static void displayHighScorePosition(String playerName, int position) {
		System.out.println(playerName + " managed to get into position " + position + " on the high score table.");
	}

	// Create a method called calculateHighScorePosition
	// it should take a player's score as a parameter
	// return the position in the high score table.
	public static int calculateHighScorePosition(int playerScore) {
		if (playerScore >= 1000) {
			return 1;
		} else if (playerScore >= 500) {
			return 2;
		} else if (playerScore >= 100) {
			return 3;
		} else {
			return 4;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		To calculate score boolean gameOver,int score, int levelCompleted, int bonus
//		Create method
//		    -basic
//		    -method with proper return type
		boolean gameOver = false;
		int score = 0;
		int levelCompleted = 0;
		int bonus = 10;
		System.out.println("Quiz game...");
		System.out.print("Enter your name: ");
		String name = sc.next();

		String[] questions = { "Is Java platform-independent?", "Is Java case-sensitive?",
				"Are arrays in Java fixed in size once they are created?" };
		String[] correctAnswers = { "yes", "yes", "yes" }; // Array of correct answers

		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i]);
			String ans = sc.next().toLowerCase();
			 while(true) {
		        	if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("no")) {
		        		break;
		        	}
		        	System.out.println("invalid ! choose yes/no");
		        	System.out.println(questions[i]);
		    		ans=sc.next();
		      }
			// Convert input to lowercase for case-insensitive comparison

		
			if (ans.equals(correctAnswers[i])) {
				System.out.println("Correct!");
				score += 200;
				bonus += 10;
				levelCompleted++;
				System.out.println("Your score: " + score + ", Level Completed: " + levelCompleted);
			} else {
				System.out.println("Wrong answer!");
				System.out.println("game over..");
				gameOver=true;
				break;
			}

		}
        if(gameOver) {
        	bonus=0;
        }
        else {
        	bonus=300;
        }
		// Display final high score position
		int finalScore = score + bonus;
		System.out.println("your score :" + finalScore);
		int position = calculateHighScorePosition(finalScore);
		displayHighScorePosition(name, position);

	}
}
