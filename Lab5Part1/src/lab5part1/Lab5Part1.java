/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5part1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Danny
 */
public class Lab5Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggingExamples.class.getName());
        logger.setLevel(Level.OFF);  //INFO is on; OFF is off         
        
        Scanner keybd = new Scanner(System.in);
        JCMTtimeMar21 myTime = new JCMTtimeMar21();  //  This value will have the current time in it
        // Lunar module Eagle landed on the moon on July 20, 1969, at 20:18 UTC.
        JCMTtimeMar21 landedTime = new JCMTtimeMar21();
        landedTime.setYear(1969);
        landedTime.setMonth(6);
        landedTime.setDayOfMonth(20);
        landedTime.setMinute(18);
        landedTime.setHourInMil(20);
        // July 21, 1969 at 02:56:15 UTC First person steps on the moon
        JCMTtimeMar21 firstStepTime = new JCMTtimeMar21(1969, 6, 21, 2, 56);  
        
        // 3.a) instantiate the birthTime value with YOUR birth date and time
        JCMTtimeMar21 birthTime = new JCMTtimeMar21(1996,5,2,12,0);
        birthTime.setYear(1996);
        birthTime.setMonth(5);
        birthTime.setDayOfMonth(2);
        birthTime.setMinute(0);
        birthTime.setHourInMil(12);
        
        // If you do not know your birth time, put in noon for the time
        String myName = "Danny Vu"; // and 3.a) initialize this String to YOUR name.
        
        int inMo = -1;
        int inDay = -1;
        int inYr = -1;
        int inHr = -1;
        int inMin = -1;
        
        System.out.println("Please enter the expiration date and time of your coupon.\n");
        System.out.println("The format should be month (space) day (space) year (space) hour (space) min");
        System.out.println("like MM dd yyyy HH mm.  The coupon year must be between 1970 and 2020. ");
        System.out.println("The hour should be in military time from 0 to 23. Invalid values will be ");
        System.out.println("replaced with the current time values. Example: For a coupon that expires one");
        System.out.println("minute before midnight on Halloween the input would be 10 31 2017 23 59.  \n");
        System.out.print("Enter your coupon expiration date and time here: ");
                
        inMo = keybd.nextInt();
        inDay = keybd.nextInt();
        inYr = keybd.nextInt();
        inHr = keybd.nextInt();
        inMin = keybd.nextInt();

        System.out.println("\nYour input was "+inMo +"/"+inDay+"/"+inYr+" at "+inHr+":"+inMin);
        
        
        JCMTtimeMar21 expDate = new JCMTtimeMar21(inMo,inDay,inYr,inHr,inMin); // 3.b) initialize the coupon date with the user's inputs
        
        System.out.println("Your error-checked input is "+expDate.toStringMDYHM());
        
        System.out.println("\nNow we will check if this coupon is still valid and how many\n"
                + "days longer it is valid or that it has been expired. ");
        System.out.println("");
        System.out.println("The current time is "+myTime.toStringMDYHM());  
        
        /* 
            3.d) Call the daysBetween method here using your coupon input in expDate 
            and the current date in myTime
            Print the number of days between that are returned from the method call
        */
        Date date1 = new GregorianCalendar(2017, 7, 12, 3, 20).getTime();
        Date date2 = new Date();
        float days = daysBetween(date1,date2);
        System.out.println("The number of days between August 12, 2017 at 3:20pm and the current date is: "+days);

        System.out.println("Please enter the expiration date and time of your next coupon.\n");
        System.out.println("The format should be month (space) day (space) year (space) hour (space) min");
        System.out.println("like MM dd yyyy HH mm.  If your MM, dd, yyyy, HH, or mm values are out of");
        System.out.println("range, the program will resolve them into valid values and then check the ");
        System.out.print("coupon expiration.  Enter your coupon expiration date and time here: ");
                
        inMo = keybd.nextInt();
        inDay = keybd.nextInt();
        inYr = keybd.nextInt();
        inHr = keybd.nextInt();
        inMin = keybd.nextInt();

        System.out.println("\nYour input was "+inMo +"/"+inDay+"/"+inYr+" at "+inHr+":"+inMin);        
        
        /* 
            3.f) Call the method dateResolution here using the inputs read from the user and assign
            the resulting JCMTtime value to the object expDate.  
        */
        
        //expDate = dateResolution(inMo,inDay,inYr,inHr,inMin);  // call dateResolution and assign it to expDate
        
        System.out.println("Your error-checked and resolved input is "+expDate.toStringMDYHM());        
        
        System.out.println("\nNow we will check if this 2nd coupon is still valid and how many\n"
                + "days longer it is valid or that it has been expired. ");
        System.out.println("");
        System.out.println("The current time is "+myTime.toStringMDYHM());        
        /* 
            3.g) Call the daysBetween method here using your coupon input in expDate 
            and the current date in myTime
            Print the number of days between that are returned from the method call
        */  
        
        float days2 = daysBetween(date1,date2);
        System.out.println("The number of days between the coupon and current date is: "+days2);
        // after calling daysBetween and printing its output then print:
        System.out.println("");
        System.out.println("The Eagle lunar module landed on the moon at "+landedTime.toStringMDYHM());
        System.out.println("The first person, Neil Armstrong, stepped on the moon at "+firstStepTime.toStringMDYHM());
        System.out.println("The birth date and time of "+myName+" is "+
                birthTime.getMonthName() +" "+birthTime.getDayOfMonth()+", "+
                birthTime.getYear()+" at "+birthTime.getYear()+":"+
                twoPlaces(birthTime.getMinute())); 
    }
    // 3.d) Write the method daysBetween here
    static public float daysBetween(Date date1, Date date2)
    {
       float days = 0;
       days = (float)((date1.getTime() - date2.getTime())/(1000*60*60*24));
       return days;
    }
    
    // 3.f) Write the method dateResolution here
    static public int dateResolution(int inMo, int inDay, int inYr, int inHr, int inMin)
    {
       int Mo = 0;
       int Day = 0;
       int Yr = 0;
       int Hr = 0;
       int Min = 0;
       int Sec = 0;
       int mm = 0;
       int hh = 0;
       int MM = 0;
       int yyyy = 0;
       int dd = 0;
       int expDate = 0;
       
       if (inMin > 59)
       {
           mm = inMin - 60;
           hh += 1;
           mm = inMin;
           //return mm;
           //return inMin;
       }
       else 
       {
           return inMin;
       }
       if (inHr > 23)
       {
           hh = inHr / 24;
           inHr += hh;
          // return inHr;
       }
       else
       {
           return inHr;
       }
       if (inMo > 11)
       {
           MM = inMo / 12;
           inMo += MM;
           //return inMo;
       }
       else 
       {
           return inMo;
       }
       if (inDay > 31)
       {
           dd = inDay - 31;
           inDay += dd;
           //return inDay;
       }
       else
       {
           return inDay;
       }
       if (inYr > 0)
       {
           ;
       }
       else
       {
           ;
       }
           return inYr;
    }
    
    /**
     * Write a method that prints the minutes properly when the value is 
     * less than 10.  
     * This means that your method will take in HH and mm of 3 and 4 
     * and output 3:04 NOT 3:4.  
     * 
     */
    static public String twoPlaces(int min)
    {
        String mins = "";
        // 3.h) make the correct string here to print the minutes
        if (min < 10)
        {
            mins = "0";
        }
        return mins + min;
    }
    
}
