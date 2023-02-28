/*
Problem Level: EASY
Problem Description: ####Given the code to find out and return the number of digits present in a number recursively.
 But it contains few bugs, that you need to rectify such that all the test cases should pass.

#####Input Format :
    Integer n

#####Output Format :
    Count of digits
 */

package Recursion1;

import java.util.Scanner;

public class NumberofDigits {
    public static int count(int n){
        //BAse Case
        if(n == 0){
            return  0;
        }
        int smallAns = count(n /10);// here we r storing the quotient and increasing the count until we get n ==0
        return smallAns +1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number n: ");
        int n = sc.nextInt();
        System.out.println(count(n));
    }
}
