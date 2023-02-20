/*

Ryan Breeden
February 17th, 2023
Java 605.201.83
Module 4 Assignment - Question 2

 */

// Import the scanner class
import java.util.Scanner;

public class printCalendarQ2
{
    public static void main(String[] args)
    {
        // Variables
        int year, month = 0;

        // Use a Scanner to input integer values
        Scanner input = new Scanner( System.in );

        // New line space
        System.out.println();

        // Prompt user to enter year
        System.out.print("Please enter a year (e.g., 2023) to display all of its monthly calendars: ");
        year = input.nextInt();

        // Print calendar for the month of the year
        printMonthCalendar(year, month);
    }

    // Print a calendar for the months in a given year
    static void printMonthCalendar(int yr, int mon)
    {
        // Sets For Loop to print monthly calenders in a chosen year
        int MonsInYear = 12;
        for (mon = 1; mon <= MonsInYear; mon++)
        {
            int d = 1;     // Set day variable
            int startDay = getStartDay(mon, d, yr);
            int numDaysInMo = getNumDaysInMonth(yr, mon);
            printMonthHeader(yr, mon);
            printMonthBody(startDay, numDaysInMo);
        }
    }

    // Implements Zeller's Algorithm for determining the day of the week the first day of a month is
    static int getStartDay(int m, int d, int y)
    {
        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3)
        {
            m = m + 12;
            y = y - 1;
        }

        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'

        h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
                ( 5 * j ) ) % 7;

        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;

        return dayNum;
    }

    // Get number of days in the month
    static int getNumDaysInMonth(int yr, int mon)
    {
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 ||        // Catches all months with 31 days
                mon == 8 || mon == 10 || mon == 12)
        {
            return 31;
        }

        if (mon == 4 || mon == 6 || mon == 9 || mon == 11)         // Catches all months with 30 days
        {
            return 30;
        }

        if (mon == 2) return isLeapYear(yr) ? 29 : 28;       // If leap year, returns 29 days, or else 28 days

        return 0;
    }

    // Returns true or false if the year is a leap year or not
    static boolean isLeapYear(int yr)
    {
        // If the year is evenly divisible by 4 and not by 100, or is evenly divisible by 400, the year is a leap year
        boolean equalLeapYear = (yr % 4 == 0 && yr % 100 != 0 || yr % 400 == 0);

        if(equalLeapYear == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Print headings
    static void printMonthHeader(int yr, int mon)
    {
        System.out.println();
        System.out.print("\t\t" + getMonthName(mon) + " " + yr);
        System.out.println();
        System.out.print("-----------------------------");
        System.out.println();
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
    }

    // Print body
    static void printMonthBody(int startDay, int daysInMon)
    {
        // Pad space before the first day of the month
        // Initializes "i" as the counter of spaces before startDay
        int i;
        for (i = 0; i < startDay; i++)
        {
            // If start day is Sunday, no spaces are needed to start the month
            if (startDay == 7)
            {
                System.out.print("");
            }
            else
            {
                System.out.print("    ");
            }
        }
        for (i = 1; i <= daysInMon; i++)
        {
            // Adjust spacing to right-align single-digit numbers
            if (i < 10)
            {
                System.out.print("   " + i);
            }
            //Adjust spacing to right-align double-digit numbers
            else
            {
                System.out.print("  " + i);
            }
            // Starts new line after Saturday
            if ((i + startDay) % 7 == 0)
            {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Returns the name of the month for a specified month number
    static String getMonthName(int monOrderNum)
    {
        String monthName = "";

        switch (monOrderNum)
        {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }
}
