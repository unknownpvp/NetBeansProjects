/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8part2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab8Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int base = 0;
        int exp = 0;
        int retry = 0;
        
        System.out.println("Exponential Calculator");
        System.out.println("Please choose values ranging from -32 to 32.");
        
        //error check input from user
        try
        {
            System.out.print("Enter a integer for base: ");
            base = input.nextInt();
            System.out.print("Enter a integer for exponent: ");
            exp = input.nextInt();
            
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Wrong data type or out of range. Please re-try.");
            
        }
        
        //print value
        System.out.println("The value of "+base+" to the power of "+exp+" is: "+power(base,exp));
        
    }
    
    //recursive function for calculating exponential
    public static int power(int base, int exp)
    {
        int result = 0;
        
        if (exp==0)
        {
            return 1;
        }
        else if (exp<0)
        {
            result = base*power(base,exp+1);
        }
        else if (exp>0)
        {
            result = base*power(base,exp-1);
        }
        return result;
    }
    
}
