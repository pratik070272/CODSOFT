import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1; // Generate a random number between 1 and 100
        int userGuess;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.print("Guess the number (between 1 and 100): ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
            }
        } while (userGuess != randomNumber);

        scanner.close();
    }
}
