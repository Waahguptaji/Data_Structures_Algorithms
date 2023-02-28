/*
Problem Name: Reverse Each Word
Problem Level: MEDIUM
Problem Description: #### Given a string S, reverse each word of a string individually. For eg. if a string is "abc def", reversed string should be "cba fed".

##### Input Format :
    String S

##### Output Format :
    Modified string
    */
package StringsAssignments;

import java.util.Scanner;

public class ReverseEachWord {
    public static void reverseEachWord(String input){
        //Split strings in to words
        String[] words = input.split(" ");
        // creating a reversestring to store the reverse word in it.
        String reverseString = "";
        for (int i = 0; i < words.length ; i++) {
            //Taking each word and Reversing it.
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0  ; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            // Appending reverseWord to reverseString
            reverseString = reverseString + reverseWord +  " ";
        }
        System.out.println(input);
        System.out.println("-----------------------");
        System.out.print(reverseString);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String input = sc.nextLine();
        reverseEachWord(input);
    }
}
