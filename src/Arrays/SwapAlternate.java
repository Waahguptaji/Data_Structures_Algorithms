package Arrays;

import java.util.Scanner;

public class SwapAlternate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test case:");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter the size of the Array:");
            int size = sc1.nextInt();
            int arr[] = new int[size];
            System.out.println("enter the Elements:");
            for (int j = 0; j < size; j++) {
                arr[j] = sc1.nextInt();
            }
            int temp = 0;

            if (arr.length % 2 == 0) {
                for (int k = 0; k < arr.length; k = k + 2) {
                    temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
                else{
                    for (int l = 0; l < arr.length - 1; l = l + 2) {
                        temp = arr[l];
                        arr[l] = arr[l + 1];
                        arr[l + 1] = temp;
                    }
                }
                for (int j = 0; j < arr.length ; j++) {
                    System.out.println(arr[j]);
                }

            }
        }
    }
