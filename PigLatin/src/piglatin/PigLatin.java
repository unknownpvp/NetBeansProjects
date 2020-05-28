/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piglatin;
import java.util.Scanner;
/**
 *
 * @author Danny
 */
public class PigLatin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Scanner sentence = new Scanner(System.in);
        String concatedString1="";
        StringBuffer encryptedString=new StringBuffer();
        System.out.println("Enter the word to be converted.");
        String input = sentence.nextLine();
        String[] words = input.split("\\s");
        for(String word:words)
        {
           int numberOfSpacesadd=1;
           String subs=word.substring(0, 1);//to split the first letter
           String s1=word.substring(1);//to split the after the first letter
           String concatedString=s1+subs;
           concatedString1=concatedString+"ay";//to add the adding phrase
           String addSpace = String.format("%"+ numberOfSpacesadd +"s", " ");//for adding the space after the word
           encryptedString.append(concatedString1+addSpace);  
        } 
        System.out.println(encryptedString.toString().trim()+"?");
    }*/
        
        Scanner scanner = new Scanner(System.in);
        String output = "";
        int i;
        System.out.println("Enter a phrase: ");
        String name = scanner.nextLine();
        String[] words = name.split("\\s");
        
        for(i=0;i<name.length();i++)
        {
            String subs = name.substring(0,1);
            String s1 = name.substring(1);
            String phrase = s1+subs;
            output += pigLatin(phrase);
        }
        System.out.println(output);
        //System.out.println(name);
        /*while(scanner.hasNextLine()) 
        {
            Scanner sc = new Scanner(scanner.nextLine());
            while (sc.hasNext()) 
            {
                name = sc.next();
                output = pigLatin(name) + ""; 
                System.out.println(output);
            }
        }*/
    }

    static String pigLatin(String name) {
        String consonant = "bcdfghjklmnpqrstvwxyz";
        String vowel = "aeiouAEIOU";
        char firstChar = name.charAt(0);
        String name2 = name.substring(1,name.length()) + Character.toString(firstChar);

        //String name2 = Character.toString(firstChar);
        String ending = "ay";
        String ending1 = "way";
        String name3 = name + ending1;


        for (int count = 0; count < consonant.length() ; count++ ) {
            if (firstChar == consonant.charAt(count)) {


                //System.out.println(name2 + ending);
            return name2 + ending;}

        }
        for (int i = 0; i < vowel.length() - 1; i++ ) {
            if (firstChar == vowel.charAt(i)) {
                //System.out.println(name3);

            return name3;}
        }
    return null;}


}
