/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab6Part1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        double[] grades = new double[33];
        String[] names = new String[33];
        
        double min = 1000;
        double max = 0;
        double sumT = 0;
        
        if (fileFound)
        {
            while (inFile.hasNext())
            {
                try
                {
                names[0] = inFile.next();
                grades[0] = inFile.nextDouble();
                grades[1] = inFile.nextDouble();
                grades[2] = inFile.nextDouble();
                grades[3] = inFile.nextDouble();
                grades[4] = inFile.nextDouble();
                grades[5] = inFile.nextDouble();
                grades[6] = inFile.nextDouble();
                grades[7] = inFile.nextDouble();
                grades[8] = inFile.nextDouble();
                grades[9] = inFile.nextDouble();
                grades[10] = inFile.nextDouble();
                grades[11] = inFile.nextInt();
                names[1] = inFile.nextLine();
                char colon = ':';
                char comma = ',';
                String sp = " ";
                String output;
                
                double test1=grades[0]*.10;
                double test2=grades[1]*.15;
                double tFinal=grades[2]*.25;
                
                double allTest=test1+test2+tFinal;
                
                double quiz1=grades[9]*.01;
                double quiz2=grades[10]*.01;
                
                double allQuiz=quiz1+quiz2;
                
                double overAll=allTest+allQuiz;

                double temp = 0;
                boolean gradeHw = true;

            if (grades[8]>grades[7]) 
            {
                temp=grades[7];
                grades[7]=grades[8];
                grades[8]=temp;
            }
            if (grades[7]>grades[6])
            {
                temp=grades[6];
                grades[6]=grades[7];
                grades[7]=temp;
            }
            if (grades[6]>grades[5])
            {
                temp=grades[5];
                grades[5]=grades[6];
                grades[6]=temp;
            }
            if (grades[5]>grades[4])
            {
                temp=grades[4];
                grades[4]=grades[5];
                grades[5]=temp;
            }
            if (grades[4]>grades[3])
            {
                temp=grades[3];
                grades[3]=grades[4];
                grades[4]=temp;
            }
            if (grades[3]<grades[4])
            {
                temp=grades[4];
                grades[4]=grades[3];
                grades[3]=temp;
            }
            if (grades[3]>=grades[4] && grades[4]>=grades[5] && grades[5]>=grades[6] && grades[6]>=grades[7] && grades[7]>=grades[8])
            {
                gradeHw = false;
            }
            
            //System.out.println("Highest four homework grades: "+grades[3]+"/"+grades[4]+"/"+grades[5]+"/"+grades[6]);
            double totalHw=grades[3]+grades[4]+grades[5]+grades[6];
            
            double x=0;
            if(grades[11]==6)
            {
                x += totalHw*.12;
            }
            if(grades[11]==5)
            {
                x += totalHw*.115;
            }
            if(grades[11]==4)
            {
                x += totalHw*.10;
            }
            if(grades[11]==3)
            {
                x += totalHw*.075;
            }
            double totalScore=x;
            //System.out.println("Total homework score: "+totalScore);
                
            double finalScore=totalScore+overAll;
            //System.out.println("Final grade: "+finalScore);
            
            
            System.out.println("Student's grades: "+grades[0]+"/"+grades[1]+"/"+grades[2]+"/"+grades[3]+"/"+grades[4]+"/"+grades[5]+"/"+grades[6]+"/"+grades[7]+"/"+grades[8]+"/"+grades[9]+"/"+grades[10]);
            System.out.println(names[0]+comma+names[1]+colon+sp+finalScore);
            System.out.println();
            
            sumT+=finalScore;
            
            if(max<finalScore)
            {
                max=finalScore;
            }
            if(min>finalScore)
            {
                min=finalScore;
            }
            
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Error grade is invalid");
                }
              
                
            }
  
        double classAvg=0;
        classAvg=sumT/33;
        System.out.println("Class average: "+classAvg);
        System.out.println("Highest grade: "+max);
        System.out.println("Lowest grade: "+min);
        
        }
        
        
    }
    
}
