/*
Problem Name: Last index of x
Problem Level: MEDIUM
Problem Description: ####Given an array of length N and an integer x, you need to find
and return the last index of integer x present in the array.
Return -1 if it is not present in the array.
####Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
####You should start traversing your array from 0, not from (N - 1).
####Do this recursively. Indexing in the array starts from 0.
*/
package Recursion1;

import java.util.Scanner;

public class LastIndex {

    public static int lastIndex(int input[], int startIndex, int x, int idx){

        if(startIndex == input.length ){
            return idx;
        }else if(input[startIndex] == x ){
            idx = startIndex;// here we are storing the value of the index of x in the array
                             // until it goes till the end the we are returning it.
        }

        return lastIndex(input,startIndex + 1, x, idx);

    }

    public static int lastIndex(int input[], int x) {
        return lastIndex(input,0,x, -1);//Here we takind idx as -1 because it worked both as a
                                                     // intializer and if index not find it returns -1 as says in the question.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] =new int[n];
        for (int i = 0; i < input.length ; i++) {
            input[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(lastIndex(input,x));
    }
}
