package Arrays2Assignments;

import java.util.Scanner;

public class CheckArrayRotation {
    public static void checkArrayRotation(int[] arr, int n) {
        int i = 0;
        int count = 0;
        while (arr[i] < arr[i+ 1]) {
                    i++;
                    count++;
                }
        System.out.println(n - count -1);
    }

            public static void main (String[]args){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the Size of Array: ");
                int n = sc.nextInt();
                int arr[] = new int[n];
                System.out.println("enter the elements of Array: ");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                checkArrayRotation(arr, n);
            }
        }
