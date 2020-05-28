/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab7Part1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age = 0;
        int currentYear = 0;
        int birthYear = 0;
        int charMajor = 0;
        String firstName = " ";
        String lastName = " ";
        long utaID = -1;
        String major = " ";
        String classYear = " ";
        int birthDate = 0;
        double gpa = 0;
        int totalUTAhours = 0;
        double account = 0;
        String classYearOutput = " ";
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner sc = new Scanner(System.in);
        boolean fileFound = false;
        try
        {
            sc = new Scanner(new File("students2.txt"));
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
                String studentData = sc.nextLine();
                Scanner s = new Scanner(studentData).useDelimiter("\\s");
                
                if (s.hasNext())
                {    
                lastName = s.next();
                }
                if (s.hasNext() && s.hasNext()!=s.hasNextLong())
                {
                s.useDelimiter("\t");    
                firstName = s.next();
                }
                if (s.hasNextLong())
                {
                s.useDelimiter("1");
                utaID = s.nextLong();
                }
                if (s.hasNext())
                {
                s.useDelimiter("\\s+");    
                major = s.next();
                }
                if (s.hasNext())
                {
                classYear = s.next();
                }
                if (s.hasNextInt())
                {
                birthDate = s.nextInt();
                }
                if (s.hasNextDouble())
                {
                gpa = s.nextDouble();
                }
                if (s.hasNextInt())
                {
                totalUTAhours = s.nextInt();
                }
                if (s.hasNextDouble())
                {
                account = s.nextDouble();
                }
                
                
                double decimalLength = (df.format(account).length()-1);
                
                String standing;
                if (gpa<2.0 && totalUTAhours<30)
                {
                    standing = "On Probation";
                }
                if (gpa<2.0 && totalUTAhours>=30)
                {
                    standing = "On Dismissal";
                }
                if (gpa<2.25 && totalUTAhours>=30)
                {
                    standing = "On Probation";
                }
                else
                {
                    standing = "Good";
                }
                    
                
                switch (classYear)
                {
                    case "FR": classYearOutput = "freshmen";
                    break;
                    case "SO": classYearOutput = "sophomore";
                    break;
                    case "JR": classYearOutput = "junior";
                    break;  
                    case "SR": classYearOutput = "senior";
                    break;
                    case "5th": classYearOutput = "second baccalaureate student";
                    break;
                    case "MS": classYearOutput = "master's student";
                    break;
                    case "PHD": classYearOutput = "doctoral student";
                    break;
                    case "SPEC": classYearOutput = "Special Student";
                    break;
                    
                }
                
                //error checking
                if (utaID<1000000000 || utaID>9999999999L)
                {
                    System.out.println("UTA_ID is invalid. Must be 10 digit number. ");
                }
                if (charMajor<2 && charMajor>4)
                {
                    System.out.println("Major is invalid. Must be 2,3 or 4 characters. ");
                }
                if (!classYear.equals("FR") && !classYear.equals("SO") && !classYear.equals("JR") && !classYear.equals("SR") && !classYear.equals("5TH") && !classYear.equals("MS") && !classYear.equals("PHD") && !classYear.equals("SPEC"))
                {
                    System.out.println("Class_year is invalid. Please specify class year in format of: FR,SR,JR,SR,5TH,MS,PHD or SPEC. ");
                }
                if (gpa<0.001 && gpa>4.001) 
                {
                    System.out.println("GPA error.");
                }
                if (totalUTAhours<0)
                {
                    System.out.println("UTA hours is invalid. Please take some courses to build up hours. ");
                }
                if (birthDate<9999 || birthDate>999999)
                {
                    System.out.println("Birthdate error. Please enter in format of MMDDYY with no spaces. EX: 121099. ");
                }
                if (decimalLength==3 && decimalLength>4)
                {
                    System.out.println("The amount in the account is inaccurate. Please re-enter amount with no more than 2 decimal places. ");
                }
                
                char comma = ',';
                String sp = " ";
                
                JCMTtime myTime = new JCMTtime();
                currentYear = myTime.getYear();
                birthYear = (birthDate % 100)+1900;
                age = currentYear - birthYear;
                
                System.out.println(firstName+sp+lastName+"ID number"+sp+utaID+comma+
                        "is a "+major+sp+"major with "+totalUTAhours+sp+"hours and a "
                        +gpa+sp+"GPA. "+firstName+" academic standing is "+standing+"."+sp+firstName+" is a "+classYearOutput+",is "
                        +age+" years old with a birthday of "
                        +birthDate+" and has an account balance of "+account);
                System.out.println();
                }
                
                catch (InputMismatchException e)
                {
                    System.out.println("Error reading from file. ");
                }    
                        
                            
            }
            
        }
    }
    
}
