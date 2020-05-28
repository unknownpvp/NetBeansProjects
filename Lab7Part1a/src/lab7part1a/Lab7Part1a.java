/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab7Part1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String firstName = " ";
        String lastName = " ";
        long utaID = -1;
        String major = " ";
        String classYear = " ";
        int birthDate = 0;
        double gpa = 0;
        int totalUTAhours = 0;
        double account = 0;
        int age = 0;
        int currentYear = 0;
        int birthYear = 0;
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(",\\s*");
        boolean fileFound = false;
        try
        {
            sc = new Scanner(new File("students1.txt"));
            fileFound = true;   
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println("No input file was found.");
        }
        
        if (fileFound)
        {
            while (sc.hasNext())
            {
                try
                {   
                System.out.println();    
                if (sc.hasNext())
                {    
                lastName = sc.next();
                }
                if (sc.hasNext())
                {
                sc.useDelimiter("\t");    
                firstName = sc.next();
                }
                if (sc.hasNextLong())
                {
                sc.useDelimiter("1");
                utaID = sc.nextLong();
                }
                if (sc.hasNext())
                {
                sc.useDelimiter("\\s+");    
                major = sc.next();
                }
                if (sc.hasNext())
                {
                classYear = sc.next();
                }
                if (sc.hasNextInt())
                {
                birthDate = sc.nextInt();
                }
                if (sc.hasNextDouble())
                {
                gpa = sc.nextDouble();
                }
                if (sc.hasNextInt())
                {
                totalUTAhours = sc.nextInt();
                }
                if (sc.hasNextDouble())
                {
                account = sc.nextDouble();
                }
                char comma = ',';
                String sp = " ";
                
                JCMTtime myTime = new JCMTtime();
                currentYear = myTime.getYear();
                birthYear = (birthDate % 100)+1900;
                age = currentYear - birthYear;
                
                System.out.println(firstName+sp+lastName+"ID number"+sp+utaID+comma+
                        "is a "+major+sp+"major with "+totalUTAhours+sp+"hours and a "
                        +gpa+sp+"GPA. "+firstName+" is a "+classYear+comma+" is "+age+" years old with a birthday of "
                        +birthDate+" and has an account balance of "+account);
   
                }
                
                catch (InputMismatchException e)
                {
                    System.out.println("Error reading from file. ");
                }    
                        
                            
            }
            
        }
        
        
    }
    
}
