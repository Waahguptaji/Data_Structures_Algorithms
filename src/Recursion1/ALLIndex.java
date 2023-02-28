/*
Problem Name: All indexes of x
Problem Level: MEDIUM
Problem Description: ####Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
####Do this recursively. Indexing in the array starts from 0.
*/
package Recursion1;

import java.util.Scanner;

public class ALLIndex {
    public static int[] allIndex(int input[], int startingIndex, int x, int fsf) {//fsf found so far
        //Base Case
        if (startingIndex == input.length) {// here we equal input.length because we want at this we stop not on -1.
            int iarr[] = new int[fsf]; // here we return a with having fsf as its length
            return iarr;
            }

        int iarr[] = new int[fsf];//this is array for storing the index of
        if (iarr[startingIndex] == x) {//if element in iarr is equal to x then we increase the fsf by + 1
                                      // and store the starting index in the fsf postion of iarr
            iarr = allIndex(input,startingIndex + 1, x ,fsf+1);
            iarr[fsf] = startingIndex;
        }else {
            iarr =allIndex(input, startingIndex +1, x, fsf);
        }
        return iarr;
    }

    public static int[] allIndex(int input[], int x ){//helper function to set the value of starting index and i
        return allIndex(input,0,x,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] =new int[n];
        for (int i = 0; i < input.length ; i++) {
            input[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(allIndex(input,x));
    }
}
