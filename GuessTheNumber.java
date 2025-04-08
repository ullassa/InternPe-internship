import java.util.Scanner;
import java.util.Random;

/**
 * GuessTheNumber Game
 * A simple Java console application where the user tries to guess
 * a randomly generated number between 1 and 100.
 * 
 * Author: [Your GitHub Username]
 * Date: [Date]
 */

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int numberOfTries = 0;
        int userGuess = 0;

        System.out.println("🎯 Welcome to the Guess the Number game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Can you guess what it is?\n");

        // Loop until the user guesses the correct number
        while (userGuess != numberToGuess) {
            System.out.print("🔢 Enter your guess: ");

            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.\n");
                } else if (userGuess > numberToGuess) {
                    System.out.println("📈 Too high! Try again.\n");
                } else {
                    System.out.println("🎉 Congratulations! You guessed the number in " + numberOfTries + " tries.");
                }
            } else {
                System.out.println("❌ Invalid input. Please enter an integer.\n");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }
}
