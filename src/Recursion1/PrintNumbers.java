/*
* Problem Level: EASY
Problem Description: #### Given is the code to print numbers from 1 to n in increasing order recursively.
*But it contains few bugs that you need to rectify such that all the test cases pass.

##### Input Format :
    Integer n
##### Output Format :
    Numbers from 1 to n (separated by space)*/
package Recursion1;

import java.util.Scanner;

public class PrintNumbers {
    public static void printNumbers(int n) {
        //Base Case
        if (n <= 0){
            return;
        }else {
            //Recursively call print numbers
            printNumbers(n -1);
            //Print numbers while returning from recursion
            System.out.print(n + " " );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number n: ");
        int n = sc.nextInt();
        printNumbers(n);
    }

}
