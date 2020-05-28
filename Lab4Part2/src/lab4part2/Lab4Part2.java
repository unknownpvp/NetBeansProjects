/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab4Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sign = "";
        String dayOfWeekName;
        String monthName;
        String dayNumber;
        int year;
        int dayOfMonth;
        int monthNumber;
        String dateFile;

        System.out.println(); 
        System.out.println("This program reads birthdates"
                + "from a file in the form of "
                + "\"Tuesday February 21, 2017\".\n  "
                + "and then determines the zodiac sign of this birthdate.\n\n"
                + "Please enter the name of your input file (with no blanks) :  ");

        dateFile = input.next();
        System.out.println();
        
        boolean fileFound = false;
        File datesFile = new File("dates.txt");  // connect this File object to the users input
        Scanner inFile = new Scanner(System.in);  // initialize this Scanner
        try
        {   // Connect inFile to the input data file
            //inFile =
            inFile = new Scanner(new File("dates.txt"));
            fileFound = true;
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println("Input file "+dateFile+" not found");
        }
        
        boolean outFound = false;
        String outputFile = "signOutput.txt";
        PrintWriter outFile = new PrintWriter(System.out);
        // use a try-catch to connect the output file to the Printwriter object
        
        try
        {     
            inFile = new Scanner(datesFile);
            outFile = new PrintWriter(outputFile);
        }
        catch (FileNotFoundException fnf)
        {
            //inFile = new Scanner(System.in);
            outFile = new PrintWriter(System.out);
        }
        
       
        if (fileFound)
        {
            while (inFile.hasNext())
            {   
                dayOfWeekName = inFile.next();
                monthName  = inFile.next();
                dayNumber = inFile.next();
                // What was read in for dayNumber?
                // What does makeNum do?
                dayOfMonth = makeNum(dayNumber);
                year = inFile.nextInt();
                // Use a method to find the month number from the month name                
                monthNumber = findMoNum(monthName);
                // Print the numeric format then                
                System.out.println("You entered "+monthNumber+"/"+dayOfMonth+"/"+year);
                outFile.println("You entered "+monthNumber+"/"+dayOfMonth+"/"+year);
                // Use a method to find the astrological sign of the birthdate                 
                sign = findSign(monthNumber, dayOfMonth);
                // Return the sign and print that                
                System.out.println("This date's astrological sign is "+sign);
                outFile.println("This date's astrological sign is "+sign);
                System.out.println();
                // if the output file was found, then output the same info
                // to the PrintWriter output file
            }
        }
        outFile.close();
        // if the output file was found, close the file here
    }
    
    public  static int makeNum(String numCm)
    {   int num = numCm.length();
        String tNum = numCm.substring(0,num-1);
        try
        {
            num = Integer.parseInt(tNum);
        }
        catch (InputMismatchException im)
        {
            num = 0;
        }
        return num;
    }
    
    public static int findMoNum(String moName)
    {
        int moNum = 0;
        
        // Assume that for any string input, the user might enter 
        // the first three letters as an abbreviation or the entire word and 
        // the entire word might be capitalized or not and
        // the abbreviation could be capitalized or not, and 
        // with a period or not.  For example, the word "giraffe" could be 
        // entered as "Gir.", "gir.", "Gir", "gir", "Giraffe", or "giraffe"
        // Write the needed code to accept the input String and find the 
        // correct number to go with the String
        if (moName.equalsIgnoreCase("January"))
        {
            return 1;
        }
        if (moName.equalsIgnoreCase("February"))
        {
            return 2;
        }
        if (moName.equalsIgnoreCase("March"))
        {
            return 3;
        }
        if (moName.equalsIgnoreCase("April"))
        {
            return 4;
        }
        if (moName.equalsIgnoreCase("May"))
        {
            return 5;
        }
        if (moName.equalsIgnoreCase("June"))
        {
            return 6;
        }
        if (moName.equalsIgnoreCase("July"))
        {
            return 7;
        }
        if (moName.equalsIgnoreCase("August"))
        {
            return 8;
        }
        if (moName.equalsIgnoreCase("September"))
        {
            return 9;
        }
        if (moName.equalsIgnoreCase("October"))
        {
            return 10;
        }
        if (moName.equalsIgnoreCase("November"))
        {
            return 11;
        }
        if (moName.equalsIgnoreCase("December"))
        {
            return 12;
        }
        
        return moNum;
        
    }
    
    public static String findSign(int mo, int day)
    {    
        String sign = "Unclear";
        // error checking for valid month and day in month
        mo = moDayCheck(mo,day);        
        
       
        // Look up the zodiac signs and use them to fill in the switch below
        // One sign is shown below
        switch (mo)
        {
            case 12: 
                if ((mo == 11) || (day <= 21))
                    return "Sagittarius";
            case 11: 
                if ((mo == 10) || (day <= 21))
                    return "Scorpio";
            case 10:
                if ((mo == 9) || (day <= 22))
                    return "Libra";
            case 9:
                if ((mo == 8) || (day <= 22))
                    return "Virgo";
            case 8:
                if ((mo == 7) || (day <= 22))
                    return "Leo";
            case 7:
                if ((mo == 6) || (day <= 22))
                    return "Cancer";
            case 6:
                if ((mo == 5) || (day <= 20))
                    return "Gemini";
            /*case 5:
                if ((mo == 4) || (day <= 20))
                    return "Taurus";*/
            case 4:
                if ((mo == 3) || (day <= 19))
                    return "Aries";   
            case 5:
                if ((mo == 4) || (day <= 20))
                    return "Taurus";    
            case 3:
                if ((mo == 2) || (day <= 20))
                    return "Pisces";
            case 2: 
                if ((mo == 1) || (day <= 18))
                    return "Aquarius";
            case 1:
                if ((mo == 12) || (day <= 19))
                    return "Capricorn";
            case 0:
                System.out.println("This date is invalid.");                
        }
        return sign;
    }
    
    public static int moDayCheck(int mo, int day)
    {
        
        if (mo > 12)
        {
           mo = 0;// return 0;
        }
        else 
        {
            return mo;
        }
        if ((mo == 1) || (mo == 3) || (mo == 5) || (mo == 7) || (mo == 8) || (mo == 10) || (mo == 12) && (day <= 31))  
        {
           mo = 0;// return 0;
        }
        else
        {
            return mo;
        }
        if ((mo == 9) || (mo == 4) || (mo == 6) || (mo == 11) && (day <= 30))
        {
            mo = 0;//return 0;
        }
        else
        {
            return mo;
        }
        if ((mo == 2) && (day <= 28))
        {
            return 0;
        }
        else 
        {
            return mo;
        }
        
    }
     // Write method moDayCheck that takes in the month and day
    // as input parameters.  It should check for the validity of 
    // the day and month as given below.  Use the algorithm for 
    // checking date to write the method.
    // If the date is invalid the method should return a value of 0. 
    // Otherwise return the month value that was passed in.

    // Valid dates:
    // 12 months in a year Jan (1) to Dec (12)
    // 31 days Jan., Mar., May, Jul., Aug., Oct., Dec.        
    // 30 days Sept., April, June, Nov.
    // 28 days Feb. (ignoring leap year)


    // Algorithm for checking date
    // if month is NOT a valid number, then
    //    set mo to 0
    // else check if day is invalid for any month.  if so, then
    //    set mo to 0
    // else if mo is Feb and day is too large, then
    //    set mo to 0
    // else if there are more than 30 days and mo is Sep, Apr, Jun, or Nov,
    //    set mo to 0
    // return mo
}
