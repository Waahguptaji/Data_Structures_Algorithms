/*
Assignment Coding Problem
Problem Name: Binary Search (Recursive)
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
#####Sample Output:
    3
 */
package Recursion2Assignment;

public class BinarySearchRecursive {
    public static int search(int input[], int elem, int start, int end){
        if (start >= end){
            return -1;
        }

        int mid = (start + end)/2;
        if (elem == input[mid]) {
            return mid;
        }
        else if(elem >= input[mid]){
            return search(input, elem, start, mid - 1);
            }
        else{
            return search(input, elem, mid+1, end);
        }
    }

    //helper Function
    public static int binarySearch(int input[], int elem){
        int start = 0;
        int end = input.length-1;
        return search(input,elem,start,end);
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,6,7};
        int index = binarySearch(input,4);
        System.out.println(index);

    }

}
