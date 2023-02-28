/*
Problem Level: EASY
Problem Description: ####Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
####Do this recursively.
*/
package Recursion1;

import java.util.Scanner;

public class CheckNumRecursively {
    public static boolean checkNum( int x,int n,int input[]){
        //Base Condition
        if (n <= 0 ){
            return false;
        }

        if (input[n-1] == x){
            return true;
        }
        return checkNum(x,n-1, input );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] =new int[n];
        for (int i = 0; i < input.length ; i++) {
            input[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(checkNum(x,n,input));
    }
}
