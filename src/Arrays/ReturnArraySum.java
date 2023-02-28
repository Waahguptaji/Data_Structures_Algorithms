package Arrays;

import java.util.Scanner;

public class ReturnArraySum {

    public static int arraySum(int t) {
        int Sum = 0;
        for (int i = 0; i < t; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Required Size of the Array: ");
            int N = sc.nextInt();
            int[] arr = new int[N];
            System.out.println("Enter the elements of Array: ");
            for (int j = 0; j < N; j++) {
                arr[i] = sc.nextInt();
            }
            for (int j = 0; j < arr.length; j++) {
                Sum = Sum + arr[i];
            }
        }
        return Sum;
    }

    public static void main(String[] args) {
        System.out.print(arraySum(2));
    }
}