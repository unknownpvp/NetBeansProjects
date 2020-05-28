/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1part6;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab1Part6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        int radius = 6;
        double pi4places = 3.1415;
        double area;
        double circumference;
    
        System.out.print("Please enter a value: ");
        radius = input.nextInt();
        area = pi4places * radius * radius;
        System.out.println("Radius value is: "+radius);
        
        area = pi4places * Math.pow(radius,2);
        System.out.println("The area of a circle is: "+area);
        
        circumference = 2 * pi4places * radius;
        System.out.println("The circumference of a circle is: "+circumference);

    }
    
}
