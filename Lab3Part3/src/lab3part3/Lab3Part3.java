/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3part3;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab3Part3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        double price = 0;
        int quantity = 0;
        int itemCount = 0;
        double groceryBill = 0;
        double total = 0;
        int highestPrice = 0;
        int largestQuantity = 0;
        
        System.out.println("Please enter the value -1 for price & quantity to terminate the program. ");
        
        do    
        {  
        itemCount++;   
        total = price * quantity;
        System.out.print("Please enter a double for price and a integer for quantity: ");
        price = input.nextDouble();
        quantity = input.nextInt();
        
        
            if (price >= 0)
            {
                System.out.println("Price is a positive value. ");
            }    
            else
            {
                System.out.println("Invalid. Price cannot be negative. Try again. ");
            }    
            
            if (quantity >= 0)
            {
                System.out.println("Quantity is a positive value. ");
            }    
            else
            {
                System.out.println("Invalid. Quantity cannot be negative. Try again. ");
            }  
        
            if (total > 0)
            {
                groceryBill += total;
            }   
            
            if (price > highestPrice)
            {
                highestPrice = (int)price;
            }
            
            if (quantity > largestQuantity)
            {
                largestQuantity = quantity;
            }
            System.out.println();
           
        }   
        
        while (price != -1);
        System.out.println("The running sum is: "+groceryBill);
        System.out.println("You entered this many prices: "+itemCount);
        System.out.println("The highest price entered was: "+highestPrice);
        System.out.println("The largest quantity entered was: "+largestQuantity);
        
    }
    
}
