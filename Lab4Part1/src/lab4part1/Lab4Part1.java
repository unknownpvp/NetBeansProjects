/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;


import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab4Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Change the names below to better, more meaningful names for the 
        // variables 
        String month; // 'month' was previously 'moth'
        String weekDay;  // 'weekDay' was previously 'a'
        int numYear; // 'numYear' was previously 'ear'
        int numDate = 0; // 'numDate' was previously 'aBer'
        int numCount = 0; // 'numCount' was previously 'count'
        int monthCount = 0; // 'monthCount' was previously 'mthct'
    
         

        System.out.println("Give a date input in the form of "
                + "\"Tuesday February 21 2017\".\n  "
                + "If finished, enter \"Done\" :  ");
        
        weekDay = input.next();
        
   
        // Fill in the needed control statement and test condition so that 
        // the program can read multiple date inputs from the user
        while (!(weekDay.equalsIgnoreCase("Done"))) 
        {   
            
            
            month = input.next();
            numDate = input.nextInt();
            numYear = input.nextInt(); 
            
           
            // Fill in the variable that should be used to control the switch
            switch (month)      
            { 
                // Complete the missing case statements for April and June.
                // Add the missing action in the May case.
                // How many possible categories of cases would there 
                //     be for this switch where May, may, and MAY are
                //     considered to be all ONE category?              
                
                // Add ALL the other needed cases to complete the switch 
                //    using the statements below as the outputs.
                // Thirty days hath September
                // Born on the 4th of July
                // Slow as molasses in January
                // March of the Penguins
                // Augustus Caesar
                // November, n. The eleventh twelfth of a weariness.
                // Try to remember the kind of September
                // October Sky
                // It is December, and nobody asked if I was ready
                // February is merely as long as is needed to pass the time until March
                case "january":
                case "JANUARY":
                case "January":
                    System.out.println("Slow as molasses in January");
                    monthCount = 1;
                    break;
                case "February":
                case "FEBRUARY":
                case "february":
                    System.out.println("February is merely as long as is needed to pass the time until March");
                    monthCount = 2;
                    break;
                case "March":
                case "MARCH":
                case "march":
                    System.out.println("March of the Penguins");
                    monthCount = 3;
                    break;
                case "April":  
                case "april":
                case "APRIL":       
                    System.out.println("April showers");
                    monthCount = 4;
                    break;
                case "may":  
                case "MAY":
                case "May" : 
                    System.out.println("The merry month of May");
                    monthCount = 5;
                    break;
                case "June":
                case "JUNE":
                case "june":    
                    System.out.println("Moon, swoon, June");
                    monthCount = 6;
                    break;
                case "july":
                case "JULY":
                case "July":
                    System.out.println("Born on the 4th of July");
                    monthCount = 7;
                    break;       
                case "August":
                case "AUGUST":
                case "august":
                    System.out.println("Augustus Caesar");
                    monthCount = 8;
                    break;
                case "September":
                case "SEPTEMBER":
                case "september":
                    System.out.println("Thirty days hath Septermber");
                    System.out.println("Try to remember the kind of September");
                    monthCount = 9;
                    break;
                case "October":
                case "OCTOBER":
                case "october":
                    System.out.println("October Sky");
                    monthCount = 10;
                    break;
                case "November":
                case "NOVEMBER":
                case "november":
                    System.out.println("November, n. The eleventh twelfth of a weariness");
                    monthCount = 11;
                    break;
                case "December":
                case "DECEMBER":
                case "december":
                    System.out.println("It is December, and nobody asked if I was ready");
                    monthCount = 12;
                    break;
                default : System.out.println("Not a month");
                    break;
            }              
            
            System.out.println("Give a date input in the form of "
                    + "\"Tuesday February 21 2017\".\n  "
                    + "If finished, enter \"Done\" :  ");

            
            weekDay = input.next();
            numCount++;  
           
        }
    
        // Write a meaningful message in the output statement below with count
        System.out.println("The amount of dates you entered was: "+numCount);         
    }
    
}
