package Arrays2Assignments;

import java.util.Scanner;

public class sort012 {
    public static void Sort012(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex !=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);

        }


    }

    public static void main(String[] args) {
        Sort012();
    }
}
