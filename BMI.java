/*

Ryan Breeden
Java 605.201.83
Module 2 Assignment
Question 2

References:
https://www.cdc.gov/healthyweight/assessing/bmi

 */

import java.util.Scanner;

public class BMI
{
    public static void main( String [] args )
    {
        Scanner myBMI = new Scanner(System.in);    // Create a Scanner object

        System.out.println("\n" + "The Department of Health & Human Services / National Institutes of Health BMI Categories include:");
        System.out.println("\t" + "Underweight: less than 18.5");
        System.out.println("\t" + "Normal: 18.5 – 24.9");
        System.out.println("\t" + "Overweight: 25 – 29.9");
        System.out.println("\t" + "Obese: 30 or greater");

        System.out.println("\n" + "Please enter your body weight in pounds: ");
        double weight = myBMI.nextDouble();
        System.out.println("Please enter your body height in inches: ");
        double height = myBMI.nextDouble();

        double weight_in_kilos = weight * 0.45359237;   // Converts pounds to kilograms
        double height_in_meters = height * 0.0254;      // Converts inches to meters

        double totalBMI = weight_in_kilos / (height_in_meters * height_in_meters);

        System.out.println("Your current BMI reading is: " + totalBMI);










    }
}
