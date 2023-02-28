/*
* Coding Problem
Problem Name: Replace character recursively
Problem Level: EASY
Problem Description: ####Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
####Do this recursively.

#####Input Format :
    Line 1 : Input String S
    Line 2 : Character c1 and c2 (separated by space)

#####Output Format :
    Updated string
    * */
package Recursion2;

public class ReplaceCharacter {
    public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() <= 1) {
            return input;
        }

        String smallOutput = replaceCharacter(input.substring(1), c1, c2);
        if (input.charAt(0) == c1) {
            return c2 + smallOutput;
        } else {
            return input.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        String input = "abacd";
        char c1 = 'a';
        char c2 = 'x';
        System.out.println(replaceCharacter(input, c1, c2));
    }
}
