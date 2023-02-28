/*
Problem Name: Check Palindrome (recursive)
Problem Level: MEDIUM
Problem Description: #### Check whether a given String S is a palindrome using recursion. Return true or false.

##### Input Format :
    String S

##### Output Format :
    'true' or 'false'
    */
package Recursion1Assignment;

import java.util.Scanner;

public class PalindromeRecursively {
    public static boolean isPalindrome(String str, int startidx, int endidx){
        //base
        if( startidx >= endidx){
            return true;
        }
        
        boolean check = true;
        if (str.charAt(startidx) == str.charAt(endidx)) {// if true check krte jaaa
            check = isPalindrome(str, startidx +1, endidx -1);
        }
        else {
            check = false;
        }
        return check;
    }

    //Method Overloading for helping function
    public static boolean isPalindrome(String str) {
    return isPalindrome(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(isPalindrome(str));
    }
}
