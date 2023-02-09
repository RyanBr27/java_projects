package emailapplication;

import java.math.MathContext;
import java.util.Scanner;

public class Email
{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "xyzcompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department+ "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment()
    {
        System.out.println("Welcome, " + firstName + " " + lastName);
        System.out.println("\nDepartmental Codes:\n\n01 - Sales\n02 - Development\n03 - Accounting\n04 - Human Resources\n05 - IT Help Desk\n00 - None");
        System.out.print("\nPlease enter your department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        if (deptChoice == 01) { return "Sales"; }
        else if (deptChoice == 02) { return "dev"; }
        else if (deptChoice == 03) { return "accounting"; }
        else if (deptChoice == 04) { return "hr"; }
        else if (deptChoice == 05) { return "helpdesk"; }
        else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length)
    {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        char[] password = new char[length];
        for (int i=0; i<length; i++)
        {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password)
    {
        this.password = password;
    }

    // Set get operations
    public int getMailboxCapacity()
    {
        return mailboxCapacity;
    }

    public String getAlternateEmail()
    {
        return alternateEmail;
    }

    public String getPassword()
    {
        return password;
    }

    public String showInfo()
    {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD: " + password +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
