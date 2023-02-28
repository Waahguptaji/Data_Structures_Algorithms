package Searching_Sorting;

import java.util.Scanner;

public class BubbleSort {
    public  static void bubbleSorting(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int input[] = new int[size];
        System.out.println("Enter the element of array: ");
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        // Logic
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i -1 ; j++) {
                int temp = 0;
                if(input[j] >= input[j+1]){
                    //swap
                    temp = input[j];
                    input[j] = input[j+1];
                    input[j +1] = temp;

                }
            }
        }
        for (int j = 0; j <size ; j++) {
            System.out.println(input[j]);
        }
    }

    public static void main(String[] args) {
        bubbleSorting();
    }

}
