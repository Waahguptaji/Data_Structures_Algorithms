package Searching_Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the element of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // Main Logic
        for (int i = 1; i < size ; i++) {
            int j = i - 1; // the sorted element
            int current = arr[i];
            while (j >= 0 && arr[j] > current) { // for Shifting
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        for (int i = 0; i <size ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        insertionSort();

    }
}
