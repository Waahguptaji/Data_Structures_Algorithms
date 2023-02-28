/*
* Problem Level: EASY
Problem Description: ####Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
####Do this recursively.*/
package Recursion1;

import java.util.Scanner;

public class XpowerN {
    public static int power(int x, int n){
        //Base case
        if(n == 0){
            return 1;
        }

        int smallAns = power(x, n-1);
        return x * smallAns;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the value of X: ");
        int x = sc.nextInt();
        System.out.println("Enter the Power n : ");
        int n = sc.nextInt();
        System.out.println(power(x,n));
    }

}
