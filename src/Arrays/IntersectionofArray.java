package Arrays;

import java.util.Scanner;

public class IntersectionofArray {
    public static void testCase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of t: ");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter the size of Array1: ");
            int Size1 = sc.nextInt();
            System.out.println("Enter the size of Array2: ");
            int Size2 = sc.nextInt();
            int arr1[] = new int[Size1];
            int arr2[] = new int[Size2];
            System.out.println("Enter the Elements array1: ");
            for (int j = 0; j < Size1; j++) {
                arr1[j] = sc.nextInt();
            }
            System.out.println("Enter the Elements array2: ");
            for (int k = 0; k < Size2; k++) {
                arr2[k] = sc.nextInt();
            }

            //Main Logic
            for (int j = 0; j < Size1; j++) {
                for (int k = 0; k <Size2 ; k++) {
                    if (arr1[j] == arr2[k]) {
                        System.out.println(arr2[k]);
                    }
                }


            }
        }
    }

            public static void main(String[] args) {
                testCase();


            }





}
