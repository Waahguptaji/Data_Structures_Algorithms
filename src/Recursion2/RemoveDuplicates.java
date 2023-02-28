/*
Coding Problem
Problem Name: Remove Duplicates
Problem Level: EASY
Problem Description: #### Given a string S, remove consecutive duplicates from it recursively.

##### Input Format :
    String S

##### Output Format :
    Output string*/
package Recursion2;

public class RemoveDuplicates {

    public static String removeDuplicates(String input){
        if (input.length() <= 1) {
            return input;
        }
        String smallOutput = removeDuplicates(input.substring(1));
        if (input.charAt(0) == input.charAt(1)) {
            return "" + smallOutput;
        }
        else {
            return input.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        String S1 = "xxxyyyzwwzzz";
        System.out.println(removeDuplicates(S1));
    }
}
