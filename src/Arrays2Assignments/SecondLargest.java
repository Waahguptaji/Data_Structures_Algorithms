package Arrays2Assignments;

import java.util.Scanner;

public class SecondLargest {
    public static void secondLargest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of the  TestCase: ");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the size of Array: ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < size - 1; j++) {
                for (int k = 0; k < size - j - 1; k++) {
                    if (arr[k] <= arr[k + 1]) { // Descending order
                        int temp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = temp;
                    }
                }
            }

            System.out.println(arr[1]);
        }


    }

    public static void main(String[] args) {
        secondLargest();

    }
}
