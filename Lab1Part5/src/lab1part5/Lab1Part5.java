/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1part5;

/**
 *
 * @author Danny
 */
public class Lab1Part5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       int radius = 6;
       double pi4places = 3.1415;
       
       double area;
       double circumference;
       
       circumference = 2 * pi4places * radius;
       System.out.print("The circumference of a circle is: " +circumference);
       System.out.println();
       
       area = pi4places * Math.pow(radius,2);
       System.out.print("The area of a circle is: " +area);
       System.out.println();
        
    }
    
}
