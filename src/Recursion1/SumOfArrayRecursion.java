/*
* Problem Name: Sum of array (recursive)
Problem Level: EASY
Problem Description: #### Given an array of length N, you need to find and return the sum of all elements of the array.
####Do this recursively.
*/
package Recursion1;

public class SumOfArrayRecursion {
    public static int Sum(int arr[], int n){
        //base or terminating condition
        if (n <= 0) {  //base case
            return 0;
        }
        return Sum(arr, n-1 ) + arr[n-1];  //Recursive call
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 5};
        int sum = Sum(arr, arr.length);
        System.out.println(sum);
    }
}

