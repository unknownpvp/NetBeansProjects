/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab6Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lastName;
        double t1, t2, tFinal, hw1, hw2, hw3, hw4, hw5, hw6, q1, q2;
        int hwCount = 0;
        String firstName;
     
        boolean fileFound = false;
        File gradeFile = new File("grades1.txt");
        Scanner inFile = new Scanner(System.in);
        try
        {
            inFile = new Scanner(new File("grades1.txt"));
            fileFound = true;
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println("No input file was found.");
        }
        System.out.println("The grades for each student appear accordingly to: test1/test2/final/hw1/hw2/hw3/hw4/hw5/hw6/quiz1/quiz2 ");
        System.out.println();
       
        double sumT=0;
        double max=0;
        double min=10000;
       
        if (fileFound)
        {
            while (inFile.hasNext())
            {
                try
                {
                lastName = inFile.next();
                t1 = inFile.nextDouble();
                t2 = inFile.nextDouble();
                tFinal = inFile.nextDouble();
                hw1 = inFile.nextDouble();
                hw2 = inFile.nextDouble();
                hw3 = inFile.nextDouble();
                hw4 = inFile.nextDouble();
                hw5 = inFile.nextDouble();
                hw6 = inFile.nextDouble();
                q1 = inFile.nextDouble();
                q2 = inFile.nextDouble();
                hwCount = inFile.nextInt();
                firstName = inFile.nextLine();
                char colon = ':';
                char comma = ',';
                String sp = " ";
                String output;
             
                double tGrade = finalsGrade(t1,t2,tFinal,hw1,hw2,hw3,hw4,hw5,hw6,q1,q2,hwCount);
                output = lastName+comma+firstName+colon+sp+tGrade;
                System.out.println("Student's grades: "+t1+"/"+t2+"/"+tFinal+"/"+hw1+"/"+hw2+"/"+hw3+"/"+hw4+"/"+hw5+"/"+hw6+"/"+q1+"/"+q2);
               
                System.out.println(output);
               
                double total = 0;
                double classAvg= 0;
                for (int x=0;x<33;x++)
                {
                    total += tGrade;
                }
                //System.out.println("Class Average: "+total);
                System.out.println();    
               
                sumT += finalsGrade(t1,t2,tFinal,hw1,hw2,hw3,hw4,hw5,hw6,q1,q2,hwCount);
               
                if(max<tGrade)
                {
                    max=tGrade;
                }
                if(min>tGrade)
                {
                    min=tGrade;
                }
             
               
               
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Error grade is invalid");
                }
               
            }
               
           
                double classA = 0;
                classA=sumT/33;
                System.out.println("The class average is: "+classA);
                System.out.println("The highest grade is: "+max);
                System.out.println("The lowest grade is: "+min);
               
        }
       
       
       
    }
   
   
    public static double finalsGrade(double t1, double t2, double tFinal, double hw1, double hw2, double hw3, double hw4, double hw5, double hw6, double q1, double q2,int hwCount)
    {
        double test1 = t1*.10;
        double test2 = t2*.15;
        double finalTest = tFinal*.25;
       
        double quiz1 = q1*.01;
        double quiz2 = q2*.01;
       
        double x;
        boolean hw = true;
        while(hw)
        {
            if(hw6>hw5)
            {
                x=hw5;
                hw5=hw6;
                hw6=x;
            }
            if(hw5>hw4)
            {
                x=hw4;
                hw4=hw5;
                hw5=x;
            }
            if(hw4>hw3)
            {
                x=hw3;
                hw3=hw4;
                hw4=x;
            }    
            if(hw3>hw2)
            {
                x=hw2;
                hw2=hw3;
                hw3=x;
            }
            if(hw2>hw1)
            {
                x=hw1;
                hw1=hw2;
                hw2=x;
            }
            if(hw1<hw2)
            {
                x=hw2;
                hw2=hw1;
                hw1=x;
            }
            if(hw1>=hw2 && hw2>=hw3 && hw3>=hw4 && hw4>=hw5 && hw5>=hw6)
            {
                hw = false;
            }
           
        }
       
        double sum;
        sum=hw1+hw2+hw3+hw4;
        //System.out.println("The highest four homework grades are: "+hw1+"/"+hw2+"/"+hw3+"/"+hw4);
       
        double temp = 0;
        if(hwCount==6)
        {
            temp= (sum)*.12;
        }
        if(hwCount==5)
        {
            temp= (sum)*.115;
        }
        if(hwCount==4)
        {
            temp= (sum)*.10;
        }
        if(hwCount==3)
        {
            temp= (sum)*.075;
        }
       
        //System.out.println("Homework average is: "+temp);
       
       
        double finalScore = test1+test2+finalTest+quiz1+quiz2+temp;
        //System.out.println("The final score is: "+finalScore);
       
 
       
   
        return finalScore;
        
    }
    
}

    