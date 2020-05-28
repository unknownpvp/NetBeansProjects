/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1part3;

/**
 *
 * @author Danny
 */
public class Lab1Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        //Correctly convert a Celcius temperature to a Fahrenheit temperature
        double celsTemp;
        celsTemp = 35;
        System.out.println("The Celsius temp is "+celsTemp);
        double fahrTemp;
        fahrTemp = celsTemp *9/5 +32;
        System.out.println("and the converted Fahrenheit temp is "+fahrTemp);
        System.out.println();
        System.out.println();
        float cell = 33;
        cell *= 9;
        cell /= 5;
        cell += 32;
        System.out.println("cell is: "+cell);
       

        
    }
    
}
