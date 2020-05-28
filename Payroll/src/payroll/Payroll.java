/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import java.util.Scanner;
/**
 *
 * @author Danny
 */
public class Payroll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int employees;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Payroll!");
        System.out.print("Please enter the number of employees: ");
        employees = input.nextInt();
        
        bonus(employees);
    }
    
    public static int bonus(int employees)
    {
        int i = 0,j = 1,time = 0,bonusPay = 0;
        double pay = 0,newPay = 0;
        Scanner sc = new Scanner(System.in);
        for(i=0,j=1;i<employees;i++,j++)
        {
            System.out.print("Please enter employee "+j+"'s monthly pay: ");
            pay = sc.nextDouble();
            System.out.print("Please enter the amount of years employee "+j+" has worked: ");
            time = sc.nextInt();
            
            if(time>=0 && time<=4)
            {
                newPay = pay + pay*0.05;
                bonusPay = 5;
            }
            else if(time>=5 && time<=9)
            {
                newPay = pay + pay*0.10;
                bonusPay = 10;
            }
            else if(time>=10)
            {
                newPay = pay + pay*0.15;
                bonusPay = 15;
            }
            else
            {
                System.out.println("Error. Employee does not work here.");
            }
            System.out.println("Employee "+j+" receives a "+bonusPay+"% bonus,bringing his monthly pay to $"+newPay+"");
        }
        return 0;
    }
}
