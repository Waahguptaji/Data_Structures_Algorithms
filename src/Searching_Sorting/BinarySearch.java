/*
Assignment Coding Problem
Problem Name: Binary Search
Problem Level: MEDIUM
Problem Description: ####Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
#####Return -1 if x is not present in the given array.

#####Note : If given array size is even, take first mid.

`Input format : `

`Line 1 : Array size`

`Line 2 : Array elements (separated by space)`

`Line 3 : x (element to be searched)`
 #####Sample Input :
    6
    2 3 4 5 6 8
    5
*/
package Searching_Sorting;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch( int arr[], int elem){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (elem == arr[mid]){
                return mid;
            } else if (elem > arr[mid]){ // we have to search the element in right
                start = mid +1;
            } else { //we have to search the element in left
                end = mid -1;
            }
        }
        return -1; // if you don't find the element
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int index = binarySearch(arr,0);
        System.out.println(index);
    }

}








    
