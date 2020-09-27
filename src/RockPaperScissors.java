/*
 * RockPaperScissors.java
 * Author:  Joseph Nguyen
 * Submission Date:  2/21/2020
 *
 * Purpose: You play rock, paper, or scissors with a computer until someone wins which is based off the number of points
 * that was inputed by the player to be required to win.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		//declare variables
		int pointsToWin, playerPoint, computerPoint; 
		String rockPaperScissors, result;

		//initialize variables
		playerPoint = 0;
		computerPoint = 0;
		result = "";
		
		//scanner keyboard and points to win
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Points to Win: ");
		pointsToWin = keyboard.nextInt();
		keyboard.nextLine();
		/* asks for your choice of rock paper scissors and then computer responds
		 * and it figures out who wins that point until one of the points matches the points to win
	     */
		do {
			System.out.print("Rock, paper, or scissors? ");
			rockPaperScissors = keyboard.nextLine();
			rockPaperScissors.trim();

			//makes sure person inputs correct choices or else it tells the person to try again with one of the possible choices
			if (rockPaperScissors.equalsIgnoreCase("rock") || rockPaperScissors.equalsIgnoreCase("paper") || rockPaperScissors.equalsIgnoreCase("scissors")) {
				String computerMove = ComputerOpponent.getMove();

				//prints out the outcome of a single round and gives the points to the winner of the round
				if (rockPaperScissors.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("scissors")) {
					result = "so you win!";
					playerPoint++;
				}
				else if (rockPaperScissors.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("paper")) {
					result = "so you lose.";
					computerPoint++;
				}
				else if (rockPaperScissors.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("rock"))
					result = "so it's a tie.";
				else if (rockPaperScissors.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("rock")) {
					result = "so you win!";
					playerPoint++;
				}
				else if (rockPaperScissors.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("scissors")) {
					result = "so you lose.";
					computerPoint++;
				}
				else if (rockPaperScissors.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("paper"))
					result = "so it's a tie.";
				else if (rockPaperScissors.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("rock")) {
					result = "so you lose.";
					computerPoint++;
				}
				else if (rockPaperScissors.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("paper")) {
					result = "so you win!";
					playerPoint++;
				}
				else
					result = "so it's a tie.";

				System.out.println("The computer chose " + computerMove + ", " + result + " (" + playerPoint + "-" + computerPoint + ")");
				
			}
			else
				System.out.println("Please choose 'rock', 'paper', or 'scissors'!");

		} while ((playerPoint < pointsToWin) && (computerPoint < pointsToWin));

		//prints out the outcome of the whole match
		if (playerPoint == pointsToWin)
			System.out.println("Congratulations! You won!");
		else 
			System.out.println("Sorry, you lost. Better luck next time!");




		System.exit(0);
		keyboard.close();

	}

}
