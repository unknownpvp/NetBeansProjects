/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab7Part1f {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int MAX = 33;
        String[] studentData = new String[MAX];
        double maxGPA = 0;
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
        String maxFirst = " ";
        String maxLast = " ";
        String maxMajor = " ";  
        int i = 0;
        int j = 0;
        boolean invalidData = false;
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
        //set up printwriter to output file
        boolean outFound = false;
        String outputFile = "studentsOut.txt";
        PrintWriter outFile = new PrintWriter(System.out);
        try
        {
            sc = new Scanner(new File("students2.txt"));
            outFile = new PrintWriter(outputFile);
            outFound = true;
        }
        catch (FileNotFoundException fnf)
        {
            outFile = new PrintWriter(System.out);
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
                studentData[0] = sc.next(); //last name
                }
                
                if (sc.hasNext() && sc.hasNext()!=sc.hasNextLong())
                {
                studentData[1] = sc.next(); //first name
                }
                
                if (sc.hasNext())
                {
                    studentData[2] = sc.next(); //utaid
                try
                {
                    
                    a = Long.parseLong(studentData[2]);
                    
                }
                catch (NumberFormatException nfe)
                {
                    invalidData = true;
                    //System.out.println("UTA ID is invalid. ");
                }
                }
                
                if (sc.hasNext())
                {
                sc.useDelimiter("\\s+");    
                studentData[3] = sc.next(); //major
                }
                
                if (sc.hasNext())
                {
                studentData[4] = sc.next(); //classyear
                }
                
                if (sc.hasNext())
                {
                    studentData[5] = sc.next(); //birthdate
                try
                {
                    
                    b = Integer.parseInt(studentData[5]);
                }
                catch (NumberFormatException nfe)
                {
                    invalidData = true;
                    //System.out.println("BirthDate error. ");
                }
                }
                
                if (sc.hasNext())
                {
                    studentData[6] = sc.next(); //gpa
                    
                try
                {
                    
                    c = Double.parseDouble(studentData[6]);
                }
                catch (NumberFormatException nfe)
                {
                    invalidData = true;
                    //System.out.println("GPA error. ");
                }
                }
                
                if (sc.hasNext())
                {
                    studentData[7] = sc.next(); //totalutahours
                try
                {
                    
                    d = Integer.parseInt(studentData[7]);
                }
                catch (NumberFormatException nfe)
                {
                    invalidData = true;
                    //System.out.println("Total UTA hours is invalid. ");
                }
                }
                
                if (sc.hasNext())
                {
                    studentData[8] = sc.next(); //account
                try
                {
                    
                    e = Double.parseDouble(studentData[8]);
                }
                catch (NumberFormatException nfe)
                {
                    invalidData = true;
                    //System.out.println("Account balance error. ");
                }
                }
                
                // check classyear and totalutahours
                if (studentData[4].equals("SPEC") || studentData[4].equals("MS") || studentData[4].equals("PHD") || studentData[4].equals("5TH"))
                {
                    //System.out.println("There is no limit on hours. ");
                    
                }
                else if (studentData[4].equals("FR") && d>=0 && d<=30)
                {
                    
                }
                else if (studentData[4].equals("SO") && d>=31 && d<=60)
                {
                    
                }
                else if (studentData[4].equals("JR") && d>=61 && d<=90)
                {
                    
                }
                else if (studentData[4].equals("SR") && d>90)
                {
                    
                }
                else
                {
                    wrong = "There is a mismatch in the data for class year and hours. ";
                    //System.out.println(wrong);
                }
                
                //check tuition comparing classyear with excessive uta hours
                if ((studentData[4].equals("SR") || studentData[4].equals("5TH")) && d>150)
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
                switch (studentData[4])
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
                    //System.out.println("UTA_ID is invalid. Must be 10 digit number. ");
                }
                if (charMajor<2 && charMajor>4)
                {
                    //System.out.println("Major is invalid. Must be 2,3 or 4 characters. ");
                }
                if (!studentData[4].equals("FR") && !studentData[4].equals("SO") && !studentData[4].equals("JR") && !studentData[4].equals("SR") && !studentData[4].equals("5TH") && !studentData[4].equals("MS") && !studentData[4].equals("PHD") && !studentData[4].equals("SPEC"))
                {
                    //System.out.println("Class_year is invalid. Please specify class year in format of: FR,SR,JR,SR,5TH,MS,PHD or SPEC. ");
                }
                if (c<0.001 && c>4.001) 
                {
                    //System.out.println("GPA error.");
                }
                if (d<0)
                {
                    //System.out.println("UTA hours is invalid. Please take some courses to build up hours. ");
                }
                if (b<9999 || b>999999)
                {
                    //System.out.println("Birthdate error. Please enter in format of MMDDYY with no spaces. EX: 121099. ");
                }
                if (decimalLength==3 && decimalLength>4)
                {
                    //System.out.println("The amount in the account is inaccurate. Please re-enter amount with no more than 2 decimal places. ");
                }
                
                char comma = ',';
                String sp = " ";
                
                //calculating age
                JCMTtime myTime = new JCMTtime();
                currentYear = myTime.getYear();
                birthYear = (b % 100)+1900;
                age = currentYear - birthYear;
                
                
                if (maxGPA<c && c<=4.0)
                {
                    maxGPA=c;
                    maxFirst=studentData[1];
                    maxLast=studentData[0];
                    maxMajor=studentData[3];
                }
                
                
                
                //printing output
                //System.out.println("DEBUG "+classYear);
                /*        
                System.out.println(studentData[1]+sp+studentData[0]+"ID number"+sp+a+comma+
                        "is a "+studentData[3]+sp+"major, and is "+age+" years old with a birthday of "+b+"."
                        +studentData[1]+"'s academic standing is "+standing+" with a "+c+" GPA. "
                        +studentData[1]+" is a "+classYearOutput+" with "+d+" hours. "+wrong+"\n"
                        +tuition+"\n"
                        +studentData[1]+" has an account balance of "+e+" and "+noCharges);*/
                
                //print lastname, firstname, major
                System.out.println("Student data unsorted by lastname, firstname, major: ");
                System.out.println(studentData[0]+" "+studentData[1]+" "+studentData[3]);
                outFile.println(studentData[0]+" "+studentData[1]+" "+studentData[3]);
                
                //print lastname, firstname, birthdate
                System.out.println("Student data unsorted by lastname, firstname, birthdate: ");
                System.out.println(studentData[0]+" "+studentData[1]+" "+b);
                outFile.println(studentData[0]+" "+studentData[1]+" "+b);
                
                
                /*
                sort(studentData);
                for(int k =0;k<33;k++)
                    System.out.println(studentData[k]);
                
                System.out.println();*/
                }
                
                catch (InputMismatchException ime)
                {
                    System.out.println("Error reading from file. ");
                }    
                        
                            
            }
            
        }
        //System.out.println(maxLast+" "+maxFirst+" "+maxMajor+" "+maxGPA);
        //outFile.println(maxLast+" "+maxFirst+" "+maxMajor+" "+maxGPA);
        outFile.close();
    }
    
public static void sort(String[] array)
{
    int j;
    boolean flag = true;
    String temp;
    
    while(flag)
    {
        flag=false;
        for(j=0;j<array.length-1;j++)
        {
            if(array[j].compareTo(array[j+1])>0)
            {
                temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
                flag=true;
            }
        }
    }
}
    
}
