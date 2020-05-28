/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1d;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab7Part1d {

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
        String utaID = " ";
        String major = " ";
        String classYear = " ";
        String birthDate = " ";
        String gpa = " ";
        String totalUTAhours = " ";
        String account = " ";
        String classYearOutput = " ";
        String noCharges = " ";
        String wrong = " ";
        String tuition = " ";
        long a = -1;
        int b = 0;
        double c = 0;
        int d = 0;
        double e = 0;
        boolean valid = true;
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(",\\s*");
        boolean fileFound = false;
        //set up file
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
                // take data in as strings and parses
                if (sc.hasNext())
                {    
                sc.useDelimiter("\t");    
                lastName = sc.next();
                }
                
                if (sc.hasNext() && sc.hasNext()!=sc.hasNextLong())
                {
                firstName = sc.next();
                }
                
                if (sc.hasNext())
                {
                try
                {
                    utaID = sc.next();
                    a = Long.parseLong(utaID);
                    
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("UTA ID is invalid. ");
                }
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
                
                if (sc.hasNext())
                {
                try
                {
                    birthDate = sc.next();
                    b = Integer.parseInt(birthDate);
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("BirthDate error. ");
                }
                }
                
                if (sc.hasNext())
                {
                try
                {
                    gpa = sc.next();
                    c = Double.parseDouble(gpa);
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("GPA error. ");
                }
                }
                
                if (sc.hasNext())
                {
                try
                {
                    totalUTAhours = sc.next();
                    d = Integer.parseInt(totalUTAhours);
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("Total UTA hours is invalid. ");
                }
                }
                
                if (sc.hasNext())
                {
                try
                {
                    account = sc.next();
                    e = Double.parseDouble(account);
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("Account balance error. ");
                }
                }
                
                // check classyear and totalutahours
                if (classYear.equals("SPEC") || classYear.equals("MS") || classYear.equals("PHD") || classYear.equals("5TH"))
                {
                    //System.out.println("There is no limit on hours. ");
                    
                }
                else if (classYear.equals("FR") && d>=0 && d<=30)
                {
                    
                }
                else if (classYear.equals("SO") && d>=31 && d<=60)
                {
                    
                }
                else if (classYear.equals("JR") && d>=61 && d<=90)
                {
                    
                }
                else if (classYear.equals("SR") && d>90)
                {
                    
                }
                else
                {
                    wrong = "There is a mismatch in the data for class year and hours. ";
                    //System.out.println(wrong);
                }
                
                //check tuition comparing classyear with excessive uta hours
                if ((classYear.equals("SR") || classYear.equals("5TH")) && d>150)
                {
                    tuition = "You are subject to non-resident tuition for excessive hours. ";
                    //System.out.println("You are subject to non-resident tuition for excessive hours. ");
                }
                
                //check charges based on account balance either positive or negative
                if (e>=0)
                {
                    noCharges = "has no outstanding charges at this time. ";
                    //System.out.println(noCharges);
                }
                else
                {
                    noCharges = "owe $"+e+" amount of money. ";
                    //System.out.println(noCharges);
                }
                
                //error check to atleast two decimal places for account
                double decimalLength = (df.format(e).length()-1);
                
                //check standing of student from gpa
                String standing;
                if (c<2.0 && d<30)
                {
                    standing = "On Probation";
                }
                if (c<2.0 && d>=30)
                {
                    standing = "On Dismissal";
                }
                if (c<2.25 && d>=30)
                {
                    standing = "On Probation";
                }
                else
                {
                    standing = "Good";
                }
                    
                //checks classyear and swaps abbreviation to full word
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
                if (a<1000000000 || a>9999999999L)
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
                if (c<0.001 && c>4.001) 
                {
                    System.out.println("GPA error.");
                }
                if (d<0)
                {
                    System.out.println("UTA hours is invalid. Please take some courses to build up hours. ");
                }
                if (b<9999 || b>999999)
                {
                    System.out.println("Birthdate error. Please enter in format of MMDDYY with no spaces. EX: 121099. ");
                }
                if (decimalLength==3 && decimalLength>4)
                {
                    System.out.println("The amount in the account is inaccurate. Please re-enter amount with no more than 2 decimal places. ");
                }
                
                char comma = ',';
                String sp = " ";
                
                //calculating age
                JCMTtime myTime = new JCMTtime();
                currentYear = myTime.getYear();
                birthYear = (b % 100)+1900;
                age = currentYear - birthYear;
                
                //printing output
                //System.out.println("DEBUG "+classYear);
                System.out.println(firstName+sp+lastName+"ID number"+sp+a+comma+
                        "is a "+major+sp+"major, and is "+age+" years old with a birthday of "+b+"."
                        +firstName+"'s academic standing is "+standing+" with a "+c+" GPA. "
                        +firstName+" is a "+classYearOutput+" with "+d+" hours. "+wrong+"\n"
                        +tuition+"\n"
                        +firstName+" has an account balance of "+e+" and "+noCharges);
                System.out.println();
                }
                
                catch (InputMismatchException ime)
                {
                    System.out.println("Error reading from file. ");
                }    
                        
                            
            }
            
        }
    }
    
}
