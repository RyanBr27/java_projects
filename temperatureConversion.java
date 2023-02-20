import java.util.Scanner;

public class temperatureConversion
{
    public static void main(String[] args)
    {
        int userChoice = 0;     // User selection: 1, 2, 3

        Scanner input = new Scanner(System.in);     // Create a Scanner to obtain user input

        do
        {
            System.out.println();     // Create new line space
            System.out.print( "Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: " );
            userChoice = input.nextInt();     // Read user input

            printUserSelection(userChoice);

        }while (userChoice != 3);
    }

    static void printUserSelection (int choice)
    {
        Scanner input = new Scanner(System.in);     // Create a Scanner to obtain user input

        switch(choice)
        {
            case 1:
                System.out.print( "\nEnter a Fahrenheit temperature: " );
                float temperatureFahrenheit = input.nextFloat();     // Fahrenheit temperature
                fahrenheitConversion(temperatureFahrenheit);     //
                break;
            case 2:
                System.out.print( "\nEnter a Celsius temperature: " );
                float temperatureCelsius = input.nextFloat();     // Celsius temperature
                celsiusConversion (temperatureCelsius);
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

    static void fahrenheitConversion (float f)
    {
        // Convert Fahrenheit to Celsius
         float celsius = 5F/9F * (f - 32F);
        System.out.println("\n" + f + " degrees Fahrenheit is " + celsius + " degrees Celsius");
    }

    static void celsiusConversion (float c)
    {
        // Convert Celsius to Fahrenheit
        float fahrenheit = 9F/5F * c + 32F;
        System.out.println("\n" + c + " degrees Celsius is " + fahrenheit + " degrees Fahrenheit");
    }























}


 