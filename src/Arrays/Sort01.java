package Arrays;

import java.util.Scanner;

public class Sort01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of t: ");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter the size of Array: ");
            int Size = sc1.nextInt();
            int arr[] = new int[Size];
            System.out.println("Enter the array: ");
            for (int j = 0; j < Size; j++) {
                arr[j] = sc1.nextInt();
            }
            // sorting
            int temp= 0;
            for ( int k = 0; k < arr.length -1; k++) {
                for (int l = 0; l < arr.length - k -1; l++) {
                    //swap
                    if (arr[l]>= arr[l+1]){
                        temp = arr[l];
                        arr[l] = arr[l+1];
                        arr[l+1] = temp;
                    }

                }

            }
            // printed the sorted element of array
            for (int k = 0; k < arr.length ; k++) {
                System.out.println(arr[k]);

            }

            }


        }


    }
