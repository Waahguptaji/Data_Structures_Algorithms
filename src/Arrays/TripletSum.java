package Arrays;

import java.util.Scanner;

public class TripletSum {
    public static void Triplet(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of t: ");
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
        System.out.println("Enter the size of Array: ");
        int Size = sc.nextInt();
        System.out.println("Enter the value of X: ");
        int x = sc.nextInt();
        int arr[] = new int[Size];
        System.out.println("Enter the Elements array: ");
        for (int j = 0; j < Size; j++) {
            arr[j] = sc.nextInt();
        }

        //Main Logic -- traversal
        int count =0;
        for (int j = 0; j < Size ; j++) {
            for (int k = j + 1; k < Size; k++) {
                for (int l = k + 1; l <Size; l++) {

                    if (arr[j] + arr[k] + arr[l] == x) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

    public static void main(String[] args) {
        Triplet();

    }
}
