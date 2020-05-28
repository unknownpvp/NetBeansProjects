/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part3;

/**
 *
 * @author Danny
 */
public class Lab2Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // code starting here should be put in main
        double x1 = 4;  
        double y1 = 1;
        double x2 = 1; 
        double y2 = 5;  
        double x3, y3;
        int base =  (int) (x1 - x2); // Line 1
        int height = (int) (y1 - y2); // Line 2
        double hypotenuse = Math.sqrt(Math.pow(base,2)+ Math.pow(height,2));
        double area;        
        area = (base * height) / 2;      //  Line 3 - Look up the formula for area and insert it here

        System.out.printf("The base is length %d and the height is %3d \n", base, height);
        System.out.print("The distance between ("+x1+","+y1+") and" );  
        System.out.printf("(%.0f,%2.0f) is %4.1f \n", x2, y2, hypotenuse);
        System.out.print("The area of the right triangle is "+area);

        double circumference = (base + height + hypotenuse);       // Line 4 - Insert correct calculation here and other as needed
        System.out.print("The circumference of the right triangle is "+ circumference);

    }
    
}
