/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part5;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab2Part5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        double height;
        double depth;
        double width;
        double weight;
        
        System.out.print("Please enter 2.0 for height: ");
        height = input.nextDouble();
        System.out.println();
        
        System.out.print("Please enter 0.50 for depth: ");
        depth = input.nextDouble();
        System.out.println();
        
        System.out.print("Please enter 0.75 for width: ");
        width = input.nextDouble();
        System.out.println();
        
        System.out.print("Please enter 4.5 for weight: ");
        weight = input.nextDouble();
        System.out.println();
        
        double boxHeightInFeet = 1.5;
        double boxWidthInFeet = 0.5;
        double boxDepthInFeet = 0.75;
        double boxWeightInKilograms = 4.5;
        
        double boxHeightInInches = Math.ceil(boxHeightInFeet) * 12;
        double boxWidthInInches = (boxWidthInFeet) * 12;
        double boxDepthInInches = (boxDepthInFeet) * 12;
        
        System.out.print("Box height in feet is "+Math.ceil(boxHeightInFeet));
        System.out.println(" and Box height in inches is "+Math.ceil(boxHeightInInches));
        System.out.print("Box width in feet is "+(boxWidthInFeet));
        System.out.println(" and Box width in inches is "+(boxWidthInInches));
        System.out.print("Box depth in feet is "+(boxDepthInFeet));
        System.out.println(" and Box depth in inches is "+(boxDepthInInches));
        
        double boxVolume = boxHeightInInches * boxWidthInInches * boxDepthInInches;
        double boxWeightInLb = boxWeightInKilograms * 2.20;
        double boxWeightKgInch = 0.003472;
        double boxVolumeInches = Math.ceil(boxHeightInFeet) * boxWidthInFeet * boxDepthInFeet;
        System.out.println();
        System.out.printf("Box volume in inches is %.2f\n",boxVolume);
        
        System.out.println();
        System.out.printf("Box weight in Kg is %.2f\n",boxWeightInKilograms);
        System.out.printf("Box weight in Kg per inch is %.6f\n",boxWeightKgInch);
        System.out.printf("Box weight in Lb is %.2f\n",boxWeightInLb);
       
        System.out.println();
        System.out.printf("%10s%10s%10s%10s%10s\n","Unit", "Height", "Width", "Depth", "Volume");
        System.out.printf("%10s%10.1f%10.1f%10.1f%10.1f\n","Inches", (boxHeightInInches), (boxWidthInInches), (boxDepthInInches),(boxVolume));
        System.out.printf("%10s%10.2f%10.2f%10.2f%10.2f\n", "Feet", (Math.ceil(boxHeightInFeet)), (boxWidthInFeet), (boxDepthInFeet), (boxVolumeInches));
        System.out.println();
        System.out.printf("%10s%10s%10s%10s\n", "Weight in", "Pounds", "Kilograms", "Kg per In");
        System.out.printf("%10s%10.4f%10.4f%10.4f\n", " ", boxWeightInLb, boxWeightInKilograms, boxWeightKgInch);
            
           
        
        
        
        
    }
    
}
