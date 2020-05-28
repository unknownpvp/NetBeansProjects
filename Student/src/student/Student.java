/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Danny
 */
public class Student {
    private static String name;
    private static double gpa;
    private static int grade;

    static void enroll(String name, double gpa,int grade){
        // System.out.println("Enter Student's name:");
        // System.out.println(name);

        System.out.println("Student's name: " + name);
        // System.out.println("Enter Student's gpa:")
        // System.out.println(gpa);

        System.out.println("Student's gpa: " + gpa);

        // System.out.println("Enter Student's grade:");
        // System.out.println(grade);

        System.out.println("Student's grade: " + grade);
    }
    static void displayInfo() {
        System.out.println(name +" has a gpa of " + gpa + " and is in grade " + grade + ".");
    }
    static void Student() {
        String name = "";
        double gpa = 0.0;
        int grade = 0;
        System.out.println("Student's name is " + name);
        System.out.println("Student's gpa: " + gpa);
        System.out.println("Student's grade: " + grade);
    }
   
    public static void main(String[] args) {
   
    String name1;
    double gpa1;
    int grade1;

    name = "Cliffy K.";
    gpa = 3.5;
    grade = 11;

    enroll(name,gpa,grade);
    displayInfo();

    name1 = "Bob";
    gpa1 = 2.2;
    grade1 = 12;
    
    enroll(name1,gpa1,grade1);
    }
}