/**
 *
 * Ryan Breeden
 *  February 22, 2023
 *  Java 605.201.83
 *  A program to translate Morse code into English and English into Morse code.
 *
 */

import java.util.Scanner;

public class MorseCodeTranslator
{
    // Store the all the alphabet in an array
     private static char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
             'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
             'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
             '9', '0'};

    // Store the all the morse code in an array
    private static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"};

    public static void main(String[] args)
    {
        int userChoice = 0;     // Variable to catch user selection: 1, 2, 3

        do
        {
            // Create a Scanner to obtain user input
            Scanner input = new Scanner(System.in);

            // Main menu to prompt user to select between translation type or quit the program.
            // New line space
            System.out.println();
            System.out.println("\nTranslation Menu: ");
            System.out.println("\n1 - Morse Code to English");
            System.out.println("\n2 - English to Morse Code");
            System.out.println("\n3 - Quit");
            System.out.print("\nPlease choose a translation type: ");
            userChoice = input.nextInt();

            // Processes user choice down to the process method
            process(userChoice);
        }
        while ( userChoice != 3);
    }

    private static void process(int choice)
    {

        // Program process to receive and execute based on user choice from main menu
        switch (choice)
        {
            case 1:
                // Translate form morse code to english method
                translateToEnglish();
                break;
            case 2:
                // Translate form english to morse cod method
                translateToMorseCode();
                break;
            case 3:
                // End Program
                System.out.println("\nBye Bye");
                break;
            default:
                // Invalid Data Entered
                System.out.println( "Invalid Data: You must enter 1, 2, or 3" );
        }
    }

    private static void translateToEnglish()
    {
        // Create a Scanner to obtain user input
        Scanner input = new Scanner(System.in);
        // New line space
        System.out.println();
        // Prompts user to enter a statement in morse code to be translated to english
        System.out.print("Please enter a statement in Morse Code: ");
        // Catches input from user
        String morseScript = input.nextLine();

        System.out.print("\nThe English translation of " + "'" + morseScript + "'" + " is ");

        // Creates a string variable with no characters
        String[] words = null;

        // Tests user input for delimiters
        if (morseScript.contains("|"))
        {
            // Removes delimiter from morse code of user input
            words = morseScript.split("[|]");
        }
        else
        {
            words = new String[1];
            words[0] = morseScript;
        }

        // Places elements from string words and places them into new string word
        for (String word: words )
        {
            String[] characters = word.split(" ");
            // Iterates through character array (user input) until the end is reached
            for(int i = 0;i < characters.length; i++)
            {
                // Iterates through morse code array until the end is reached
                for(int j = 0;j < morse.length;j++)
                {
                    // Tests if letter in character array matches with letter in morse code array
                    if(characters[i].equals(morse[j]))
                    {
                        // Prints output of english translation
                        System.out.print(english[j]);
                    }
                }
            }
            // Prints space between words during each for-loop iteration
            System.out.print(" ");
        }
    }

    private static void translateToMorseCode()
    {
        // Create a Scanner to obtain user input
        Scanner input = new Scanner(System.in);
        // New line space
        System.out.println();
        // Prompts user to enter a statement in english to be translated to morse code
        System.out.print("Please enter a statement in English: ");
        // Catches input from user
        String englishScript = input.nextLine();

        System.out.print("\nThe Morse code translation of " + "'" + englishScript + "'" + " is ");

        // Creates a string variable with no characters
        String translator = "";
        // Converts input from user into character array
        char[] array = englishScript.toCharArray();

        // Iterates through character array (user input) until the end is reached
        for (int i = 0; i < array.length; i++)
        {
            // Iterates through english array until the end is reached
            for (int j = 0; j < english.length; j++)
            {
                // Tests if letter in english array matches with letter in array
                if (english[j] == array[i]) {
                    translator += morse[j] + " ";
                }
            }
        }
        //Prints output
        System.out.println(translator);
    }
}


