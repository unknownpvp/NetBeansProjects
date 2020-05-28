/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1part4;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
/*
Scanner myscanner = new Scanner(System.in);
int a;
int b;
System.out.println("Please enter a number");
a = myscanner.nextInt();
System.out.print("Please enter another number");
b = myscanner.nextInt();
double c = Math.pow(a,b);
System.out.println("Value ="+c);
*/
public class Lab1Part4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myscanner = new Scanner(System.in);
int a;
int b;
//System.out.println("Please enter a number");
a = myscanner.nextInt();
System.out.print("Please enter another number");
b = myscanner.nextInt();
double c = Math.pow(a,b);
System.out.println("Value ="+c);

    }
    
}
