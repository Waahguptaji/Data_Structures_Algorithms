/*
Problem Name: Sum of digits (recursive)
Problem Level: MEDIUM
Problem Description: #### Write a recursive function that returns the sum of the digits of a given integer.

##### Input format :
    Integer N
##### Output format :
    Sum of digits of N
*/
package Recursion1Assignment;

import java.util.Scanner;

public class SumofDigits {
    public static int sumOfDigits(int n){
        if (n == 0) {
            return 0;
        }

        int smallAns = sumOfDigits(n/10);
        return n%10 + smallAns;
        //Working
//        The step-by-step process for a better understanding of how the algorithm works.
//        Let the number be 12345.
//        Step 1-> 12345 % 10 which is equal-too 5 + ( send 12345/10 to next step )
//        Step 2-> 1234 % 10 which is equal-too 4 + ( send 1234/10 to next step )
//        Step 3-> 123 % 10 which is equal-too 3 + ( send 123/10 to next step )
//        Step 4-> 12 % 10 which is equal-too 2 + ( send 12/10 to next step )
//        Step 5-> 1 % 10 which is equal-too 1 + ( send 1/10 to next step )
//        Step 6-> 0 algorithm stops
//        following diagram will illustrate the process of recursion
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the Power n : ");
        int n = sc.nextInt();
        System.out.println(sumOfDigits(n));
    }

}
