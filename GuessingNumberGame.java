/*

Ryan Breeden
February 9th, 2023
Java 605.201.83

 */

import java.util.Scanner;

public class GuessingNumberGame
{
    public static void main(String [] args)
    {
        int NumOfGuesses;     // Track number of guesses
        int randomNumber;     // Generated random number variable
        int secretNum;        // Secret number guess made by user
        int replayResponse;   // User given option to replay unless declined - outer do-while loop

        do
        {
            // Initial prompt when program first runs
            System.out.println("\nWelcome to The Guessing Number Game!!!\n");

            // Scanner class to input integer values
            Scanner in = new Scanner(System.in);

            // Prompt user to select a maximum number to choose from within range
            System.out.print("Set you max number to get started: ");
            int n = in.nextInt();

            // Prompts user to enter max number of guesses to  perform
            System.out.print("Enter the number of guesses you wish to make: ");
            NumOfGuesses = in.nextInt();

            // Generate the random number
            randomNumber = (int)(n * Math.random()) + 1;

            do
            {
                // Prompts user to guess a number no larger than the maximum number they selected
                System.out.print("\nGuess a secret number no greater than " + n + ": ");
                secretNum = in.nextInt();         // Inputs secret number
                NumOfGuesses--;                   // Decrement total guesses remaining by 1

                // If statement to determine if user secret number equals random generated number
                if (secretNum == randomNumber)
                {
                    System.out.println("\nCongratulations, you guessed correctly!\n");
                }
                else if (secretNum > randomNumber)
                {
                    System.out.println("\nSorry, the number is less than " + secretNum + "." + "\n");
                }
                else
                {
                    System.out.println("\nSorry, the number is greater than " + secretNum + "." + "\n");
                }

            } while((NumOfGuesses != 0) && (secretNum != randomNumber));  // Repeats guessing process if conditions=true

            if ((NumOfGuesses == 0) && (secretNum != randomNumber))  // Reveals random number if user run out of guesses
            // without guessing correct number
            {
                System.out.println("You have exhausted you number of guesses.\n");
                System.out.println("The magic number was " + randomNumber + ".\n");
            }
            // Prompts user to play again or quit game
            System.out.print("To play again, please enter 1 (Yes) or 2 (No): ");
            replayResponse = in.nextInt();

        } while (replayResponse == 1);      // Repeats program based on user response
    }
}