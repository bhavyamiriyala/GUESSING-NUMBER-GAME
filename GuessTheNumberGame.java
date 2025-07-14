import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        System.out.println("You have a maximum of 7 attempts per round.\n");

        while (playAgain) {
            int target = random.nextInt(100) + 1; // generates 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s).");
                    int roundScore = 100 - (attempts - 1) * 10;
                    totalScore += roundScore;
                    System.out.println("You scored: " + roundScore + " points.\n");
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + target);
                System.out.println("You scored: 0 points this round.\n");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = input.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Your total score: " + totalScore + " points.");
        input.close();
    }
}
