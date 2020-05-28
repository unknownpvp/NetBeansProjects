/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part2;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab2Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /** ** **
            Declare the needed input object here using the names shown below in the program.   
            Also add any other needed lines to make the input object function.
       ** ** **/
        //input here should be "1310 or 1320"
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a 4-digit course number of 1310 or 1320: ");
        String courseNum = input.next();

        System.out.print("Please enter the current semester (Fall, Spring, or Summer): ");
        String sem = input.next();
        String dept = "CSE";
        char comma = ',';
        String sectionNum = "005";
        char dash = '-';
        int year = 2017;
        String sp = " ";
        String course;  // output should be semester, year, comma, space, 
                        // then dept, course number then section number
        course = sem+sp+year+comma+sp+dept+courseNum+dash+sectionNum;
                
        System.out.println("The course is "+course);  

    }
    
}
