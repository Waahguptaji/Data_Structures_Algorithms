/*
Problem Name: Multiplication (Recursive)
Problem Level: MEDIUM
Problem Description: #### Given two integers M & N, calculate and return their multiplication using recursion.
You can only use subtraction and addition for your calculation. No other operators are allowed.
*/
package Recursion1Assignment;

import java.util.Scanner;

public class Mutilpication {
    public static int multiplication(int M, int N){
        //BaseCase
        if ( N == 0 ) {
            return 0;
        }
       return M + multiplication(M,N-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(multiplication(M, N));
    }
}
