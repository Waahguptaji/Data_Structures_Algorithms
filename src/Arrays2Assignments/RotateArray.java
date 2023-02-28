//You have been given a random integer array/list(ARR) of size N.
// Write a function that rotates the given array/list by D elements(towards the left).
package Arrays2Assignments;

import java.util.Scanner;

public class RotateArray {
    public static void rotateArray(int arr[], int d, int n ){
            // Storing rotated version of array
            int temp[] = new int[n];

            int k = 0;// Keeping track of the current index of temp[]

        for (int i = d; i < n  ; i++) { // here we are storing the array in the temp arr starting from the d
            temp[k] = arr[i];
            k++;
        }

        for (int i = 0; i <d ; i++) {// here we are storing the start elements till d in the last of the temp[]
            temp[k] = arr[i];
            k++;
        }

        for (int i = 0; i < n ; i++) {//  // Copying the elements of temp[] in arr[] to get the final rotated array
            arr[i] = temp[i];
        }
        //for printing the array
        for (int i = 0; i <n; i++) {
            System.out.println(arr[i]);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements of Array: ");
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Value of d: ");
        int d = sc.nextInt();


        rotateArray(arr,d , n);

    }

    }
