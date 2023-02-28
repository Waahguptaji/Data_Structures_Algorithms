/*
Problem Name: First Index
Problem Level: EASY
Problem Description: ####Given an array of length N and an integer x,
 you need to find and return the first index of integer x present in the array.
 Return -1 if it is not present in the array.
####First index means, the index of first occurrence of x in the input array.
####Do this recursively. Indexing in the array starts from 0.
*/
package Recursion1;

import java.util.Scanner;

public class FirstIndex {
    public static  int firstIndex(int input[], int startingIndex, int x){
       //Two Base Case
        if (startingIndex == input.length) {
            return -1;
        }


        if(input[startingIndex] == x){
            return startingIndex;
        }
        return firstIndex(input,startingIndex + 1,x );
    }

    //Here we do this function overloading because we donot want to take the starting index from user.
    // so we give it to the function already
    public static int firstIndex(int input[], int x){
        return firstIndex(input, 0, x);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] =new int[n];
        for (int i = 0; i < input.length ; i++) {
            input[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(firstIndex(input,x));
    }
}
