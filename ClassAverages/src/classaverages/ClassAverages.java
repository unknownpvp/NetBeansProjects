/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classaverages;

import java.util.*;
/**
 *
 * @author Danny
 */
public class ClassAverages {
    private static Formatter x;
    private int grades = 0;
    //private Scanner sc = new Scanner(System.in);
    //grades = sc.nextInt();



    public static void openFile(){
        try{
            x = new Formatter("scores.txt");
        }
       catch(Exception e) {
            System.out.println("This fine does not exist");
}
    }

    public static void addRecords() {
             int output = 0;
             int record;

             Scanner scanner = new Scanner(System.in);

             System.out.println("Enter 4 grades: ");
             Scanner sc = new Scanner(scanner.nextLine());
             record = scanner.nextInt();
             while (sc.hasNext()) {
             record = sc.nextInt();

             output += record;

        }

        x.format("%d%d%d%d", output );

    }

    public void closeFile(){
        x.close();
    }
    
    public static void main(String[] args) {

        openFile();
        addRecords();


        //public void 


    }

}